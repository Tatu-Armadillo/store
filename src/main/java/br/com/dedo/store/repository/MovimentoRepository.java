package br.com.dedo.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dedo.store.model.Movimento;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long>{
    
}
