package matheus.adps.com.br.sistemadetrocas.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.CreateDealDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Deal;
import matheus.adps.com.br.sistemadetrocas.Model.ProductDeal;
import matheus.adps.com.br.sistemadetrocas.Repository.DealRepository;
import matheus.adps.com.br.sistemadetrocas.Repository.ProductDealRepository;

@Service
public class DealServiceImpl 
	implements 
		DealService 
{
	@Autowired
	private DealRepository dealRepository;
	
	@Autowired
	private ProductDealRepository productDealRepository;
	
	@Override
	public Deal create(
			final CreateDealDTO createDealDTO) 
	{		
		final Deal deal = new Deal(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, "Proposta Enviada","Aguardando Resposta");
		final Deal dealSaved = dealRepository.save(deal);
		final ProductDeal productDeal = new ProductDeal( 
				createDealDTO.getProductProponent(),  
				createDealDTO.getProductProposed(), 
				dealSaved.getId());
		productDealRepository.save(productDeal);
		return dealSaved;
	}

	@Override
	public Boolean hasDeal(
			final Integer idUserProposed) 
	{
		final Optional<List<ProductDeal>> optionalProductProposed = productDealRepository.findByProductProposedUserId(idUserProposed);
		if (!optionalProductProposed.isPresent()) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<ProductDeal> get(
			final Integer id) 
	{
		final Optional<List<ProductDeal>> optionalPreDeals = productDealRepository.findByProductProposedUserId(id);
		if (!optionalPreDeals.isPresent()) {
			return Collections.emptyList();
		}
		return optionalPreDeals.get();
	}
}
