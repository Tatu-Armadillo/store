package br.com.dedo.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dedo.store.model.Endereco;
import br.com.dedo.store.repository.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco getEndereco(Long idEndereco) {
        return enderecoRepository.getById(idEndereco);
    }

    public Endereco saveEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deleteEndereco(Long idFornecedor) {
        enderecoRepository.deleteById(idFornecedor);
    }

}
