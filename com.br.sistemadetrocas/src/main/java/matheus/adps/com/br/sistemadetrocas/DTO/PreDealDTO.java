package matheus.adps.com.br.sistemadetrocas.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PreDealDTO 
{
	@JsonProperty
	private Integer idUserProponent;

	@JsonProperty
	private Integer idProdProponent;
	
	@JsonProperty
	private Integer idUserProposed;
	
	@JsonProperty
	private Integer idProdProposed;
	
	public PreDealDTO()
	{
	}

	public Integer getIdUserProponent() {
		return idUserProponent;
	}

	public Integer getIdProdProponent() {
		return idProdProponent;
	}

	public Integer getIdUserProposed() {
		return idUserProposed;
	}

	public Integer getIdProdProposed() {
		return idProdProposed;
	}
	
}
