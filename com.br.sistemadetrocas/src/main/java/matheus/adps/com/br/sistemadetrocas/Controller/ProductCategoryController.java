package matheus.adps.com.br.sistemadetrocas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.adps.com.br.sistemadetrocas.dto.ProductCategoryDTO;
import matheus.adps.com.br.sistemadetrocas.model.ProductCategory;
import matheus.adps.com.br.sistemadetrocas.service.ProductCategoryService;

@CrossOrigin( origins = "*", allowedHeaders = "*" )
@RestController
@RequestMapping( "/product-category" )
public class ProductCategoryController
{
	@Autowired
	private ProductCategoryService pcService;
	
	@PostMapping( path = "/create" )
	public ResponseEntity<ProductCategory> create(
			@RequestBody final ProductCategoryDTO productCategoryDTO)
	{
		return new ResponseEntity<>(pcService.create(productCategoryDTO), HttpStatus.CREATED);
	}
	
	@GetMapping( path = "/get-by-code/{code}" )
	public ResponseEntity<ProductCategory> get(
			@PathVariable final String code)
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