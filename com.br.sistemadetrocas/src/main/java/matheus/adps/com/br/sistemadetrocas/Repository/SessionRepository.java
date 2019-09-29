package matheus.adps.com.br.sistemadetrocas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.model.Session;

public interface SessionRepository 
	extends 
		JpaRepository<Session, Integer> 
{
	Optional<Session> findByToken(
			String token);
}