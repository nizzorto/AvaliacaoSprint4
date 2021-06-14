package br.com.api.avaliacaosp4.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.api.avaliacaosp4.model.User;
import br.com.api.avaliacaosp4.repository.UserRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Optional<User> usuario = userRepository.findByCpf(cpf);
		if (usuario.isPresent()) {
			return (UserDetails) usuario.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
