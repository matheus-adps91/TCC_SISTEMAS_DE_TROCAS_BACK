package matheus.adps.com.br.sistemadetrocas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.model.User;

public interface UserRepository 
	extends 
		JpaRepository<User, Integer>
{
	Optional<User> findByEmail(
			String email);
}