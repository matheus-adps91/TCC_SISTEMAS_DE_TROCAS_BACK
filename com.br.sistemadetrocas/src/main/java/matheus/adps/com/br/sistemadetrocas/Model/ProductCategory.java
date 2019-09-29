package matheus.adps.com.br.sistemadetrocas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table( name = "product_category_entity" )
public class ProductCategory
{
	@Id
	@SequenceGenerator( name= "gen_product_category_seq", sequenceName = "product_category_seq", allocationSize = 1)
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "gen_product_category_seq" )
	private Integer id;
	
	@NotNull
	@Column( unique = true )
	private String code;
	
	@NotNull
	@Column
	private String category;

	@NotNull
	@Column
	private String ftsubcategory;

	@NotNull
	@Column
	private String sdsubcategory;

	public ProductCategory() {
	}

	public ProductCategory(
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
}