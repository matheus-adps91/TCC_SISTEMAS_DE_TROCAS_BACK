package matheus.adps.com.br.sistemadetrocas.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.Model.Product;

public interface ProductRepository 
	extends 
		JpaRepository<Product, Integer> 
{
    Optional<Product> findByName(
            String name );
}