package matheus.adps.com.br.sistemadetrocas.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="product_deal_entity", schema = "public")
public class ProductDeal 
{	
	@Id
	@SequenceGenerator( name="gen_product_deal_seq", sequenceName = "product_deal_entity_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_product_deal_seq" )	
	private Integer id;
	
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "id_user_product_proponent", referencedColumnName = "id_user", foreignKey = @ForeignKey(name = "fk_product_proponent_product_deal"), nullable = false),
			@JoinColumn(name = "id_prod_proponent", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_product_proponent_product_deal"), nullable = false)})
	private Product productProponent;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "id_user_product_proposed", referencedColumnName = "id_user", foreignKey = @ForeignKey(name = "fk_product_proposed_product_deal"), nullable = false),
		@JoinColumn(name = "id_prod_proposed", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_product_proposed_product_deal"), nullable = false)
	})
	private Product productProposed;
	
	@Column
	private Integer idDeal;

	public ProductDeal() 
	{
	}

	// Construtor usado na lógica dos papéis invertido
	public ProductDeal(
			Product productProponent, 
			Product productProposed) 
	{
		this.productProponent = productProponent;
		this.productProposed = productProposed;
	}
	
	public ProductDeal(
			Product productProponent, 
			Product productProposed, 
			Integer idDeal) 
	{
		this.productProponent = productProponent;
		this.productProposed = productProposed;
		this.idDeal = idDeal;
	}

	public ProductDeal(
			Integer id, 
			Product productProponent, 
			Product productProposed, 
			Integer idDeal) 
	{
		this.id = id;
		this.productProponent = productProponent;
		this.productProposed = productProposed;
		this.idDeal = idDeal;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getIdDeal() {
		return idDeal;
	}

	public Product getProductProponent() {
		return productProponent;
	}

	public Product getProductProposed() {
		return productProposed;
	}

}