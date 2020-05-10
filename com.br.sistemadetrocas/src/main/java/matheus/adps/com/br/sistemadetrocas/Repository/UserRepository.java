package matheus.adps.com.br.sistemadetrocas.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.Model.User;

public interface UserRepository 
	extends 
		JpaRepository<User, Integer>
{
	Optional<User> findByEmail(
			String email);
}