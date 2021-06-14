package br.com.api.avaliacaosp4.controller.form;

import java.util.List;

import br.com.api.avaliacaosp4.model.Pedido;
import br.com.api.avaliacaosp4.model.Produto;

public class PedidoForm {
	
	private List<Long> idProdutos;
		
	public void setIdProdutos(List<Long> idProdutos) {
		this.idProdutos = idProdutos;
	}
	
	public List<Long> getIdProdutos() {
		return this.idProdutos;
	}
	
	public Pedido toPedido(List<Produto> produtos) {
		return new Pedido(produtos);
	}
}
