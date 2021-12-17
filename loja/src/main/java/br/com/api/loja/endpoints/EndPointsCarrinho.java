package br.com.api.loja.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.loja.classes_avulsas.ControladorSessao;
import br.com.api.loja.entidades.CarrinhoCliente;
import br.com.api.loja.entidades.Cliente;
import br.com.api.loja.entidades.EnderecoCliente;
import br.com.api.loja.entidades.Produto;
import br.com.api.loja.entidades.Venda;
import br.com.api.loja.jpa.CarrinhoClienteJPA;
import br.com.api.loja.jpa.ClienteJPA;
import br.com.api.loja.jpa.EnderecoClienteJPA;
import br.com.api.loja.jpa.ProdutoJPA;
import br.com.api.loja.jpa.VendaJPA;


@RestController
public class EndPointsCarrinho {
	
	@Autowired
	private CarrinhoClienteJPA carrinhoJPA;
	
	@Autowired
	private ProdutoJPA produtoJPA;
	
	@Autowired
	private EnderecoClienteJPA enderecoClienteJPA;
	
	@Autowired
	private VendaJPA vendaJPA;
	
	@Autowired
	private ClienteJPA clienteJPA;
	
	@PostMapping(value = "iniciaCompra")
    @ResponseBody
    public ResponseEntity<?> cadastrarCarrinho(
    		@RequestParam (name = "idCarrinhoCliente")Long idCarrinhoCliente,
    		@RequestParam (name = "idCliente")Long idCliente, 
    		@RequestParam (name = "idVenda")Long idVenda,
    		@RequestParam (name = "idEnderecoCobranca")Long idEnderecoCobranca,
    		@RequestParam (name = "idEnderecoEntrega")Long idEnderecoEntrega){
		Cliente cli = clienteJPA.findById(idCliente).get();
		if(cli == null) {
			return new ResponseEntity<String>("Cliente não cadastrado", HttpStatus.OK);
		}
		EnderecoCliente endCobrancaCliente = enderecoClienteJPA.findById(idEnderecoCobranca).get();
		if(endCobrancaCliente == null) {
			return new ResponseEntity<String>("Endereco de Cobranca Não existente", HttpStatus.OK);
		}
		EnderecoCliente endEntregaCliente = enderecoClienteJPA.findById(idEnderecoCobranca).get();
		if(endEntregaCliente == null) {
			return new ResponseEntity<String>("Endereco de Entrega não existe", HttpStatus.OK);
		}
		Venda venda = vendaJPA.findById(idVenda).get();
		if(venda == null) {
			return new ResponseEntity<String>("Venda não existente", HttpStatus.OK);
		}
		if(idCarrinhoCliente == null||idCarrinhoCliente == 0 ) {
			return new ResponseEntity<String>("Código de Carrinho inválido", HttpStatus.OK);
		}
			
			CarrinhoCliente carrinhoCadastrar = new CarrinhoCliente.CarrinhoClienteBuilder()
			.idCarrinho(idCarrinhoCliente)
			.cupomDesconto(0)
			.precoTotal(0)
			.enderecoEntrega(endEntregaCliente)
			.enderecoCobranca(endCobrancaCliente)
			.venda(venda)
			.processoCarrinho(0)
			.cliente(cli)
			.qtdTotalProdCarrinho(0)
			.build();
			
			carrinhoCadastrar = carrinhoJPA.save(carrinhoCadastrar);
			
			return new ResponseEntity<CarrinhoCliente>(carrinhoCadastrar, HttpStatus.CREATED);

    }
	
