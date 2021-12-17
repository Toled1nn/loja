package br.com.api.loja.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarrinhoCliente  extends CalculaSaldoEstoque implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idCarrinho;
	
	private int cupomDesconto;
		
	private float precoTotal;
	
	private EnderecoCliente enderecoEntrega;
	
	private EnderecoCliente enderecoCobranca;
	
	private int processoCarrinho;
	
	 @Column
	 @ElementCollection(targetClass=String.class)
	private List<String> produtos = new ArrayList<String>();
	
	private Venda venda;
	
	private Cliente cliente;
	
	private int qtdTotalProdCarrinho;
	
	public CarrinhoCliente() {
		
	}
	
	public static class CarrinhoClienteBuilder {

		private Long idCarrinho;
		
		private int cupomDesconto;
			
		private float precoTotal;
		
		private EnderecoCliente enderecoEntrega;
		
		private EnderecoCliente enderecoCobranca;
		
		private int processoCarrinho;
		
		private Venda venda;
		
		private Cliente cliente;
		
		private int qtdTotalProdCarrinho;

		public CarrinhoClienteBuilder idCarrinho(Long idCarrinho) {
			this.idCarrinho = idCarrinho;
			return this;
		}

		public CarrinhoClienteBuilder cupomDesconto(int cupomDesconto) {
			this.cupomDesconto = cupomDesconto;
			return this;
		}

		public CarrinhoClienteBuilder precoTotal(float precoTotal) {
			this.precoTotal = precoTotal;
			return this;
		}

		public CarrinhoClienteBuilder enderecoEntrega(EnderecoCliente enderecoEntrega) {
			this.enderecoEntrega = enderecoEntrega;
			return this;
		}
		public CarrinhoClienteBuilder enderecoCobranca(EnderecoCliente enderecoCobranca) {
			this.enderecoCobranca = enderecoCobranca;
			return this;
		}
		public CarrinhoClienteBuilder processoCarrinho(int processoCarrinho) {
			this.processoCarrinho = processoCarrinho;
			return this;
		}
		public CarrinhoClienteBuilder venda(Venda venda) {
			this.venda = venda;
			return this;
		}
		public CarrinhoClienteBuilder cliente(Cliente cliente) {
			this.cliente = cliente;
			return this;
		}
		public CarrinhoClienteBuilder qtdTotalProdCarrinho(int qtdTotalProdCarrinho) {
			this.qtdTotalProdCarrinho = qtdTotalProdCarrinho;
			return this;
		}

		public CarrinhoCliente build() {
			return new CarrinhoCliente(idCarrinho, cupomDesconto, precoTotal, enderecoEntrega,enderecoCobranca
					, processoCarrinho, venda, cliente, qtdTotalProdCarrinho);
		}

	}
	
	

	private CarrinhoCliente(Long idCarrinho, int cupomDesconto, float precoTotal, EnderecoCliente enderecoEntrega,
			EnderecoCliente enderecoCobranca, int processoCarrinho, Venda venda, Cliente cliente, int qtdTotalProdCarrinho) {
		this.idCarrinho = idCarrinho;
		this.cupomDesconto = cupomDesconto;
		this.precoTotal = precoTotal;
		this.enderecoEntrega = enderecoEntrega;
		this.enderecoCobranca = enderecoCobranca;
		this.processoCarrinho = processoCarrinho;
		this.venda = venda;
		this.cliente = cliente;
		this.qtdTotalProdCarrinho = qtdTotalProdCarrinho;
	}



	public Long getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public int getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(int cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public EnderecoCliente getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(EnderecoCliente enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public EnderecoCliente getEnderecoCobranca() {
		return enderecoCobranca;
	}

	public void setEnderecoCobranca(EnderecoCliente enderecoCobranca) {
		this.enderecoCobranca = enderecoCobranca;
	}

	public int getProcessoCarrinho() {
		return processoCarrinho;
	}

	public void setProcessoCarrinho(int processoCarrinho) {
		this.processoCarrinho = processoCarrinho;
	}

	public List<String> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<String> produtos) {
		this.produtos = produtos;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public int getQtdTotalProdCarrinho() {
		return qtdTotalProdCarrinho;
	}

	public void setQtdTotalProdCarrinho(int qtdTotalProdCarrinho) {
		this.qtdTotalProdCarrinho = qtdTotalProdCarrinho;
	}

	@Override
	public String toString() {
		return "CarrinhoCliente [idCarrinho=" + idCarrinho + ", cupomDesconto=" + cupomDesconto + ", precoTotal="
				+ precoTotal + ", enderecoEntrega=" + enderecoEntrega + ", enderecoCobranca=" + enderecoCobranca
				+ ", processoCarrinho=" + processoCarrinho + ", produtos=" + produtos + ", venda=" + venda
				+ ", cliente=" + cliente + ", qtdTotalProdCarrinho=" + qtdTotalProdCarrinho + "]";
	}
	
}
