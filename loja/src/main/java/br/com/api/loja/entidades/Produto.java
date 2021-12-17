package br.com.api.loja.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codigoProduto;
	
	private String nome;
	
	private float precoProduto;
	
	private int quantidadeEstoque;
	
	public Produto() {
		
	}

	private Produto(Long codigoProduto, String nome, float precoProduto, int quantidadeEstoque) {
		this.codigoProduto = codigoProduto;
		this.nome = nome;
		this.precoProduto = precoProduto;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public static class ProdutoBuilder{
	
		private String nome;
		
		private int quantidadeEstoque;
		
		private Long codigoProduto;
		
		private float precoProduto;
		
		
		public ProdutoBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}
		
		public ProdutoBuilder quantidadeEstoque(int quantidadeEstoque) {
			this.quantidadeEstoque = quantidadeEstoque;
			return this;
		}
		
		public ProdutoBuilder codigoProduto(Long codigoProduto) {
			this.codigoProduto = codigoProduto;
			return this;
		}
		
		public ProdutoBuilder precoProduto(float precoProduto) {
			this.precoProduto = precoProduto;
			return this;
		}
			
		public Produto build() {
			return new Produto(codigoProduto, nome, precoProduto, quantidadeEstoque);
		}
		
	}




	public Long getCodigoProduto() {
		return codigoProduto;
	}




	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public float getPrecoProduto() {
		return precoProduto;
	}




	public void setPrecoProduto(float precoProduto) {
		this.precoProduto = precoProduto;
	}




	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}




	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	@Override
	public String toString() {
		return "Produto [codigoProduto=" + codigoProduto + ", nome=" + nome + ", precoProduto=" + precoProduto
				+ ", quantidadeEstoque=" + quantidadeEstoque + "]";
	}
	
}
