package matheus.adps.com.br.sistemadetrocas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.adps.com.br.sistemadetrocas.DTO.ProductDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Product;
import matheus.adps.com.br.sistemadetrocas.Service.ProductService;

@RestController
@RequestMapping( path = "/product" )
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@PostMapping( path = "/create" )
	public void create(
			@RequestBody final ProductDTO productDTO)
	{
		productService.create(productDTO);
	}
	
	@GetMapping( path = "/get" )
	public ResponseEntity<Product> get(
			@RequestBody final String code)
	{
		return new ResponseEntity<>(productService.getByCode(code), HttpStatus.OK);
	}
	
}
