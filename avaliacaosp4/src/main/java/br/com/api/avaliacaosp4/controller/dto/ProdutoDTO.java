package br.com.api.avaliacaosp4.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.api.avaliacaosp4.model.Produto;

public class ProdutoDTO {

	private long id;
	private String descricao;
	private double precoUnitario;
	
	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.precoUnitario = produto.getPrecoUnitario();
	}
	
	public ProdutoDTO() {}
	
	public long getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public static List<ProdutoDTO> toProdutoDTO(List<Produto> produtos) {
		List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
		for (Produto produto : produtos) {
			ProdutoDTO pDTO = new ProdutoDTO(produto);
			produtosDTO.add(pDTO);
		}
		return produtosDTO;
	}
}
