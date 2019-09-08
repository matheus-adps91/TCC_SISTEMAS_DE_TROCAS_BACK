package matheus.adps.com.br.sistemadetrocas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.model.ProductCategory;

public interface ProductCategoryRepository
	extends
		JpaRepository<ProductCategory, Integer>
{
	Optional<ProductCategory> findByCode(
			String code);
}