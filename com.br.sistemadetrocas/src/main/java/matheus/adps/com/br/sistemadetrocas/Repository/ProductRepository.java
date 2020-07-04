package matheus.adps.com.br.sistemadetrocas.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.Model.Product;

public interface ProductRepository 
	extends 
		JpaRepository<Product, Integer> 
{
    Optional<List<Product>> findByNameContainingAndUserIdNotAndDealing(
            String name, Integer id, Boolean dealing);
    
    Optional<List<Product>> findByProductCategoryAndUserIdNotAndDealing(
    		String productCategory, Integer id, Boolean dealing);
    
    Optional<Product> findById(
    		Integer id);
    
    Optional<Product> findByName(
            String productName );
    
    Optional<List<Product>> findByUserId(
    		int id);
}