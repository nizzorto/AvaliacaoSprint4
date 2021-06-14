package br.com.api.avaliacaosp4.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.api.avaliacaosp4.model.Produto;

public class ProdutoForm {

	@NotBlank
	private String descricao;
	private double precoUnitario;
	

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Produto toProduto() {
		return new Produto(this.descricao, this.precoUnitario);
	}
}
