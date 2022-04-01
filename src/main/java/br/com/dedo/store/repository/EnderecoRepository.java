package br.com.dedo.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dedo.store.model.Endereco;
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
