package br.com.api.loja.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.loja.entidades.Cliente;


@Repository
public interface ClienteJPA extends JpaRepository<Cliente, Long> {
		

}
