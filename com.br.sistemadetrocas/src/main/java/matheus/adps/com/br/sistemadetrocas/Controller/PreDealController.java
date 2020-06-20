package matheus.adps.com.br.sistemadetrocas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.adps.com.br.sistemadetrocas.DTO.PreDealDTO;
import matheus.adps.com.br.sistemadetrocas.Model.PreDeal;
import matheus.adps.com.br.sistemadetrocas.Model.User;
import matheus.adps.com.br.sistemadetrocas.Service.PreDealService;
import matheus.adps.com.br.sistemadetrocas.thread.ThreadLocalWithUserContext;

@RestController
@RequestMapping ( path = "/pre-deal" )
public class PreDealController 
{
	@Autowired
	private PreDealService preDealService;
	
	@PostMapping( path = "/create")
	public ResponseEntity<PreDeal> create (
			@RequestBody final PreDealDTO preDealDTO) 
	{
		final PreDeal preDeal = preDealService.create(preDealDTO);
		if (preDeal == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/has-deal")
	public ResponseEntity<Boolean> hasDeals() 
	{
		final User currentUser = ThreadLocalWithUserContext.getUserContext();
		final Boolean hasDeal = preDealService.hasDeal(currentUser.getId());
		if ( !hasDeal ) {			
			return new ResponseEntity<>(hasDeal, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(hasDeal, HttpStatus.OK);
	}
	
	@GetMapping(path = "/get-all-my-pre-deals")
	public ResponseEntity<List<PreDeal>> get()
	{
		final User currentUser = ThreadLocalWithUserContext.getUserContext();
		final List<PreDeal> preDeals = preDealService.get(currentUser.getId());
		return new ResponseEntity<>(preDeals, HttpStatus.OK);
	}
	
}
