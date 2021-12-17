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
import br.com.api.loja.classes_avulsas.ControladorSessao;
import br.com.api.loja.entidades.Cliente;
import br.com.api.loja.jpa.ClienteJPA;


@RestController
public class EndPointsCliente {
	
	@Autowired
	private ClienteJPA clienteJPA;
	
	@PostMapping(value = "cadastrarCliente")
    @ResponseBody
    public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cli){
		List<String> validacoes = CadastroGeral.getInstance().cadastroCliente(cli);
		if(validacoes.size() <= 0) {
			Cliente cliente = new Cliente.ClienteBuilder()
					.id(cli.getId())
					.nome(cli.getNome())
					.cpf(cli.getCpf())
					.telefoneCelular(cli.getTelefoneCelular())
					.telefoneComercial(cli.getTelefoneComercial())
					.telefoneResidencial(cli.getTelefoneResidencial())
					.email(cli.getEmail())
					.build();
			cliente = clienteJPA.save(cliente);
			ControladorSessao.getInstance().autenticaUsuario(cli.getEmail());
			return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<List<String>>(validacoes, HttpStatus.OK);
		}
	}
}
