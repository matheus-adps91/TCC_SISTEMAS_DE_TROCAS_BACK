package matheus.adps.com.br.sistemadetrocas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogoutUserReturnDTO 
{
	@JsonProperty
	private boolean success;
	
	@JsonProperty
	private String message;

	public LogoutUserReturnDTO() 
	{
	}

	public LogoutUserReturnDTO(
			boolean success, 
			String message) 
	{
		this.success = success;
		this.message = message;
	}
}