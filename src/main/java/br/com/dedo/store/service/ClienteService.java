package br.com.dedo.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dedo.store.model.Cliente;
import br.com.dedo.store.repository.ClienteRepository;

@Service
public class ClienteService {

    private Cliente cliente;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listClientes() {
        return clienteRepository.findAll();
    }

    public Cliente saveCliente(Cliente cliente) {
        this.cliente = clienteRepository.save(cliente);
        return this.cliente;
    }

    public void updateCliente(Long idCliente, Cliente cliente) {
        this.cliente = clienteRepository.getById(idCliente);
        this.cliente.setNome(cliente.getNome());
        this.cliente.setTelefone(cliente.getTelefone());
    }

    public Optional<Cliente> getCliente(Long idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        return cliente;
    }

}
