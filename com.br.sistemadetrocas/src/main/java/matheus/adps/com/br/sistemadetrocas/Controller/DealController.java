package matheus.adps.com.br.sistemadetrocas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.adps.com.br.sistemadetrocas.DTO.DealDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Deal;
import matheus.adps.com.br.sistemadetrocas.Service.DealService;

@RestController
@RequestMapping ( path = "/deal" )
public class DealController 
{
	@Autowired
	private DealService dealService;
	
	@PostMapping( path = "/create")
	public ResponseEntity<Deal> create(
			@RequestBody final DealDTO dealDTO)
	{
		final Deal preDealCreated = dealService.create(dealDTO);
		if ( preDealCreated == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
