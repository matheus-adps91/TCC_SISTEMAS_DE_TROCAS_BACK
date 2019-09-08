package matheus.adps.com.br.sistemadetrocas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.model.Product;

public interface ProductRepository 
	extends 
		JpaRepository<Product, Integer> 
{
    Optional<Product> findByCode(
            String code );
}