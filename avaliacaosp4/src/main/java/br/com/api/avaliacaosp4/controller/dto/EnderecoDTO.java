package br.com.api.avaliacaosp4.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.avaliacaosp4.model.Endereco;

public class EnderecoDTO {
	
	private String cidade;
	private String rua;
	
	public EnderecoDTO(Endereco endereco) {
		this.cidade = endereco.getCidade();
		this.rua = endereco.getRua();
	}
	
	public EnderecoDTO() {}

	public String getCidade() {
		return cidade;
	}

	public String getRua() {
		return rua;
	}
	
	public static List<EnderecoDTO> toEnderecoDTO(List<Endereco> enderecos) {
		return enderecos.stream().map(EnderecoDTO::new).collect(Collectors.toList());
	}
}
