package matheus.adps.com.br.sistemadetrocas.model;

import java.time.LocalDateTime;

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
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "user_session_entity" )
public class Session 
{
	@Id
	@SequenceGenerator ( name = "gen_session_seq", sequenceName = "user_session_seq", allocationSize = 1)
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "gen_session_seq" )
	private int id;
	
	@NotNull
	@Column
	private LocalDateTime loginDate;
	
	@NotNull
	@Column
	private LocalDateTime expirationDate;
	
	@NotNull
	@Column
	private String token;
	
	@ManyToOne
	@JoinColumn( name = "id_user", foreignKey = @ForeignKey(name = "fk_user_session_user") )
	private User user;

	public Session() 
	{
	}

	public Session(
			@NotNull LocalDateTime loginDate, 
			@NotNull LocalDateTime expirationDate,
			@NotNull String token, 
			@NotNull User user) 
	{
		this.loginDate = loginDate;
		this.expirationDate = expirationDate;
		this.token = token;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getLoginDate() {
		return loginDate;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public String getToken() {
		return token;
	}

	public User getUser() {
		return user;
	}
	
	public void setExpirationDate(
			final LocalDateTime expirationDate)
	{
		this.expirationDate = expirationDate;
	}	
}