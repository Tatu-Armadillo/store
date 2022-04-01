package br.com.dedo.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dedo.store.model.Fornecedor;
import br.com.dedo.store.repository.FornecedorRepository;

@Service
public class FornecedorService {

    private Fornecedor fornecedor;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> listFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> getFornecedor(Long idFornecedor) {
        return fornecedorRepository.findById(idFornecedor);
    }

    public Fornecedor saveFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedorRepository.save(fornecedor);
        return this.fornecedor;
    }

    public void updateFornecedor(Long idFornecedor, Fornecedor fornecedor) {
        this.fornecedor = fornecedorRepository.getById(idFornecedor);
        this.fornecedor.setNomeFornecedor(fornecedor.getNomeFornecedor());
    }

    public void deleteFornecedor(Long idFornecedor) {
        fornecedorRepository.deleteById(idFornecedor);
    }

}
