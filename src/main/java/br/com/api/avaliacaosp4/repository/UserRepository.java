package br.com.api.avaliacaosp4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.avaliacaosp4.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByCpf(String cpf);
}
