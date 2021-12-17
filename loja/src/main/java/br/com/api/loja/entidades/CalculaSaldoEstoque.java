package br.com.api.loja.entidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculaSaldoEstoque {
		
	public int calculaQtdProdutoCarrinho(List<String> produtos) {
		HashMap<String, Integer> produtoDividios = new HashMap<>();
		int qtdTotalProd = 0;
	      for (String prod : produtos) {
	        if (produtoDividios.containsKey(prod)) {
	        	produtoDividios.put(prod, produtoDividios.get(prod) + 1); // increase counter if contains
	        } else
	        	produtoDividios.put(prod, 1);
	      }
	      
	      for (Map.Entry<String, Integer> qtdProd : produtoDividios.entrySet()) { 
	    	  	qtdTotalProd += qtdProd.getValue();
	    	  	
	    	  }
		return qtdTotalProd;
	}
	
	public List<String> adicionaProdutos(List<String> produtos,String nome, int qtd){
		for(int i = 0; i < qtd; i++) {
			produtos.add(nome);
		}
		return produtos;
	}
	
	public boolean verificaProdutoAdicionadoCarrinho(List<String> produtos,String produtoAdicionar) {
		if(produtos.contains(produtoAdicionar))
			return true;
		else 
			return false;
	}
	
	public List<String> removeProdLista(List<String> produtos,String produtoAdicionar){
		produtos.remove(produtoAdicionar);
		return produtos;
	}
	

}
