package br.com.api.avaliacaosp4.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.api.avaliacaosp4.model.Pessoa;

public class PessoaDTO {
	
	private String nome;
	private String cpf;
	private List<EnderecoDTO> enderecosDTO = new ArrayList<EnderecoDTO>();
	
	public PessoaDTO(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		//Transformando o model de endereços em endereçosDTO
		this.enderecosDTO = EnderecoDTO.toEnderecoDTO(pessoa.getEnderecos());
	}
	
	public PessoaDTO() {}

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public List<EnderecoDTO> getEnderecosDTO() {
		return this.enderecosDTO;
	}

	public static List<PessoaDTO> toPessoaDTO(List<Pessoa> pessoas) {
		List<PessoaDTO> pessoasDTO = new ArrayList<PessoaDTO>();
		for (Pessoa pessoa : pessoas) {
			PessoaDTO pDTO = new PessoaDTO(pessoa);
			pessoasDTO.add(pDTO);
		}
		return pessoasDTO;
	}
}
