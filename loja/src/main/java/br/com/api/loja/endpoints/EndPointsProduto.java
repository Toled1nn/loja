package br.com.api.loja.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.loja.classes_avulsas.CadastroGeral;
import br.com.api.loja.entidades.Produto;
import br.com.api.loja.jpa.ProdutoJPA;

@RestController
public class EndPointsProduto {
	
	@Autowired
	private  ProdutoJPA produtoJPA;
	
	@PostMapping(value = "cadastrarNovoProduto")
    @ResponseBody
    public ResponseEntity<?> cadastrarNovoProduto(@RequestBody Produto prod){		
		List<String> validacoes = CadastroGeral.getInstance().cadastroProduto(prod);
		if(validacoes.isEmpty()) {
			
			Produto pro = new Produto.ProdutoBuilder()
			 .codigoProduto(prod.getCodigoProduto())
			 .nome(prod.getNome())
			 .precoProduto(prod.getPrecoProduto())
			 .quantidadeEstoque(prod.getQuantidadeEstoque())
			 .build();
			pro = produtoJPA.save(pro);
			return new ResponseEntity<Produto>(pro, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<List<String>>(validacoes, HttpStatus.OK);
		}
			
    }
	
	@GetMapping(value = "listarEstoque")
    @ResponseBody 
    public ResponseEntity<List<Produto>> listarEstoque(){
    	List<Produto> produtos = produtoJPA.findAll();
    	return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }
	
	@DeleteMapping(value = "deletarProdutoEstoque")
    @ResponseBody
	public ResponseEntity<String> deletarProdutoEstoque(@RequestParam(name = "idProduto") Long idProduto){
		Produto produtoDel = produtoJPA.findById(idProduto).get();
		if(produtoDel == null) {
			return new ResponseEntity<String>("Este produto não existe", HttpStatus.OK);
		}
    	
	 	if(produtoJPA.verificaProdutoCarrinho(produtoDel.getNome()) == null || produtoJPA.verificaProdutoCarrinho(produtoDel.getNome()).isEmpty() ) {
	 		produtoJPA.deleteById(produtoDel.getCodigoProduto());
	 		return new ResponseEntity<String>("Produto Deletado", HttpStatus.OK);
	 	}else {
	 		return new ResponseEntity<String>("Produto Não pode ser excluido", HttpStatus.OK);
	 	}
    	
    }
	
	@PutMapping(value = "atualizarDadosProduto")
    @ResponseBody 
    public ResponseEntity<?> atualizarDadosProduto(@RequestBody Produto prod){
		List<String> validacoes = CadastroGeral.getInstance().cadastroProduto(prod);
		if(validacoes.size() < 1) {
			Produto pro = new Produto.ProdutoBuilder()
					 .codigoProduto(prod.getCodigoProduto())
					 .nome(prod.getNome())
					 .precoProduto(prod.getPrecoProduto())
					 .quantidadeEstoque(prod.getQuantidadeEstoque())
					 .build();
			pro = produtoJPA.saveAndFlush(pro);
			return new ResponseEntity<Produto>(pro, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<String>>(validacoes, HttpStatus.OK);
		}
    }

}
