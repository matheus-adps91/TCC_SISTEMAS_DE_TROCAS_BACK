package matheus.adps.com.br.sistemadetrocas.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import matheus.adps.com.br.sistemadetrocas.Model.Product;

public class AcceptDealDTO 
{
	@JsonProperty
	private Product productProponent;

	@JsonProperty
	private Product productProposed;
	
	@JsonProperty
	private Integer idDeal;

	@JsonProperty
	private Integer id;
	
	public AcceptDealDTO() 
	{
	}

	public AcceptDealDTO(
			Product productProponent, 
			Product productProposed, 
			Integer idDeal, 
			Integer id)
	{
		this.productProponent = productProponent;
		this.productProposed = productProposed;
		this.idDeal = idDeal;
		this.id = id;
	}

	public Product getProductProponent() {
		return productProponent;
	}

	public Product getProductProposed() {
		return productProposed;
	}
	
	public Integer getIdDeal() {
		return idDeal;
	}

	public Integer getId() {
		return id;
	}

}
