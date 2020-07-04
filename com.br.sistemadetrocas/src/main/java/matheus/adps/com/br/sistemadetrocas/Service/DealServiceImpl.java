package matheus.adps.com.br.sistemadetrocas.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.AcceptDealDTO;
import matheus.adps.com.br.sistemadetrocas.DTO.CreateDealDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Deal;
import matheus.adps.com.br.sistemadetrocas.Model.Product;
import matheus.adps.com.br.sistemadetrocas.Model.ProductDeal;
import matheus.adps.com.br.sistemadetrocas.Repository.DealRepository;
import matheus.adps.com.br.sistemadetrocas.Repository.ProductDealRepository;
import matheus.adps.com.br.sistemadetrocas.Repository.ProductRepository;

@Service
public class DealServiceImpl 
	implements 
		DealService 
{
	@Autowired
	private DealRepository dealRepository;
	
	@Autowired
	private ProductDealRepository productDealRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Deal create(
			final CreateDealDTO createDealDTO) 
	{
		// Verificação de negociação já existente
		final Boolean hasAlreadyProductDeal = hasProductDealWithTheseIds(
				createDealDTO.getProductProponent(), createDealDTO.getProductProposed());
		if (hasAlreadyProductDeal) {
			return null;
		}
		// Verificação de negociação invertida já existente
		final Boolean hasAlreadyInvertedProductDeal = hasProductDealWithTheseIds(
				createDealDTO.getProductProposed(), createDealDTO.getProductProponent());
		if (hasAlreadyInvertedProductDeal) {
			return null;
		}
		final Deal deal = new Deal(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, "Proposta Enviada","Aguardando Resposta");
		final Deal dealSaved = dealRepository.save(deal);
		final ProductDeal productDeal = new ProductDeal( 
				createDealDTO.getProductProponent(),  
				createDealDTO.getProductProposed(), 
				dealSaved.getId());
		productDealRepository.save(productDeal);
		return dealSaved;
	}

	// verifica se já existe uma negociação entre os produtos envolvidos
	private Boolean hasProductDealWithTheseIds(
			final Product productProponent,
			final Product productProposed) 
	{
		final Optional<ProductDeal> optinalProductDeal = productDealRepository.findByProductProponentIdAndProductProposedId(
				productProponent.getId(), 
				productProposed.getId());
		if (optinalProductDeal.isPresent()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean hasDeal(
			final Integer idUserProposed) 
	{
		final Optional<List<ProductDeal>> optionalProductProposed = productDealRepository.findByProductProposedUserIdAndNotAcceptedDeal(
				idUserProposed, Boolean.TRUE, Boolean.TRUE);
		if (!optionalProductProposed.isPresent()) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<ProductDeal> get(
			final Integer id) 
	{
		final Optional<List<ProductDeal>> optionalPreDeals = productDealRepository.findByProductProposedUserIdAndNotAcceptedDeal(
				id, Boolean.TRUE, Boolean.TRUE);
		if (!optionalPreDeals.isPresent()) {
			return Collections.emptyList();
		}
		return optionalPreDeals.get();
	}

	// Apago todos os outros registros em que o produto proponente e o produto proposto estão envolvido na tabela productDeal
	@Override
	public void updateAcceptedProposedDeal(
			final AcceptDealDTO acceptedealDTO) 
	{
		final Product productProponent = acceptedealDTO.getProductProponent();
		final Product productProposed = acceptedealDTO.getProductProposed();
		final Integer idProductProponent = productProponent.getId();
		final Integer idProductProposed = productProposed.getId();
		Optional<List<ProductDeal>> optionalProductsDealsOnlyProponent = productDealRepository.findByProductProponentIdOrProductProposedId(idProductProponent, idProductProponent);
		Optional<List<ProductDeal>> optionalProductsDealsOnlyProposed = productDealRepository.findByProductProponentIdOrProductProposedId(idProductProposed, idProductProposed);
				
		final Integer idProductDeal = acceptedealDTO.getId();
		final Integer idDeal = acceptedealDTO.getIdDeal();
		
		if (optionalProductsDealsOnlyProponent.isPresent() ) {
			final List<ProductDeal> productsDealsOnlyProponent = optionalProductsDealsOnlyProponent.get();
			removeAcceptedProductDeal(idProductDeal, productsDealsOnlyProponent);
			if ( !productsDealsOnlyProponent.isEmpty() ) {
				deleteUnfeasibleProductDeal(productsDealsOnlyProponent);				
				deleteUnfeasibleDeals(productsDealsOnlyProponent);
			}
		}
		if (optionalProductsDealsOnlyProposed.isPresent() ) {
			final List<ProductDeal> productsDealsOnlyProposed = optionalProductsDealsOnlyProposed.get();
			removeAcceptedProductDeal(idProductDeal, productsDealsOnlyProposed);
			if ( !productsDealsOnlyProposed.isEmpty()) {
				deleteUnfeasibleProductDeal(productsDealsOnlyProposed);
				deleteUnfeasibleDeals(productsDealsOnlyProposed);
			}
		}
		
		// Atualizando status da proposta na tabela Deal
		final Deal updatedDeal = new Deal(
				idDeal, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, "Troca em Andamento", "Troca em Andamento");
		dealRepository.save(updatedDeal);
		
		// Atualizando o status dos produtos na tabela Product
		final Product updateProductProponent = new Product(
				productProponent.getId(),
				productProponent.getName(),
				productProponent.getDescription(),
				productProponent.getProductCategory(),
				productProponent.getImageName(),
				Boolean.TRUE,
				productProponent.getUser()
				);
		productRepository.save(updateProductProponent);
		final Product updateProductProposed = new Product(
				productProposed.getId(),
				productProposed.getName(),
				productProposed.getDescription(),
				productProposed.getProductCategory(),
				productProposed.getImageName(),
				Boolean.TRUE,
				productProposed.getUser()
				);		
		productRepository.save(updateProductProposed);
	}
	
	// Remove da associação productDeal a associação que virou negócio
	private static void removeAcceptedProductDeal(
			final Integer idAcceptedProductDeal, 
			final List<ProductDeal> productsDeals)
	{
		for (final ProductDeal currentProductDeal : productsDeals ) {
			if ( currentProductDeal.getId().equals(idAcceptedProductDeal) ) {
				productsDeals.remove(currentProductDeal);
				break;
			}
		}
	}
	
	// Deleta as associações de Produto e Deal que são infactiveis (Manutenção BD)
	private void deleteUnfeasibleProductDeal(
			final List<ProductDeal> productsDeals) 
	{
		for ( final ProductDeal currentProductDeal : productsDeals ) {
			productDealRepository.deleteById(currentProductDeal.getId());
		}
	}
	
	// Deleta os Deals que agora são infactiveis (Manutenção BD)
	private void deleteUnfeasibleDeals(
			final List<ProductDeal> productsDealsOnlyProponent)
	{		
		for(final ProductDeal currentProductDeal : productsDealsOnlyProponent) {
			dealRepository.deleteById(currentProductDeal.getIdDeal());
		}		
	}
	
	@Override
	public void deleteProductDeal(
			final Integer idDeal) 
	{
		productDealRepository.deleteByIdDeal(idDeal);
		dealRepository.deleteById(idDeal);				
	}

}
