package matheus.adps.com.br.sistemadetrocas.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.ProductDTO;
import matheus.adps.com.br.sistemadetrocas.Exception.ProductDuplicate;
import matheus.adps.com.br.sistemadetrocas.Exception.ProductNotFoundException;
import matheus.adps.com.br.sistemadetrocas.Model.Product;
import matheus.adps.com.br.sistemadetrocas.Model.User;
import matheus.adps.com.br.sistemadetrocas.Repository.ProductRepository;
import matheus.adps.com.br.sistemadetrocas.thread.ThreadLocalWithUserContext;

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
				productDTO.getImagePath(),
				ThreadLocalWithUserContext.getUserContext()
				);
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAll() {
		final User user = ThreadLocalWithUserContext.getUserContext();
		final Optional<List<Product>> optionalProducts = productRepository.findByUserId(user.getId());
		if (! optionalProducts.isPresent() ) {
			List<Product> empty = new ArrayList<Product>(0);
			return empty;
		}		
		return optionalProducts.get();
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
			final ProductDTO productDTO,
			final String productName) 
	{
		final Product product = getByName(productName);		
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());		
		product.setProductCategory(productDTO.getProductCategory());
		product.setImagePath(productDTO.getImagePath());
		return productRepository.save(product);
	}

	@Override
	public boolean delete(
			final String name) 
	{
		final Product product = getByName(name);
		productRepository.delete(product);
		return true;
	}
}