package matheus.adps.com.br.sistemadetrocas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.PreDealDTO;
import matheus.adps.com.br.sistemadetrocas.Model.PreDeal;
import matheus.adps.com.br.sistemadetrocas.Repository.PreDealRepository;

@Service
public class PreDealServiceImpl 
	implements 
		PreDealService 
{
	@Autowired
	private PreDealRepository preDealRepository;
	
	@Override
	public PreDeal create(
			final PreDealDTO preDealDTO) 
	{
		final PreDeal preDeal = new PreDeal(
				preDealDTO.getIdUserProponent(),	
				preDealDTO.getIdProdProponent(), 
				preDealDTO.getIdUserProposed(),
				preDealDTO.getIdProdProposed());
		return preDealRepository.save(preDeal);
	}

	@Override
	public List<PreDeal> get(
			final Integer idUser) 
	{
		final List<PreDeal> preDeals = preDealRepository.findAll();
		return preDeals;
	}

	@Override
	public Boolean hasDeal(
			final Integer idUserProposed) 
	{
		final Boolean viewed = new Boolean(false);
		final Optional<List<PreDeal>> optinalPreDeals = preDealRepository.findByIdUserProposedAndViewedEquals(idUserProposed, viewed);
		if (!optinalPreDeals.isPresent()) {
			return false;
		}
		return true;
	}
	
	

}
