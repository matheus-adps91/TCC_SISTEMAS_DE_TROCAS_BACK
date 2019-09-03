package matheus.adps.com.br.sistemadetrocas.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.ProductCategoryDTO;
import matheus.adps.com.br.sistemadetrocas.Model.ProductCategory;

public interface ProductCategoryService
{
	public void create(
			ProductCategoryDTO productCategoryDTO);
	
	public ProductCategory getByCode(
			String code);
	
	public void update(
			ProductCategoryDTO productCategoryDTO);
}