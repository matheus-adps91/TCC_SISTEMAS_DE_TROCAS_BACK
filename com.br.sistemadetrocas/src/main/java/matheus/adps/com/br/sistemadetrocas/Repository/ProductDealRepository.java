package matheus.adps.com.br.sistemadetrocas.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.Model.ProductDeal;

public interface ProductDealRepository 
	extends 
		JpaRepository<ProductDeal, Integer> 
{

	Optional<List<ProductDeal>> findByProductProposedUserId(
			Integer id);
}
