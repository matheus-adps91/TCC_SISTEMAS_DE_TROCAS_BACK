package matheus.adps.com.br.sistemadetrocas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.adps.com.br.sistemadetrocas.dto.ProductDTO;
import matheus.adps.com.br.sistemadetrocas.model.Product;
import matheus.adps.com.br.sistemadetrocas.service.ProductService;

@CrossOrigin( origins = "*", allowedHeaders = "*" )
@RestController
@RequestMapping( path = "/product" )
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@PostMapping( path = "/create" )
	public ResponseEntity<Product> create(
			@RequestBody final ProductDTO productDTO)
	{
		return new ResponseEntity<>(productService.create(productDTO), HttpStatus.CREATED);
	}
	
	@GetMapping( path = "/get-by-code/{code}" )
	public ResponseEntity<Product> get(
			@PathVariable final String code)
	{
		return new ResponseEntity<>(productService.getByCode(code), HttpStatus.OK);
	}
	
	@GetMapping(path = "/get-all" )
	public List<Product> getAll()
	{
		return productService.getAll();				
	}
	
	
	@PatchMapping( path = "/update-by-code" )
	public ResponseEntity<Product> update(
			@RequestBody final ProductDTO productDTO)
	{
		return new ResponseEntity<>(productService.updateByCode(productDTO), HttpStatus.OK);
	}
	
	@DeleteMapping( path = "/delete-by-code/{code}" )
	public String delete(
			@PathVariable final String code )
	{
		return productService.delete(code);
	}
}
