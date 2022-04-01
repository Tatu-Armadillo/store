package br.com.dedo.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dedo.store.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
