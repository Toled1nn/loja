package br.com.api.loja.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.api.loja.entidades.EnderecoCliente;



@Repository
public interface EnderecoClienteJPA extends JpaRepository<EnderecoCliente, Long>{
	
	@Query(value = "select ed from EnderecoCliente ed left join ed.clienteRelacionado cli where cli.id = :idCliente ")
	EnderecoCliente buscaEnderecoPorCliente(@Param("idCliente") Long idCliente);

	

}
