package matheus.adps.com.br.sistemadetrocas.Service;

import java.util.List;

import matheus.adps.com.br.sistemadetrocas.DTO.ProductDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Product;

public interface ProductService 
{
	Product create(
			ProductDTO productDTO);
	
	List<Product> getAll();
	
	Product getByName(
			String name);
	
	Product updateByName(
			ProductDTO productDTO, String productName);
	
	boolean delete(
			String name);
}