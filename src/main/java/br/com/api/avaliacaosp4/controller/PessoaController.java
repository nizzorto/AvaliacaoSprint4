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

import br.com.api.avaliacaosp4.controller.dto.PessoaDTO;
import br.com.api.avaliacaosp4.controller.form.PessoaForm;
import br.com.api.avaliacaosp4.model.Pessoa;
import br.com.api.avaliacaosp4.repository.EnderecoRepository;
import br.com.api.avaliacaosp4.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<PessoaDTO> postPessoa(@RequestBody @Valid PessoaForm form, UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = form.toPessoa();
		
		pessoaRepository.save(pessoa);
		enderecoRepository.saveAll(pessoa.getEnderecos());
			
		URI uri = uriBuilder.path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).body(new PessoaDTO(pessoa));
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> getPessoas() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		if (pessoas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(PessoaDTO.toPessoaDTO(pessoas));
	}
}
