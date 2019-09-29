package matheus.adps.com.br.sistemadetrocas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.dto.ProductCategoryDTO;
import matheus.adps.com.br.sistemadetrocas.exception.ProductCategoryDuplicateException;
import matheus.adps.com.br.sistemadetrocas.exception.ProductCategoryNotFoundException;
import matheus.adps.com.br.sistemadetrocas.model.ProductCategory;
import matheus.adps.com.br.sistemadetrocas.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl 
	implements 
		ProductCategoryService
{
	@Autowired
	private ProductCategoryRepository pcRepository;
	
	@Override
	public ProductCategory create(
			final ProductCategoryDTO productCategoryDTO)
	{
		final Optional<ProductCategory> optionalProductCategory = pcRepository.findByCode(productCategoryDTO.getCode());		
		if ( optionalProductCategory.isPresent() ) {
			throw new ProductCategoryDuplicateException("Categoria de Produto já cadastrada");
		}
		final ProductCategory productCategory = new ProductCategory
			(
				productCategoryDTO.getCode(),
				productCategoryDTO.getCategory(),
				productCategoryDTO.getFtsubcategory(),
				productCategoryDTO.getSdsubcategory()
			);
		return pcRepository.save(productCategory);
	}

	@Override
	public ProductCategory getByCode(
			final String code) 
	{
		final Optional<ProductCategory> optionalProductCategory = pcRepository.findByCode(code);
		if ( ! optionalProductCategory.isPresent() ) {
			throw new ProductCategoryNotFoundException("Categoria de Produto não encontrada");
		}
		return optionalProductCategory.get();
	}

	@Override
	public void update(
			final ProductCategoryDTO productCategoryDTO) 
	{
		final ProductCategory productCategory = getByCode(productCategoryDTO.getCode());
		productCategory.setCode(productCategoryDTO.getCode());
		productCategory.setCategory(productCategoryDTO.getCategory());
		productCategory.setFtSubcategory(productCategoryDTO.getFtsubcategory());
		productCategory.setSdSubCategory(productCategoryDTO.getSdsubcategory());
		pcRepository.save(productCategory);
	}
}