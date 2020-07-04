package matheus.adps.com.br.sistemadetrocas.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO 
{
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String description;
	
	@JsonProperty
	private String productCategory;
	
	@JsonProperty
	private String imagePath;
	
	@JsonProperty
	private Boolean dealing;

	public ProductDTO() 
	{
	}

	public ProductDTO(
			String name, 
			String description, 
			String productCategory,
			Boolean dealing,
			String imagePath)
	{		
		this.name = name;
		this.description = description;
		this.productCategory = productCategory;
		this.dealing = dealing;
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getProductCategory() {
		return productCategory;
	}
	
	public Boolean getDealing() {
		return dealing;
	}

	public String getImagePath() {
		return imagePath;
	}
}