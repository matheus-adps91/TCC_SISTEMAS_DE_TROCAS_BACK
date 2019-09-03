package matheus.adps.com.br.sistemadetrocas.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity
public class Product 
{
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Integer id;

    @NotNull
    @Column( unique = true )
    private String code;
    
    @NotNull
    @Column
    private String name;
    
	@Column
	private String description;
	
	@ManyToOne
	@JoinColumn( name = "id_category", foreignKey = @ForeignKey( name = "fk_product_category_product"), nullable = false)
	private ProductCategory productCategory;

	public Product() {
	}

	public Product(
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

	public Integer getId() {
		return id;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
}