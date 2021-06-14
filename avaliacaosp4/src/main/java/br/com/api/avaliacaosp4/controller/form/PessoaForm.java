package br.com.api.avaliacaosp4.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import br.com.api.avaliacaosp4.model.Endereco;
import br.com.api.avaliacaosp4.model.Pessoa;


public class PessoaForm {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String cpf;
	@NotBlank
	private double salario;
	@NotBlank
	private char sexo;
	@NotBlank
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public Pessoa toPessoa() {
		return new Pessoa(this.nome, this.cpf, this.salario, this.sexo, this.enderecos);
	}
}
