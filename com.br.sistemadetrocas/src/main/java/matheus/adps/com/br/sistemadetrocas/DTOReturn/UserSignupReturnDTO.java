package matheus.adps.com.br.sistemadetrocas.DTOReturn;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSignupReturnDTO 
{
	@JsonProperty
	private boolean success;

	public UserSignupReturnDTO() 
	{
	}

	public UserSignupReturnDTO(
			final boolean success) 
	{

		this.success = success;
	}

}