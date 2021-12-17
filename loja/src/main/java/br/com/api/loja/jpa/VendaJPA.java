package br.com.api.loja.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.api.loja.entidades.Venda;


@Repository
public interface VendaJPA extends JpaRepository<Venda, Long>{
		
	@Query(value = "select vend from Venda vend left join vend.clienteVenda cli where cli.id = :idCliente ")
	Venda buscaEnderecoPorCliente(@Param("idCliente") Long idCliente);

}
