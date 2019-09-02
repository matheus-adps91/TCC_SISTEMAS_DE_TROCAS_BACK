package matheus.adps.com.br.sistemadetrocas.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "product_category_entity" )
public class ProductCategory
{
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE )
	private Integer id;
	
	@Column( nullable = false, unique = true )
	private String code;
	
	@Column( nullable = false )
	private String category;

	@Column( nullable = false )
	private String ftsubcategory;

	@Column( nullable = true)
	private String sdsubcategory;
	
	@Column( nullable = true )
	private String description;

	public ProductCategory() {
	}

	public ProductCategory(
			String code,
			String category, 
			String ftsubcategory, 
			String sdsubcategory, 
			String description) 
	{
		this.code = code;
		this.category = category;
		this.ftsubcategory = ftsubcategory;
		this.sdsubcategory = sdsubcategory;
		this.description = description;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setFtSubcategory(String ftsubcategory) {
		this.ftsubcategory = ftsubcategory;
	}

	public void setSdSubCategory(String sdsubcategory) {
		this.sdsubcategory = sdsubcategory;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}