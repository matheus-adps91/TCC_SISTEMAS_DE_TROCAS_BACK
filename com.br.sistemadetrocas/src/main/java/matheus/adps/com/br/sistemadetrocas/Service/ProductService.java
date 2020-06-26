package matheus.adps.com.br.sistemadetrocas.Service;

import java.util.List;

import org.springframework.data.util.Pair;

import matheus.adps.com.br.sistemadetrocas.DTO.ProductDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Product;

public interface ProductService 
{
	Product create(
			ProductDTO productDTO);
	
	List<Product> getAll();
	
	List<Product> getByName(
			String productName);
	
	List<Product> getProductsByProductCategory(
			String productCategory);
	
	List<Product> getProductsInDeal(
			String products);
	
	Product updateByName(
			ProductDTO productDTO, String productName);
	
	boolean delete(
			String productName);

}