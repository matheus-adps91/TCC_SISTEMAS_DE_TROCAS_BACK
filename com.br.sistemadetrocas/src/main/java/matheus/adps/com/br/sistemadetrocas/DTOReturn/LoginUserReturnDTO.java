package matheus.adps.com.br.sistemadetrocas.DTOReturn;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginUserReturnDTO 
{	
	@JsonProperty
	private String token;

	@JsonProperty
	private String email;
	
	@JsonProperty
	private String fullName;
	
	@JsonProperty
	private Integer id;
	
	public LoginUserReturnDTO() 
	{
	}	

	public LoginUserReturnDTO(
			final String email) 
	{
		this.token = "";
		this.email = email;
		this.token = "";
	}

	public LoginUserReturnDTO( 
		final String token,
		final String email,
		final String fullName,
		final Integer id) 
	{
		this.token = token;
		this.email = email;
		this.fullName = fullName;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getToken() {
		return token;
	}

	public String getEmail() {
		return email;
	}
}