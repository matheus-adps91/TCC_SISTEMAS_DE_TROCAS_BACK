package matheus.adps.com.br.sistemadetrocas.Service;

import java.util.List;

import matheus.adps.com.br.sistemadetrocas.DTO.ProductDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Product;

public interface ProductService 
{
	public void create(
			ProductDTO productDTO);
	
	public List<Product> getAll();
	
	public Product getByCode(
			String code);
	
	public void update(
			ProductDTO productDTO);
	
	public void delete(
			String code);
}