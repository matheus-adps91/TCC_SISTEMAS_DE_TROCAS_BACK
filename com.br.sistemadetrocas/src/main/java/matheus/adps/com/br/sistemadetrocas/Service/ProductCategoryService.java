package matheus.adps.com.br.sistemadetrocas.service;

import matheus.adps.com.br.sistemadetrocas.dto.ProductCategoryDTO;
import matheus.adps.com.br.sistemadetrocas.model.ProductCategory;

public interface ProductCategoryService
{
	ProductCategory create(
			ProductCategoryDTO productCategoryDTO);
	
	ProductCategory getByCode(
			String code);
	
	void update(
			ProductCategoryDTO productCategoryDTO);
}