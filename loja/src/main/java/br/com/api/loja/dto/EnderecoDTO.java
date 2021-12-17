package br.com.api.loja.dto;

public class EnderecoDTO {
	
	private Long idEndereco;
	
	private String numeroCEP;
	
	private String nomeEndereco;
		
	private String logradouro;

	private Long idCliente;

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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

}
