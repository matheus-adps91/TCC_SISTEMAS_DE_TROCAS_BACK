package matheus.adps.com.br.sistemadetrocas.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import matheus.adps.com.br.sistemadetrocas.Model.Product;

public class DealDTO 
{
	@JsonProperty
	private Product productProponent;

	@JsonProperty
	private Product productProposed;
	
	@JsonProperty
	private String dealStatusUserProponent;
	
	@JsonProperty
	private String dealStatusUserProposed;
	
	public DealDTO()
	{
	}

	public Product getProductProponent() {
		return productProponent;
	}

	public Product getProductProposed() {
		return productProposed;
	}

	public String getDealStatusUserProponent() {
		return dealStatusUserProponent;
	}
	
	public String getDealStatusUserProposed() {
		return dealStatusUserProposed;
	}
}