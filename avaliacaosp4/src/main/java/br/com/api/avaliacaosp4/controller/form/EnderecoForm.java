package br.com.api.avaliacaosp4.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.api.avaliacaosp4.model.Endereco;

public class EnderecoForm {
	@NotBlank
	private String pais;
	@NotBlank
	private String estado;
	@NotBlank
	private String cidade;
	@NotBlank
	private String cep;
	@NotBlank
	private String rua;
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public Endereco toEndereco() {
		return new Endereco(this.pais, this.estado, this.cidade, this.cep, this.rua);
	}
	
}
