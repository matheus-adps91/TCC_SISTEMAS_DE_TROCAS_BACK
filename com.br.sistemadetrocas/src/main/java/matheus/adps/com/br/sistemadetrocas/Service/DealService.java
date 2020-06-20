package matheus.adps.com.br.sistemadetrocas.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.DealDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Deal;

public interface DealService 
{
	Deal create(
			DealDTO dealDTO);
}
