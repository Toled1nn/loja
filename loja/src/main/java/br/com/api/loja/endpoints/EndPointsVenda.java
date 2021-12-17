package br.com.api.loja.endpoints;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.loja.classes_avulsas.CadastroGeral;
import br.com.api.loja.dto.VendaDTO;
import br.com.api.loja.entidades.Cliente;
import br.com.api.loja.entidades.Venda;
import br.com.api.loja.jpa.ClienteJPA;
import br.com.api.loja.jpa.VendaJPA;

@RestController
public class EndPointsVenda {
	
	@Autowired
	private VendaJPA vendaJPA;
	
	@Autowired
	private ClienteJPA clienteJPA;
	
	
	@PostMapping(value = "cadastrarVenda")
    @ResponseBody
    public ResponseEntity<?> cadastrarCartao(@RequestBody VendaDTO venda){
		
		Cliente cli = clienteJPA.findById(venda.getIdCliente()).get();
		if(cli == null) {
			return new ResponseEntity<String>("cliente não cadastrado", HttpStatus.OK);
		}
		List<String> validacoes = CadastroGeral.getInstance().cadastrarVenda(venda);
		if(validacoes.size() <= 0) {
			Venda vend = new Venda.VendaBuilder()
			 .clienteVenda(cli)
			 .codigoSeguranca(venda.getCodigoSeguranca())
			 .dataVencimento(venda.getDataVencimento())
			 .nomeCartao(venda.getNomeCartao())
			 .numeroDoCartao(venda.getNumeroDoCartao())
			 .build();
			vend = vendaJPA.save(vend);
			return new ResponseEntity<Venda>(vend, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<List<String>>(validacoes, HttpStatus.OK);
		}
		
    }
	
}
