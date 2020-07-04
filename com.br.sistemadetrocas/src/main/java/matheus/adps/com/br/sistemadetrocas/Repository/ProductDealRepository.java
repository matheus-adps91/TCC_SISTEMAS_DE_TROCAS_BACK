package matheus.adps.com.br.sistemadetrocas.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import matheus.adps.com.br.sistemadetrocas.Model.ProductDeal;

public interface ProductDealRepository 
	extends 
		JpaRepository<ProductDeal, Integer> 
{

	@Query("SELECT pde FROM ProductDeal pde WHERE pde.productProposed.user.id = :id AND pde.idDeal NOT IN "+ 
			"( SELECT id FROM Deal de WHERE de.viewed = :viewed AND de.answered = :answered )")
	Optional<List<ProductDeal>> findByProductProposedUserIdAndNotAcceptedDeal(
			@Param("id") Integer id,
			@Param("viewed") Boolean viewed,
			@Param("answered") Boolean answered);
	
	Optional<ProductDeal> findByProductProponentIdAndProductProposedId(
			Integer idProductProponent,
			Integer idProductProposed);
	
	Optional<List<ProductDeal>> findByProductProponentIdOrProductProposedId(
			Integer idProductProponent,
			Integer idProductProposed );
	
	@Transactional
	void deleteByIdDeal(
			Integer idDeal);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM ProductDeal pde WHERE pde.idDeal not in "+
				"( SELECT idDeal FROM ProductDeal pde WHERE pde.productProponent.id = :idProductProponent AND pde.productProposed.id = :idProductProposed )")
	void deleteByProductProponentIdOrProductProposedIdAndIdDealNot(
			@Param("idProductProponent") Integer idProductProponent,
			@Param("idProductProposed") Integer idProductProposed);
}
