package matheus.adps.com.br.sistemadetrocas.wrapper;

import org.springframework.http.HttpStatus;

import matheus.adps.com.br.sistemadetrocas.dtoReturn.UserSignupReturnDTO;

public class SignupCreateWrapper 
	extends CreateWrapper<UserSignupReturnDTO> 
{

	public SignupCreateWrapper(
			final HttpStatus httpStatus, 
			final UserSignupReturnDTO userSignupReturnDTO) 
	{
		this.httpStatus = httpStatus;
		this.returnDTO = userSignupReturnDTO;
	}
	
}