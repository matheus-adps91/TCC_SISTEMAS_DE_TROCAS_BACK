package matheus.adps.com.br.sistemadetrocas.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginUserDTO 
{
	@JsonProperty
	private String email;
	
	@JsonProperty
	private String password;

	public LoginUserDTO() 
	{
	}

	public LoginUserDTO(
			String email, 
			String password) 
	{
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}	
}
