package br.com.dedo.store.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.dedo.store.model.Cliente;
import br.com.dedo.store.repository.ClienteRepository;
import br.com.dedo.store.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> viewClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> datilsClientes(@PathVariable Long idCliente) {
        Optional<Cliente> cliente = clienteService.getCliente(idCliente);
        if (cliente.isPresent()) {
            return ResponseEntity.ok().body(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public Cliente createCliente(@RequestBody @Valid Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @PutMapping("/{idCliente}") 
    @Transactional
    public Cliente updateCliente(@PathVariable Long idCliente, @RequestBody Cliente cliente) {
        clienteService.updateCliente(idCliente, cliente);
        cliente.setIdCliente(idCliente);
        return cliente;
    }

    @DeleteMapping("/{idCliente}")
    @Transactional
    public ResponseEntity<?> removeCliente(@PathVariable Long idCliente) {
        clienteRepository.deleteById(idCliente);
        return ResponseEntity.ok().build();
    }

}
