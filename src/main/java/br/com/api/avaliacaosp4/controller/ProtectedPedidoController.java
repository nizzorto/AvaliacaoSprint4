package br.com.api.avaliacaosp4.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.avaliacaosp4.controller.dto.PedidoDTO;
import br.com.api.avaliacaosp4.controller.form.PedidoForm;
import br.com.api.avaliacaosp4.model.Pedido;
import br.com.api.avaliacaosp4.model.Produto;
import br.com.api.avaliacaosp4.repository.PedidoRepository;
import br.com.api.avaliacaosp4.repository.ProdutoRepository;


@RestController
@RequestMapping("/protected/pedido")
public class ProtectedPedidoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<PedidoDTO> postPedido(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriBuilder) {
		
		List<Produto> produtos = new ArrayList<Produto>();
		for (Long idproduto : form.getIdProdutos()) {
			Produto produto	= produtoRepository.findById(idproduto).get();
			produtos.add(produto);
		}
		Pedido pedido = form.toPedido(produtos);
		pedidoRepository.save(pedido);
		
		URI uri = uriBuilder.path("/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
	}
	
	@GetMapping
	public ResponseEntity<List<PedidoDTO>> getAllPedidos() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		if (pedidos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(PedidoDTO.toPedidoDTO(pedidos));
	}
}
