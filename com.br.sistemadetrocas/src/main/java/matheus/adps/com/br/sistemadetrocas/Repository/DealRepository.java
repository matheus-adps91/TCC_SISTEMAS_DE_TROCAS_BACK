package matheus.adps.com.br.sistemadetrocas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import matheus.adps.com.br.sistemadetrocas.Model.Deal;

public interface DealRepository 
	extends
		JpaRepository<Deal, Integer>
{
	@Procedure(name = "InsertNewDealSafety")
	boolean  insertNewDealSafety(
			@Param("idProdProponent") Integer v1, 
			@Param("idProdProposed") Integer v2);
}
