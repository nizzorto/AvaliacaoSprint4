package br.com.api.avaliacaosp4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.avaliacaosp4.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
