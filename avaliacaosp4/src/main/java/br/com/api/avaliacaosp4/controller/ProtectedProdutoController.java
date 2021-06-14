package br.com.api.avaliacaosp4.controller;

import java.net.URI;
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

import br.com.api.avaliacaosp4.controller.dto.ProdutoDTO;
import br.com.api.avaliacaosp4.controller.form.ProdutoForm;
import br.com.api.avaliacaosp4.model.Produto;
import br.com.api.avaliacaosp4.repository.ProdutoRepository;

@RestController
@RequestMapping("/protected/produto")
public class ProtectedProdutoController {
	
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDTO> postProduto(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
		Produto produto = form.toProduto();
		
		produtoRepository.save(produto); 
			
		URI uri = uriBuilder.path("/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDTO(produto));
	}
	
	@GetMapping //TODO se sobrar tempo faça o get{id}, put e delete
	public ResponseEntity<List<ProdutoDTO>> getProduto() {
		List<Produto> produtos = produtoRepository.findAll();
		if (produtos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ProdutoDTO.toProdutoDTO(produtos));
	}
	
	
	
}
