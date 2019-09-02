package matheus.adps.com.br.sistemadetrocas.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.Model.ProductCategory;

public interface ProductCategoryRepository
	extends
		JpaRepository<ProductCategory, Integer>
{
	Optional<ProductCategory> findByCode(
			String code);
}