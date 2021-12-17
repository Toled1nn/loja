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
import br.com.api.loja.dto.EnderecoDTO;
import br.com.api.loja.entidades.Cliente;
import br.com.api.loja.entidades.EnderecoCliente;
import br.com.api.loja.jpa.ClienteJPA;
import br.com.api.loja.jpa.EnderecoClienteJPA;

@RestController
public class EndPointsEndereco {
	
	@Autowired
	private EnderecoClienteJPA enderecoClienteJPA;
	
	@Autowired
	private ClienteJPA clienteJPA;
	
	
	@PostMapping(value = "cadastrarEndereco")
    @ResponseBody
    public ResponseEntity<?> cadastrarEnderecoEntrega(@RequestBody EnderecoDTO end){
		
		Cliente cli = clienteJPA.findById(end.getIdCliente()).get();
		if(cli == null) {
			return new ResponseEntity<String>("cliente não cadastrado", HttpStatus.OK);
		}
		List<String> validacoes = CadastroGeral.getInstance().cadastrarEndereco(end);
		if(validacoes.size() <= 0) {
			EnderecoCliente endereco = new EnderecoCliente.EnderecoBuilder()
			 .clienteRelacionado(cli)
			 .idEndereco(end.getIdEndereco())
			 .nomeEndereco(end.getNomeEndereco())
			 .numeroCEP(end.getNumeroCEP())
			 .logradouro(end.getLogradouro())
			 .builder();
			endereco = enderecoClienteJPA.save(endereco);
			return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<List<String>>(validacoes, HttpStatus.OK);
		}
    }
}
