package br.com.api.loja.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.api.loja.entidades.CarrinhoCliente;

@Repository
public interface CarrinhoClienteJPA extends JpaRepository<CarrinhoCliente, Long>{
	
	@Query(value = "select car from CarrinhoCliente car where car.id = :id and car.processoCarrinho = 2")
	CarrinhoCliente buscaCarrinhoFinalizado(@Param("id") Long id);

}
