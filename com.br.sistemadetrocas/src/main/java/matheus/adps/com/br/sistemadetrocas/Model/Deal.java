package matheus.adps.com.br.sistemadetrocas.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@NamedStoredProcedureQuery( name = "Deal.InsertNewDealSafety", procedureName = "insert_new_deal_safety", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "idProdProponent", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "idProdProposed", type = Integer.class)
})
@Table ( name="deal_entity", schema ="public")
public class Deal 
{
	@Id
	@SequenceGenerator( name = "gen_deal_seq", sequenceName = "deal_entity_seq", allocationSize = 1)
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "gen_deal_seq" )
	private Integer id;
	
	@OneToOne
	@JoinColumn( name = "id_product_proponent", foreignKey = @ForeignKey(name = "fk_deal_product_proponent"), nullable = false)
	private Product productProponent;
	
	@OneToOne
	@JoinColumn( name = "id_product_proposed", foreignKey = @ForeignKey(name = "fk_deal_product_proposed"), nullable = false)
	private Product productProposed;
	
	@Column
	private String dealStatusUserProponent;
	
	@Column
	private String dealStatusUserProposed;

	public Deal() 
	{
	}

	public Deal(
			Product productProponent, 
			Product productProposed,
			String dealStatusUserProponent,
			String dealStatusUserProposed) 
	{
		this.productProponent = productProponent;
		this.productProposed = productProposed;
		this.dealStatusUserProponent = dealStatusUserProponent;
		this.dealStatusUserProposed = dealStatusUserProposed;
	}

	public Product getProductProponent() {
		return productProponent;
	}

	public Product getProductProposed() {
		return productProposed;
	}
	
	public String getDealStatusUserProponent() {
		return dealStatusUserProponent;
	}

	public String getDealStatusUserProposed() {
		return dealStatusUserProposed;
	}
}
