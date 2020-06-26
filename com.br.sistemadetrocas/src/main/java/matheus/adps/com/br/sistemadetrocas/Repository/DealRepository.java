package matheus.adps.com.br.sistemadetrocas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matheus.adps.com.br.sistemadetrocas.Model.Deal;

public interface DealRepository 
	extends
		JpaRepository<Deal, Integer>
{

}
