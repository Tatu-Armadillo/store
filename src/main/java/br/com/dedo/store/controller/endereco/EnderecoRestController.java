package br.com.dedo.store.controller.endereco;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dedo.store.model.Endereco;
import br.com.dedo.store.service.EnderecoService;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoRestController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> viewEnderecos() {
        return enderecoService.listEnderecos();
    }

    @PostMapping
    @Transactional
    public void createEndereco(@RequestBody @Valid Endereco endereco) {
        enderecoService.saveEndereco(endereco);
    }

    @DeleteMapping("/{idEndereco}")
    @Transactional
    public void removeEndereco(@PathVariable Long idEndereco) {
        enderecoService.deleteEndereco(idEndereco);
    }

}
