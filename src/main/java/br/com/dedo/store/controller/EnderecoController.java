package br.com.dedo.store.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dedo.store.model.Endereco;
import br.com.dedo.store.repository.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> viewEnderecos() {
        return enderecoRepository.findAll();
    }
    
    @GetMapping("/{idEndereco}")
    public ResponseEntity<Endereco> datailsEndereco(@PathVariable Long idEndereco) {
        Optional<Endereco> endereco = enderecoRepository.findById(idEndereco);
        if (endereco.isPresent()) {
            return ResponseEntity.ok(endereco.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public void createEndereco(@RequestBody @Valid Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    @DeleteMapping("/{idEndereco}")
    @Transactional
    public void removeEndereco(@PathVariable Long idEndereco) {
        enderecoRepository.deleteById(idEndereco);

    }



}
