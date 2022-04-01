package br.com.dedo.store.controller.produto;

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

import br.com.dedo.store.model.Produto;
import br.com.dedo.store.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoRestController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> viewProduto() {
        return produtoService.listProdutos();
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<Produto> datailsProdutos(@PathVariable Long idProduto) {
        Optional<Produto> produto = produtoService.detailsProduto(idProduto);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public Produto registerProduto(@RequestBody @Valid Produto produto) {
        return produtoService.saveProduto(produto);
    }

    @PutMapping("/{idProduto}")
    @Transactional
    public Produto updateProduto(@PathVariable Long idProduto,
            @RequestBody Produto produto) {
        produtoService.updateProduto(idProduto, produto);
        return produto;
    }

    @DeleteMapping("/{idProduto}")
    @Transactional
    public ResponseEntity<?> removeProduto(@PathVariable Long idProduto) {
        produtoService.deleteProduto(idProduto);
        return ResponseEntity.ok().build();
    }

}
