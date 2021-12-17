package br.com.api.loja.classes_avulsas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import br.com.api.loja.dto.EnderecoDTO;
import br.com.api.loja.dto.VendaDTO;
import br.com.api.loja.entidades.CarrinhoCliente;
import br.com.api.loja.entidades.Cliente;
import br.com.api.loja.entidades.Produto;

public class CadastroGeral {

	public static CadastroGeral instance;

	private CadastroGeral() {

	}

	public static CadastroGeral getInstance() {
		if (instance == null) {
			instance = new CadastroGeral();
		}
		return instance;
	}

	public List<String> cadastroProduto(Produto produto) {

		List<String>  mensagem = new ArrayList<String>();

		if (produto.getNome() == null || produto.getNome().isEmpty())
			mensagem.add("-Produto sem Nome-");
		
		if (produto.getPrecoProduto() == 0)
			mensagem.add("-Produto sem Preco-");
		if (produto.getCodigoProduto() == null || produto.getCodigoProduto() == 0)
			mensagem.add("-Produto sem código-");

		return mensagem;
	}

	public List<String> cadastroCliente(Cliente cliente) {
		List<String> mensagens = new ArrayList<String>();
		if (cliente.getCpf() == null || !(validaCPF(cliente.getCpf())))
			mensagens.add("-Cpf Inválido-");
		if (cliente.getId() == null || cliente.getId() == 0)
			mensagens.add("-Id Inválido-");
		if (cliente.getEmail() == null || !(cliente.getEmail().contains("@")))
			mensagens.add("-email inválido-");
		if (cliente.getEmail() == null || cliente.getNome().length() < 3)
			mensagens.add("-Nome inválido-");
		if (cliente.getTelefoneCelular() == null || cliente.getTelefoneCelular().length() < 9)
			mensagens.add("-Telefone Celular inválido-");
		if (cliente.getTelefoneComercial() == null || cliente.getTelefoneComercial().length() < 9)
			mensagens.add("-Telefone Comercial inválido-");
		if (cliente.getTelefoneResidencial() == null || cliente.getTelefoneResidencial().length() < 9)
			mensagens.add("-Telefone Residencial inválido-");
		return mensagens;
	}

	public List<String> cadastrarEndereco(EnderecoDTO end) {
		List<String> mensagens = new ArrayList<String>();
		if(end.getIdEndereco() == null || end.getIdEndereco() == 0)
			mensagens.add("-Código de Endereco errado-");
		if(end.getNumeroCEP() == null || end.getNumeroCEP().isEmpty() || end.getNumeroCEP().length() < 7 )
			mensagens.add("-CEP inválido-");
		if(end.getLogradouro().isEmpty() || (!(end.getLogradouro().contains("Cobrança")) && !(end.getLogradouro().contains("Entrega"))))
			mensagens.add("-Logradouro-");
		if(end.getNomeEndereco() == null || end.getNomeEndereco().isEmpty() || end.getNomeEndereco().length() < 3)
			mensagens.add("-Nome Endereco inválido-");
		return mensagens;
	}


	public List<String> cadastrarVenda(VendaDTO vend) {
		List<String> mensagens = new ArrayList<String>();
		if (vend.getNomeCartao() == null || vend.getNomeCartao().isEmpty())
			mensagens.add("-Cpf Inválido-");
		if (vend.getNumeroDoCartao() == null|| vend.getNumeroDoCartao() == 0)
			mensagens.add("-num do cartão invalido-");
		if (vend.getCodigoSeguranca() == 0)
			mensagens.add("-código de segurança inválido-");
		if(vend.getDataVencimento() == null)
			mensagens.add("-data de vencimento-");

		return mensagens;
	}

	public List<String> cadastraCarrinho(CarrinhoCliente car) {
		List<String> mensagens = new ArrayList<String>();
		
		if(car.getIdCarrinho() == null||car.getIdCarrinho() == 0)
			mensagens.add("Id carrinho inválido");

		return mensagens;

	}

	public static boolean validaCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {

			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {

				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
}
