package matheus.adps.com.br.sistemadetrocas.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.ProductDTO;
import matheus.adps.com.br.sistemadetrocas.Exception.ProductDuplicate;
import matheus.adps.com.br.sistemadetrocas.Exception.ProductNotFoundException;
import matheus.adps.com.br.sistemadetrocas.Model.Product;
import matheus.adps.com.br.sistemadetrocas.Repository.ProductRepository;
import matheus.adps.com.br.sistemadetrocas.Service.ProductService;

@Service
public class ProductServiceImpl 
	implements 
		ProductService 
{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void create(
			final ProductDTO productDTO) 
	{
		final Product retrievedProduct = getByCode(productDTO.getCode());
		if ( productDTO.getCode().equals(retrievedProduct.getCode())) {
			throw new ProductDuplicate("Produto já cadastrado");
		}
		final Product product = new Product
			(
				productDTO.getCode(),
				productDTO.getName(),
				productDTO.getDescription(),
				productDTO.getProductCategory()
			);
		productRepository.save(product);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
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
	public void update(ProductDTO productDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String code) {
		// TODO Auto-generated method stub

	}
}