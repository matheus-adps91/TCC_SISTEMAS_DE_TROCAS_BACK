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

	public ProductDTO() {
	}

	public ProductDTO(
			String name, 
			String description, 
			String productCategory, 
			String imagePath)
	{		
		this.name = name;
		this.description = description;
		this.productCategory = productCategory;
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

	public String getImagePath() {
		return imagePath;
	}
}