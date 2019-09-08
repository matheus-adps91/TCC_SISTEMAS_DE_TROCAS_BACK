package matheus.adps.com.br.sistemadetrocas.service;

import java.util.List;

import matheus.adps.com.br.sistemadetrocas.dto.ProductDTO;
import matheus.adps.com.br.sistemadetrocas.model.Product;

public interface ProductService 
{
	Product create(
			ProductDTO productDTO);
	
	List<Product> getAll();
	
	Product getByCode(
			String code);
	
	Product updateByCode(
			ProductDTO productDTO);
	
	String delete(
			String code);
}