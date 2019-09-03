package matheus.adps.com.br.sistemadetrocas.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCategoryDTO
{
	@JsonProperty
	private String code;
	
	@JsonProperty
	private String category;
	
	@JsonProperty
	private String ftsubcategory;
	
	@JsonProperty
	private String sdsubcategory;

	public ProductCategoryDTO() {
	}

	public ProductCategoryDTO(
			String code,
			String category, 
			String ftsubcategory, 
			String sdsubcategory)
	{
		this.code = code;
		this.category = category;
		this.ftsubcategory = ftsubcategory;
		this.sdsubcategory = sdsubcategory;
	}

	public String getCode() {
		return code;
	}

	public String getCategory() {
		return category;
	}

	public String getFtsubcategory() {
		return ftsubcategory;
	}

	public String getSdsubcategory() {
		return sdsubcategory;
	}
}