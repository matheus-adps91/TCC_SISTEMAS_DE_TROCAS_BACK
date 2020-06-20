package matheus.adps.com.br.sistemadetrocas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.DealDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Deal;
import matheus.adps.com.br.sistemadetrocas.Repository.DealRepository;

@Service
public class DealServiceImpl 
	implements 
		DealService 
{
	@Autowired
	private DealRepository dealRepository;
	
	@Override
	public Deal create(
			final DealDTO dealDTO) 
	{		
		final Deal deal = new Deal(
				dealDTO.getProductProponent(), 
				dealDTO.getProductProposed(),
				dealDTO.getDealStatusUserProponent(),
				dealDTO.getDealStatusUserProposed());
		final boolean insertedRecord = dealRepository.insertNewDealSafety(
				deal.getProductProponent().getId(), deal.getProductProposed().getId());
		if (insertedRecord) {
			return deal;
		}
		return new Deal();
	}


}
