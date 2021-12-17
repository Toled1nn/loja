package br.com.api.loja.entidades; 

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cliente  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	private String nome;

	private String cpf;

	private String telefoneComercial;

	private String telefoneCelular;

	private String telefoneResidencial;

	private String email;
	
	public Cliente() {
		
	}
	
	private Cliente(Long id, String nome, String cpf, String telefoneComercial, String telefoneCelular,
			String telefoneResidencial, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefoneComercial = telefoneComercial;
		this.telefoneCelular = telefoneCelular;
		this.telefoneResidencial = telefoneResidencial;
		this.email = email;
	}

	public static class ClienteBuilder{
		
		private Long id;
		
		private String nome;

		private String cpf;

		private String telefoneComercial;

		private String telefoneCelular;

		private String telefoneResidencial;

		private String email;
		
		public ClienteBuilder id(Long id) {
			this.id = id;
			return this;
		}
		public ClienteBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}
		public ClienteBuilder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}
		public ClienteBuilder telefoneComercial(String telefoneComercial) {
			this.telefoneComercial = telefoneComercial;
			return this;
		}
		public ClienteBuilder telefoneCelular(String telefoneCelular) {
			this.telefoneCelular = telefoneCelular;
			return this;
		}
		public ClienteBuilder telefoneResidencial(String telefoneResidencial) {
			this.telefoneResidencial = telefoneResidencial;
			return this;
		}
		public ClienteBuilder email(String email) {
			this.email = email;
			return this;
		}
		public Cliente build() {
			return new Cliente(id,nome,cpf,telefoneComercial,telefoneCelular,telefoneResidencial,email);
		}
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefoneComercial=" + telefoneComercial
				+ ", telefoneCelular=" + telefoneCelular + ", telefoneResidencial=" + telefoneResidencial + ", email="
				+ email + "]";
	}
}
