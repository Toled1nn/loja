package br.com.api.loja.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long numeroDoCartao;

	private int codigoSeguranca;

	private Date dataVencimento;

	private String nomeCartao;
	
	@ManyToOne
	private Cliente clienteVenda;

	public Venda() {

	}
	
	private Venda(Long numeroDoCartao, int codigoSeguranca, Date dataVencimento, String nomeCartao,
			Cliente clienteVenda) {
		this.numeroDoCartao = numeroDoCartao;
		this.codigoSeguranca = codigoSeguranca;
		this.dataVencimento = dataVencimento;
		this.nomeCartao = nomeCartao;
		this.clienteVenda = clienteVenda;
	}



	public static class VendaBuilder {

		private Long numeroDoCartao;

		private int codigoSeguranca;

		private Date dataVencimento;

		private String nomeCartao;

		private Cliente clienteVenda;

		public VendaBuilder numeroDoCartao(Long numeroDoCartao) {
			this.numeroDoCartao = numeroDoCartao;
			return this;
		}

		public VendaBuilder codigoSeguranca(int codigoSeguranca) {
			this.codigoSeguranca = codigoSeguranca;
			return this;
		}

		public VendaBuilder dataVencimento(Date dataVencimento) {
			this.dataVencimento = dataVencimento;
			return this;
		}

		public VendaBuilder nomeCartao(String nomeCartao) {
			this.nomeCartao = nomeCartao;
			return this;
		}
		public VendaBuilder clienteVenda(Cliente clienteVenda) {
			this.clienteVenda = clienteVenda;
			return this;
		}

		public Venda build() {
			return new Venda(numeroDoCartao, codigoSeguranca, dataVencimento, nomeCartao, clienteVenda);
		}

	}

	public Long getNumeroDoCartao() {
		return numeroDoCartao;
	}

	public void setNumeroDoCartao(Long numeroDoCartao) {
		this.numeroDoCartao = numeroDoCartao;
	}

	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(int codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public Cliente getClienteVenda() {
		return clienteVenda;
	}

	public void setClienteVenda(Cliente clienteVenda) {
		this.clienteVenda = clienteVenda;
	}

	@Override
	public String toString() {
		return "Venda [numeroDoCartao=" + numeroDoCartao + ", codigoSeguranca=" + codigoSeguranca + ", dataVencimento="
				+ dataVencimento + ", nomeCartao=" + nomeCartao + ", clienteVenda=" + clienteVenda + "]";
	}

}
