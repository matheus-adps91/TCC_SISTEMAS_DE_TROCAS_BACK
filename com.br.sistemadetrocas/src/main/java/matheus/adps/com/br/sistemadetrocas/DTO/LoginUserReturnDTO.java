package matheus.adps.com.br.sistemadetrocas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginUserReturnDTO 
{
	@JsonProperty
	private boolean success;
	
	@JsonProperty
	private String token;

	public LoginUserReturnDTO() 
	{
	}

	public LoginUserReturnDTO(
			boolean success, 
			String token) 
	{
		this.success = success;
		this.token = token;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getToken() {
		return token;
	}
}