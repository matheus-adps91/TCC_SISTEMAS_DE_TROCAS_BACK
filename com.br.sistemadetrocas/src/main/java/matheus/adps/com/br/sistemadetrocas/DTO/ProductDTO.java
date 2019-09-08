package matheus.adps.com.br.sistemadetrocas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO 
{
	@JsonProperty
	private String code;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String description;
	
	@JsonProperty
	private String categoryCode;

	public ProductDTO() {
	}

	public ProductDTO(
			String code, 
			String name, 
			String description, 
			String categoryCode) 
	{
		this.code = code;
		this.name = name;
		this.description = description;
		this.categoryCode = categoryCode;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCategoryCode() {
		return categoryCode;
	}
}