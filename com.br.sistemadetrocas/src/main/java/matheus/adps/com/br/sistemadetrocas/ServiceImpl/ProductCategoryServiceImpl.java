package matheus.adps.com.br.sistemadetrocas.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.ProductCategoryDTO;
import matheus.adps.com.br.sistemadetrocas.Exception.ProductCategoryDuplicateException;
import matheus.adps.com.br.sistemadetrocas.Exception.ProductCategoryNotFoundException;
import matheus.adps.com.br.sistemadetrocas.Model.ProductCategory;
import matheus.adps.com.br.sistemadetrocas.Repository.ProductCategoryRepository;
import matheus.adps.com.br.sistemadetrocas.Service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl 
	implements 
		ProductCategoryService
{
	@Autowired
	private ProductCategoryRepository pcRepository;
	
	@Override
	public void create(
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
						productCategoryDTO.getSdsubcategory(),
						productCategoryDTO.getDescription()
				);
		pcRepository.save(productCategory);
	}

	@Override
	public ProductCategory getByCode(
			final String code) {
		final Optional<ProductCategory> optionalProductCategory = pcRepository.findByCode(code);
		if ( ! optionalProductCategory.isPresent() ) {
			throw new ProductCategoryNotFoundException("Categoria de Produto não encontrada");
		}
		return optionalProductCategory.get();
	}

	@Override
	public void update(ProductCategoryDTO productCategoryDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProductCategory(String code) {
		// TODO Auto-generated method stub

	}

}
