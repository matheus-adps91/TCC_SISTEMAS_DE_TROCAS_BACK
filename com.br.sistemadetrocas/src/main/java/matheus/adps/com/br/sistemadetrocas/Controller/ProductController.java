package matheus.adps.com.br.sistemadetrocas.Controller;

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

import matheus.adps.com.br.sistemadetrocas.DTO.ProductDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Product;
import matheus.adps.com.br.sistemadetrocas.Model.User;
import matheus.adps.com.br.sistemadetrocas.Service.ProductService;
import matheus.adps.com.br.sistemadetrocas.thread.ThreadLocalWithUserContext;

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
		final Product productCreated = productService.create(productDTO);
		if ( productCreated == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/get-all-my-products" )
	public ResponseEntity<List<Product>> getAll()
	{		
		final List<Product> allProducts = productService.getAll();
		if ( allProducts == null ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(allProducts, HttpStatus.OK);				
	}
	
	@GetMapping( path = "/get-by-name/{name}" )
	public ResponseEntity<Product> get(
			@PathVariable final String name)
	{
		final Product productRecovered = productService.getByName(name);
		if ( productRecovered == null ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(productRecovered, HttpStatus.OK);
	}
	
	@PatchMapping( path = "/update-by-name" )
	public ResponseEntity<Product> update(
			@RequestBody final ProductDTO productDTO)
	{
		return new ResponseEntity<>(productService.updateByName(productDTO), HttpStatus.OK);
	}
	
	@DeleteMapping( path = "/delete-by-name/{name}" )
	public boolean delete(
			@PathVariable final String name )
	{
		return productService.delete(name);
	}
}