	@PutMapping(value = "adicionarProdutoCarrinho")
    @ResponseBody
    public ResponseEntity<?> adicionarProdutoCarrinho(@RequestParam Long idCarrinho,@RequestParam Long codProduto,@RequestParam int qtd){
		Produto prod = produtoJPA.findById(codProduto).get();
		if(prod == null)
			return new ResponseEntity<String>("Produto não cadastrado", HttpStatus.OK);
		CarrinhoCliente car = carrinhoJPA.findById(idCarrinho).get();
		if(car == null)
			return new ResponseEntity<String>("Carrinho não cadastrado", HttpStatus.OK);
		if(car.getProcessoCarrinho() != 2) {
			if(car.verificaProdutoAdicionadoCarrinho(car.getProdutos(), prod.getNome())) {
				car.setProdutos(car.removeProdLista(car.getProdutos(), prod.getNome()));
				car.setProdutos(car.adicionaProdutos(car.getProdutos(), prod.getNome(), qtd));
				car.setQtdTotalProdCarrinho(car.calculaQtdProdutoCarrinho(car.getProdutos())); 
				
			}else {
				car.setProdutos(car.adicionaProdutos(car.getProdutos(), prod.getNome(), qtd));
				car.setQtdTotalProdCarrinho(car.calculaQtdProdutoCarrinho(car.getProdutos())); 
				car.setProcessoCarrinho(1);
			}
			car = carrinhoJPA.saveAndFlush(car);
			
			return new ResponseEntity<CarrinhoCliente>(car, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Carrinho Já foi finalizada a Compra", HttpStatus.OK);
		}

		
    }
	
	@PostMapping(value = "imprimeDadosCompra")
    @ResponseBody
    public ResponseEntity<?> mostraDadosCompra(@RequestBody Long idCarrinho){
		List<String> dadosCompra = new ArrayList<String>();
		CarrinhoCliente car = carrinhoJPA.findById(idCarrinho).get();
		if(car == null)
			return new ResponseEntity<String>("Carrinho não cadastrado", HttpStatus.OK);
		if(!(ControladorSessao.getInstance().verificaAutenticacao(car.getCliente().getNome())))
			return new ResponseEntity<String>("Usuario não está autenticado", HttpStatus.OK);
		Cliente cliente = clienteJPA.findById(car.getCliente().getId()).get();
		//EnderecoCliente end = enderecoClienteJPA.buscaEnderecoPorCliente(cliente.getId());
		//Venda venda = vendaJPA.buscaEnderecoPorCliente(cliente.getId());
		
		dadosCompra.add(car.toString());
		dadosCompra.add(cliente.toString());
		dadosCompra.add(car.getVenda().toString());
		dadosCompra.add(car.getEnderecoCobranca().toString());
		dadosCompra.add(car.getEnderecoEntrega().toString());
		
		return new ResponseEntity<List<String>>(dadosCompra,HttpStatus.OK);
	}
	
	@PutMapping(value = "cancelaCompra")
    @ResponseBody
    public ResponseEntity<?> cancelaCompra(@RequestParam (name = "idCarrinhoCliente") Long idCarrinhoCliente){
		CarrinhoCliente carrinhoCancelado = carrinhoJPA.findById(idCarrinhoCliente).get();
		if(carrinhoCancelado == null)
			return new ResponseEntity<String>("Carrinho não cadastrado", HttpStatus.OK);
		carrinhoCancelado = new CarrinhoCliente.CarrinhoClienteBuilder()
		.idCarrinho(idCarrinhoCliente)
		.cupomDesconto(0)
		.enderecoCobranca(null)
		.enderecoEntrega(null)
		.cliente(null)
		.processoCarrinho(0)
		.precoTotal(0)
		.qtdTotalProdCarrinho(0)
		.venda(null)
		.build();
		carrinhoCancelado = carrinhoJPA.saveAndFlush(carrinhoCancelado);
		
		return new ResponseEntity<CarrinhoCliente>(carrinhoCancelado, HttpStatus.OK);
		
    }
	
	@PutMapping(value = "finalizarCompra")
    @ResponseBody
    public ResponseEntity<?> finalizarCompra(@RequestParam (name = "idCarrinhoCliente") Long idCarrinhoCliente){
		CarrinhoCliente carrinhoCadastrar = carrinhoJPA.findById(idCarrinhoCliente).get();
		if(carrinhoCadastrar == null)
			return new ResponseEntity<String>("Carrinho não cadastrado", HttpStatus.OK);
		if(!(ControladorSessao.getInstance().verificaAutenticacao(carrinhoCadastrar.getCliente().getEmail())))
			return new ResponseEntity<String>("Usuario não está autenticado", HttpStatus.OK);
		carrinhoCadastrar.setProcessoCarrinho(2);
		carrinhoCadastrar = carrinhoJPA.saveAndFlush(carrinhoCadastrar);
		
		return new ResponseEntity<CarrinhoCliente>(carrinhoCadastrar, HttpStatus.OK);
		
    }
	
	
		
}
