package br.com.api.loja.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EnderecoCliente  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idEndereco;
	
	private String numeroCEP;
	
	private String nomeEndereco;
	
	@ManyToOne
	private Cliente clienteRelacionado;
		
	private String logradouro;
	
	private EnderecoCliente(Long idEndereco, String numeroCEP, String nomeEndereco, Cliente clienteRelacionado,
			String logradouro) {
		this.idEndereco = idEndereco;
		this.numeroCEP = numeroCEP;
		this.nomeEndereco = nomeEndereco;
		this.clienteRelacionado = clienteRelacionado;
		this.logradouro = logradouro;
	}



	public EnderecoCliente() {
		
	}
	
public static class EnderecoBuilder{
		
	private Long idEndereco;
	
	private String numeroCEP;
	
	private String nomeEndereco;
	
	private Cliente clienteRelacionado;
		
	private String logradouro;;
		
		public EnderecoBuilder idEndereco(Long idEndereco) {
			this.idEndereco = idEndereco;
			return this;
		}
		public EnderecoBuilder numeroCEP(String numeroCEP) {
			this.numeroCEP = numeroCEP;
			return this;
		}
		public EnderecoBuilder nomeEndereco(String nomeEndereco) {
			this.nomeEndereco = nomeEndereco;
			return this;
		}
		public EnderecoBuilder clienteRelacionado(Cliente clienteRelacionado) {
			this.clienteRelacionado = clienteRelacionado;
			return this;
		}
		public EnderecoBuilder logradouro(String logradouro) {
			this.logradouro = logradouro;
			return this;
		}
		
		public EnderecoCliente builder() {
			return new EnderecoCliente(idEndereco, numeroCEP, nomeEndereco, clienteRelacionado,logradouro);
		}
		
	}

	public Long getIdEndereco() {
		return idEndereco;
	}



	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}



	public String getNumeroCEP() {
		return numeroCEP;
	}



	public void setNumeroCEP(String numeroCEP) {
		this.numeroCEP = numeroCEP;
	}



	public String getNomeEndereco() {
		return nomeEndereco;
	}



	public void setNomeEndereco(String nomeEndereco) {
		this.nomeEndereco = nomeEndereco;
	}



	public Cliente getClienteRelacionado() {
		return clienteRelacionado;
	}



	public void setClienteRelacionado(Cliente clienteRelacionado) {
		this.clienteRelacionado = clienteRelacionado;
	}



	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	@Override
	public String toString() {
		return "EnderecoCliente [idEndereco=" + idEndereco + ", numeroCEP=" + numeroCEP + ", nomeEndereco="
				+ nomeEndereco + ", clienteRelacionado=" + clienteRelacionado + ", logradouro=" + logradouro + "]";
	}
	
}
