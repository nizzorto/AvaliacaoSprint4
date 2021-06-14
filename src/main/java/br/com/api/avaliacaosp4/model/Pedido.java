package br.com.api.avaliacaosp4.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double total;
	private LocalDateTime dataPedido;
	@ManyToMany
	private List<Produto> produtos;

	public Pedido(List<Produto> produtos) {
		this.produtos = produtos;
		this.dataPedido = LocalDateTime.now();
	}
	
	public Pedido() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		
		for (Produto produto : produtos) {
			this.total += produto.getPrecoUnitario();
		}
		this.produtos = produtos;
		
	}
}
