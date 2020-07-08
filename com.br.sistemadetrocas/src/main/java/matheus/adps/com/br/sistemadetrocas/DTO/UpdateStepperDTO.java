package matheus.adps.com.br.sistemadetrocas.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateStepperDTO 
{
	@JsonProperty
	private Integer idProductDeal;

	public Integer getIdProductDeal() {
		return idProductDeal;
	}
}
