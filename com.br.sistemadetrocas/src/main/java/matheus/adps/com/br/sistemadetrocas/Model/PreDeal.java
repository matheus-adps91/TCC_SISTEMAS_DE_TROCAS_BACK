package matheus.adps.com.br.sistemadetrocas.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="pre_deal_entity", schema = "public")
public class PreDeal 
{
	@Id
	@SequenceGenerator( name = "gen_predeal_seq", sequenceName = "predeal_entity_seq", allocationSize = 1)
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "gen_predeal_seq" )
	private Integer id;
	
	@Column
	private Integer idUserProponent;
	
	@Column
	private Integer idProdProponent;
	
	@Column
	private Integer idUserProposed;
	
	@Column
	private Integer idProdProposed;

	@Column
	private Boolean viewed;
	
	@Column
	private Boolean answered;
	
	@Column
	private Boolean inactive;

	public PreDeal() 
	{
	}

	public PreDeal(
			Integer idUserProponent, 
			Integer idProdProponent, 
			Integer idUserProposed, 
			Integer idProdProposed) 
	{
		this.idUserProponent = idUserProponent;
		this.idProdProponent = idProdProponent;
		this.idUserProposed = idUserProposed;
		this.idProdProposed = idProdProposed;
		this.inactive = false;
		this.answered = false;
		this.viewed = false;
	}


	public PreDeal(
			Integer idUserProponent, 
			Integer idProdProponent, 
			Integer idUserProposed,
			Integer idProdProposed, 
			Boolean viewed, 
			Boolean answered, 
			Boolean inactive) 
	{
		this.idUserProponent = idUserProponent;
		this.idProdProponent = idProdProponent;
		this.idUserProposed = idUserProposed;
		this.idProdProposed = idProdProposed;
		this.viewed = viewed;
		this.answered = answered;
		this.inactive = inactive;
	}
	public Integer getIdUserProponent() {
		return idUserProponent;
	}

	public Integer getIdProdProponent() {
		return idProdProponent;
	}

	public Integer getIdUserProposed() {
		return idUserProposed;
	}

	public Integer getIdProdProposed() {
		return idProdProposed;
	}
	
	public Integer getId() {
		return id;
	}

	public Boolean getViewed() {
		return viewed;
	}

	public Boolean getAnswered() {
		return answered;
	}

	public Boolean getInactive() {
		return inactive;
	}

}