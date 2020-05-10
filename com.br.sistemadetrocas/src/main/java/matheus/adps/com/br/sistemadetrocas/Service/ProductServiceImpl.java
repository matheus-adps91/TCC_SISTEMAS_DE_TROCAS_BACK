package matheus.adps.com.br.sistemadetrocas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.ProductDTO;
import matheus.adps.com.br.sistemadetrocas.Exception.ProductDuplicate;
import matheus.adps.com.br.sistemadetrocas.Model.Product;
import matheus.adps.com.br.sistemadetrocas.Repository.ProductRepository;

@Service
public class ProductServiceImpl 
	implements 
		ProductService 
{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product create(
			final ProductDTO productDTO) 
	{
		final Optional<Product> optionalProduct = productRepository.findByName(productDTO.getName());
		if (optionalProduct.isPresent()) {
			throw new ProductDuplicate("Produto já cadastrado");
		}
		final Product product = new Product(
				productDTO.getName(),
				productDTO.getDescription(),
				productDTO.getProductCategory(),
				productDTO.getImagePath());
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product getByName(
			final String name) 
	{
		final Optional<Product> optionalProduct = productRepository.findByName(name);
		if ( ! optionalProduct.isPresent() ) {
			return null;
		}
		return optionalProduct.get();
	}

	@Override
	public Product updateByName(
			final ProductDTO productDTO) 
	{
		final Product product = getByName(productDTO.getName());		
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());		
		product.setProductCategory(productDTO.getProductCategory());
		return productRepository.save(product);
	}

	@Override
	public boolean delete(
			final String code) 
	{
		final Product product = getByName(code);
		productRepository.delete(product);
		return true;
	}
}