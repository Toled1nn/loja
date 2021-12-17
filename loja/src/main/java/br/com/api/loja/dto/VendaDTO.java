package br.com.api.loja.dto;

import java.util.Date;

public class VendaDTO {
	
	private Long numeroDoCartao;

	private int codigoSeguranca;

	private Date dataVencimento;

	private String nomeCartao;
	
	private Long idCliente;

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

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

}
