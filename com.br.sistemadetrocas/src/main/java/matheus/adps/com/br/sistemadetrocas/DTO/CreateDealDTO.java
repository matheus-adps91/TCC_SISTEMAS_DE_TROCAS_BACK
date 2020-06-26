package matheus.adps.com.br.sistemadetrocas.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import matheus.adps.com.br.sistemadetrocas.Model.Product;

public class CreateDealDTO 
{
	@JsonProperty
	private Product productProponent;

	@JsonProperty
	private Product productProposed;
	
	public CreateDealDTO()
	{
	}

	public Product getProductProponent() {
		return productProponent;
	}

	public Product getProductProposed() {
		return productProposed;
	}

}