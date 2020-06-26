package matheus.adps.com.br.sistemadetrocas.Service;

import java.util.List;

import matheus.adps.com.br.sistemadetrocas.DTO.CreateDealDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Deal;
import matheus.adps.com.br.sistemadetrocas.Model.ProductDeal;

public interface DealService 
{
	Deal create(
			CreateDealDTO createDealDTO);
	
	Boolean hasDeal(
			Integer idUserProposed);

	List<ProductDeal> get(
			Integer idUserProposed);
}