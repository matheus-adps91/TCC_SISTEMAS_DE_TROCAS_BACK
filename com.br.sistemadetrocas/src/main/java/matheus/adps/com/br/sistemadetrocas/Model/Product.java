package matheus.adps.com.br.sistemadetrocas.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name="product_entity", schema ="public")
public class Product 
	implements 
		Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator( name = "gen_user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "gen_user_seq" )
    private Integer id;
    
    @Column( unique = true )
    private String name;
    
	@Column
	private String description;
	
	@Column
	private String productCategory;

    @Column
    private String imagePath;
    
    @Column
    private Boolean dealing;

	@ManyToOne
	@JoinColumn (name = "id_user", foreignKey = @ForeignKey( name = "fk_product_user"), nullable = false)
	private User user;
	
	public Product() 
	{
	}
	
	public Product(
			String name, 
			String description, 
			String productCategory,
			String imagePath,
			Boolean dealing,
			User user)
	{
		this.name = name;
		this.description = description;
		this.productCategory = productCategory;
		this.imagePath = imagePath;
		this.dealing = dealing;
		this.user = user;
	}

	public Product(
			Integer id, 
			String name, 
			String description, 
			String productCategory, 
			String imagePath,
			Boolean dealing, 
			User user) 
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.productCategory = productCategory;
		this.imagePath = imagePath;
		this.dealing = dealing;
		this.user = user;
	}

	public Integer getId() {
		return id;
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

	public String getImageName() {
		return imagePath;
	}

	public Boolean getDealing() {
		return dealing;
	}
	
	public User getUser() {
		return user;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}