package br.com.dedo.store.controller.fornecedores;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dedo.store.model.Fornecedor;
import br.com.dedo.store.service.FornecedorService;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorRestController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> viewFornecedores() {
        return fornecedorService.listFornecedores();
    }

    @GetMapping("/{idFornecedor}")
    public ResponseEntity<Fornecedor> datailsFornecedor(@PathVariable Long idFornecedor) {
        Optional<Fornecedor> fornecedor = fornecedorService.getFornecedor(idFornecedor);
        if (fornecedor.isPresent()) {
            return ResponseEntity.ok(fornecedor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public Fornecedor registerFornecedor(@RequestBody @Valid Fornecedor fornecedor) {
        return fornecedorService.saveFornecedor(fornecedor);
    }

    @PutMapping("/{idFornecedor}")
    @Transactional
    public Fornecedor updateFornecedor(@PathVariable Long idFornecedor,
            @RequestBody Fornecedor fornecedor) {
        fornecedorService.updateFornecedor(idFornecedor, fornecedor);
        return fornecedor;
    }

    @DeleteMapping("/{idFornecedor}")
    @Transactional
    public ResponseEntity<?> removeFornecedor(@PathVariable Long idFornecedor) {
        fornecedorService.deleteFornecedor(idFornecedor);
        return ResponseEntity.ok().build();
    }

}
