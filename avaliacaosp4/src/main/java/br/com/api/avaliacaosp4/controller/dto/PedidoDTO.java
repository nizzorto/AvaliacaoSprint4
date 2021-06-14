package br.com.api.avaliacaosp4.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.api.avaliacaosp4.model.Pedido;

public class PedidoDTO {
	
	private double total;
	private LocalDateTime dataPedido;
	private List<ProdutoDTO> produtosDTO;
	
	public PedidoDTO(Pedido pedido) {
		this.total = pedido.getTotal();
		this.dataPedido = pedido.getDataPedido();
		this.produtosDTO = ProdutoDTO.toProdutoDTO(pedido.getProdutos());
	}

	public double getTotal() {
		return total;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public List<ProdutoDTO> getProdutos() {
		return produtosDTO;
	}
	
	public static List<PedidoDTO> toPedidoDTO(List<Pedido> pedidos) {
		List<PedidoDTO> pedidoDTO = new ArrayList<PedidoDTO>();
		for (Pedido pedido : pedidos) {
			PedidoDTO pDTO = new PedidoDTO(pedido);
			pedidoDTO.add(pDTO);
		}
		return pedidoDTO;
	}	
}
