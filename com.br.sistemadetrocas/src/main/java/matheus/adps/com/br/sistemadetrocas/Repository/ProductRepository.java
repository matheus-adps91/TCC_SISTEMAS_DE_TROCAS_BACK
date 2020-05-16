package matheus.adps.com.br.sistemadetrocas.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.Model.Product;
import matheus.adps.com.br.sistemadetrocas.Model.User;

public interface ProductRepository 
	extends 
		JpaRepository<Product, Integer> 
{
    Optional<Product> findByName(
            String name );
    
    Optional<List<Product>> findByUserId(
    		int id);
}