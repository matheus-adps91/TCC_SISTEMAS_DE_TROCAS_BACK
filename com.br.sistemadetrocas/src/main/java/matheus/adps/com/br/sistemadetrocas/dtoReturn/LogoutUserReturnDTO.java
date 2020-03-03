package matheus.adps.com.br.sistemadetrocas.dtoReturn;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogoutUserReturnDTO 
{
	@JsonProperty
	private boolean success;

	public LogoutUserReturnDTO() 
	{
	}

	public LogoutUserReturnDTO(
			final boolean success) 
	{
		this.success = success;
	}
}