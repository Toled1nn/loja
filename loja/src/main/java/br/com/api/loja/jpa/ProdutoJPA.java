package br.com.api.loja.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.api.loja.entidades.Produto;

@Repository
public interface ProdutoJPA extends JpaRepository<Produto, Long>{
	
	@Query(nativeQuery = true, value = "select car.produtos from carrinho_cliente_produtos car where car.produtos like :nomeProduto limit 1")
	String verificaProdutoCarrinho(@Param("nomeProduto") String nomeProduto);

}
