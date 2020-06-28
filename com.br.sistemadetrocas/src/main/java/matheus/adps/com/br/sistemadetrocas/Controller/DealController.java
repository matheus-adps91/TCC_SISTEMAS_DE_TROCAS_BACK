package matheus.adps.com.br.sistemadetrocas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.adps.com.br.sistemadetrocas.DTO.CreateDealDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Deal;
import matheus.adps.com.br.sistemadetrocas.Model.ProductDeal;
import matheus.adps.com.br.sistemadetrocas.Model.User;
import matheus.adps.com.br.sistemadetrocas.Service.DealService;
import matheus.adps.com.br.sistemadetrocas.thread.ThreadLocalWithUserContext;

@RestController
@RequestMapping ( path = "/deal" )
public class DealController 
{
	@Autowired
	private DealService dealService;
	
	@PostMapping( path = "/create")
	public ResponseEntity<Deal> create(
			@RequestBody final CreateDealDTO createDealDTO)
	{
		final Deal preDealCreated = dealService.create(createDealDTO);
		if ( preDealCreated == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/has-deal")
	public ResponseEntity<Boolean> hasDeals() 
	{
		final User currentUser = ThreadLocalWithUserContext.getUserContext();
		final Boolean hasDeal = dealService.hasDeal(currentUser.getId());
		if ( !hasDeal ) {			
			return new ResponseEntity<>(hasDeal, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(hasDeal, HttpStatus.OK);
	}
	
	@GetMapping(path = "/get-all-product-deal")
	public ResponseEntity<List<ProductDeal>> get()
	{
		final User currentUser = ThreadLocalWithUserContext.getUserContext();
		final List<ProductDeal> preDealsRecoverd = dealService.get(currentUser.getId());
		if (preDealsRecoverd.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(preDealsRecoverd, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "delete-proposed-deal-by-id/{id}")
	public ResponseEntity<Void> delete(
			@PathVariable final Integer id) 
	{
		dealService.deleteProductDeal(id);
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}
}
