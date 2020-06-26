package matheus.adps.com.br.sistemadetrocas.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table ( name="deal_entity", schema ="public")
public class Deal 
{
	@Id
	@SequenceGenerator( name = "gen_deal_seq", sequenceName = "deal_entity_seq", allocationSize = 1)
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "gen_deal_seq" )
	private Integer id;
	
	@Column
	private Boolean viewed;
	
	@Column
	private Boolean answered;
	
	@Column
	private Boolean inactive;
	
	@Column
	private String statusProponent;
	
	@Column
	private String statusProposed;

	public Deal() 
	{
	}

	public Deal(
			Boolean viewed, 
			Boolean answered, 
			Boolean inactive, 
			String statusProponent,
			String statusProposed) 
	{
		this.viewed = viewed;
		this.answered = answered;
		this.inactive = inactive;
		this.statusProponent = statusProponent;
		this.statusProposed = statusProposed;
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

	public String getStatusProponent() {
		return statusProponent;
	}

	public String getStatusProposed() {
		return statusProposed;
	}

}
