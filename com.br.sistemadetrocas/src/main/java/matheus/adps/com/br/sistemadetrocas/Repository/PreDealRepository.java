package matheus.adps.com.br.sistemadetrocas.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.Model.PreDeal;

public interface PreDealRepository 
	extends 
		JpaRepository<PreDeal, Integer> 
{
	Optional<List<PreDeal>> findByIdUserProposedAndViewedEquals(
			Integer idUserProposed,
			Boolean viewed);
}
