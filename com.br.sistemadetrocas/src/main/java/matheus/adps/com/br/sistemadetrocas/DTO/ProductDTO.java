package matheus.adps.com.br.sistemadetrocas.DTO;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import matheus.adps.com.br.sistemadetrocas.Model.ProductCategory;

public class ProductDTO 
{
	@JsonProperty
	private String code;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String description;
	
	@ManyToOne
	@JoinColumn( name = "id_category", foreignKey = @ForeignKey( name = "fk_product_category_product"), nullable = false)
	private ProductCategory productCategory;

	public ProductDTO() {
	}

	public ProductDTO(
			String code, 
			String name, 
			String description, 
			ProductCategory productCategory) 
	{
		this.code = code;
		this.name = name;
		this.description = description;
		this.productCategory = productCategory;
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

	public ProductCategory getProductCategory() {
		return productCategory;
	}
}