package matheus.adps.com.br.sistemadetrocas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.adps.com.br.sistemadetrocas.DTO.ProductCategoryDTO;
import matheus.adps.com.br.sistemadetrocas.Model.ProductCategory;
import matheus.adps.com.br.sistemadetrocas.Service.ProductCategoryService;

@RestController
@RequestMapping( "/product-category" )
public class ProductCategoryController
{
	@Autowired
	private ProductCategoryService pcService;
	
	@PostMapping( path = "/create" )
	public void create(
			@RequestBody final ProductCategoryDTO productCategoryDTO)
	{
		pcService.create(productCategoryDTO);
	}
	
	@GetMapping( path = "/get" )
	public ResponseEntity<ProductCategory> get(
			@RequestBody final String code)
	{
		return new ResponseEntity<>(pcService.getByCode(code), HttpStatus.OK);
	}
	
	@PatchMapping( path = "/update" )
	public void update(
			@RequestBody final ProductCategoryDTO productCategoryDTO) 
	{
		pcService.update(productCategoryDTO);
	}
}