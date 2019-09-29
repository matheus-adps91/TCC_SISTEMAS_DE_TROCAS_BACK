package matheus.adps.com.br.sistemadetrocas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.dto.ProductDTO;
import matheus.adps.com.br.sistemadetrocas.exception.ProductDuplicate;
import matheus.adps.com.br.sistemadetrocas.exception.ProductNotFoundException;
import matheus.adps.com.br.sistemadetrocas.model.Product;
import matheus.adps.com.br.sistemadetrocas.model.ProductCategory;
import matheus.adps.com.br.sistemadetrocas.repository.ProductRepository;

@Service
public class ProductServiceImpl 
	implements 
		ProductService 
{
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductCategoryServiceImpl productCategoryService;
	
	@Override
	public Product create(
			final ProductDTO productDTO) 
	{
		final Optional<Product> optionalProduct = productRepository.findByCode(productDTO.getCode());
		if (optionalProduct.isPresent()) {
			throw new ProductDuplicate("Produto já cadastrado");
		}
		final ProductCategory productCategory = productCategoryService.getByCode(productDTO.getCategoryCode());
		final Product product = new Product(
				productDTO.getCode(),
				productDTO.getName(),
				productDTO.getDescription(),
				productCategory);
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product getByCode(
			final String code) 
	{
		final Optional<Product> optionalProduct = productRepository.findByCode(code);
		if ( ! optionalProduct.isPresent() ) {
			throw new ProductNotFoundException("Produto não encontrado");
		}
		return optionalProduct.get();
	}

	@Override
	public Product updateByCode(
			final ProductDTO productDTO) 
	{
		final Product product = getByCode(productDTO.getCode());
		final ProductCategory productCategory = productCategoryService.getByCode(productDTO.getCategoryCode());
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());		
		product.setProductCategory(productCategory);
		return productRepository.save(product);
	}

	@Override
	public String delete(
			final String code) 
	{
		final Product product = getByCode(code);
		productRepository.delete(product);
		return "produto deletado - PROVISÓRIO";
	}
}