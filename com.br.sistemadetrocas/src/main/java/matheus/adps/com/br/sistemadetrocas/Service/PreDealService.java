package matheus.adps.com.br.sistemadetrocas.Service;

import java.util.List;

import matheus.adps.com.br.sistemadetrocas.DTO.PreDealDTO;
import matheus.adps.com.br.sistemadetrocas.Model.PreDeal;

public interface PreDealService 
{
	PreDeal create(
			PreDealDTO preDealDTO);
	
	Boolean hasDeal(
			Integer idUser);
	
	List<PreDeal> get(
			Integer idUser);
}
