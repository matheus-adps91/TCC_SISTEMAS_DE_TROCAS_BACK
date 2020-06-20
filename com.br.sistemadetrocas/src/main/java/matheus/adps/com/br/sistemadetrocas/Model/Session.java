package matheus.adps.com.br.sistemadetrocas.Model;

import java.time.LocalDateTime;

import javax.annotation.Nonnull;
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
@Table( name = "user_session_entity" )
public class Session 
{
	@Id
	@SequenceGenerator ( name = "gen_session_seq", sequenceName = "user_session_seq", allocationSize = 1)
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "gen_session_seq" )
	private int id;
	
	@Nonnull
	@Column
	private LocalDateTime loginDate;
	
	@Column
	private LocalDateTime logoutDate;
	
	@Nonnull
	@Column
	private LocalDateTime expirationDate;
	
	@Nonnull
	@Column
	private String token;
	
	@ManyToOne
	@JoinColumn( name = "id_user", foreignKey = @ForeignKey(name = "fk_user_session_user") )
	private User user;

	public Session() 
	{
	}

	public Session(
			LocalDateTime loginDate,
			LocalDateTime expirationDate,
			String token, 
			User user) 
	{
		this.loginDate = loginDate;
		this.logoutDate = null;
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

	public LocalDateTime getLogoutDate() {
		return logoutDate;
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
	
	public void setLogoutDate(
			final LocalDateTime logoutDate) {
		this.logoutDate = logoutDate;
	}
	
	public void setExpirationDate(
			final LocalDateTime expirationDate)
	{
		this.expirationDate = expirationDate;
	}	
}