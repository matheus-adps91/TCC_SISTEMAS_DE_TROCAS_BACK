package matheus.adps.com.br.sistemadetrocas.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.Model.Product;

public interface ProductRepository 
	extends 
		JpaRepository<Product, Integer> 
{
	
    Optional<List<Product>> findByNameContainingAndUserIdNot(
            String name, Integer id);
    
    Optional<List<Product>> findByProductCategoryAndUserIdNot(
    		String productCategory, Integer id);
    
    Optional<Product> findByName(
            String productName );
    
    Optional<List<Product>> findByUserId(
    		int id);
}