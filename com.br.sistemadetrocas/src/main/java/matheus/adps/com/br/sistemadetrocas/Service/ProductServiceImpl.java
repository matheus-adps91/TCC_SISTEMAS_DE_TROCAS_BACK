package matheus.adps.com.br.sistemadetrocas.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.ProductDTO;
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
		final Product product = new Product(
				productDTO.getName(),
				productDTO.getDescription(),
				productDTO.getProductCategory(),
				productDTO.getImagePath(),
				productDTO.getDealing(),
				ThreadLocalWithUserContext.getUserContext()
				);
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAll() 
	{
		final User user = ThreadLocalWithUserContext.getUserContext();
		final Optional<List<Product>> optionalProducts = productRepository.findByUserId(user.getId());
		if (! optionalProducts.isPresent() ) {
			return new ArrayList<Product>(0);
		}		
		return optionalProducts.get();
	}

	@Override
	public List<Product> getByName(
			final String productName) 
	{
		final User currentUser = ThreadLocalWithUserContext.getUserContext();
		final Optional<List<Product>> optionalProducts = productRepository.findByNameContainingAndUserIdNotAndDealing(
				productName, currentUser.getId(), Boolean.FALSE);
		if ( ! optionalProducts.isPresent() ) {
			return Collections.emptyList();
		}
		return optionalProducts.get();
	}

	@Override
	public List<Product> getProductsByProductCategory(
			final String productCategory) 
	{
		final User currentUser = ThreadLocalWithUserContext.getUserContext();
		final Optional<List<Product>> optionalProducts = productRepository.findByProductCategoryAndUserIdNotAndDealing(
				productCategory, currentUser.getId(), Boolean.FALSE);
		if ( ! optionalProducts.isPresent() ) {
			return Collections.emptyList();
		}
		return optionalProducts.get();
	}
	
	private Product getUniqueProductByName(
			final String productName) 
	{
		final Optional<Product> optionalProduct = productRepository.findByName(productName);
		return optionalProduct.get();	
	}
	
	@Override
	public Product updateByName(
			final ProductDTO productDTO,
			final String productName) 
	{
		final Product product = getUniqueProductByName(productName);		
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());		
		product.setProductCategory(productDTO.getProductCategory());
		product.setImagePath(productDTO.getImagePath());
		return productRepository.save(product);
	}

	@Override
	public boolean delete(
			final String productName) 
	{
		final Product product = getUniqueProductByName(productName);
		productRepository.delete(product);
		return true;
	}

	@Override
	public List<Product> getProductsInDeal(
			final String products) 
	{
		String[] split = products.split("&");
		int idFirstProduct = Integer.parseInt(split[0]);
		int idSecondProduct = Integer.parseInt(split[1]);
		final Product productProponent = getProduct(idFirstProduct);
		final Product productProposed = getProduct(idSecondProduct);
		return Arrays.asList(productProponent, productProposed);
	}
	
	private Product getProduct(
			final Integer id) 
	{
		return productRepository.findById(id).get();
	}

}