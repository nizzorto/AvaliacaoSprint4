package br.com.api.avaliacaosp4.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;


@Entity
public class Pessoa implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private double salario;
	private char sexo;
	@OneToMany
	private List<Endereco> enderecos;
	
	public Pessoa(String nome, String cpf, double salario, char sexo, List<Endereco> enderecos) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.sexo = sexo;
		this.enderecos = enderecos;
	}
	
	public Pessoa() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	@Override
	public String getAuthority() {
		return this.nome;
	}
}
