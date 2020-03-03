package matheus.adps.com.br.sistemadetrocas.wrapper;

import org.springframework.http.HttpStatus;

import matheus.adps.com.br.sistemadetrocas.dtoReturn.LoginUserReturnDTO;

public class LoginWrapper {

	private HttpStatus httpStatus;
	private LoginUserReturnDTO loginUserReturnDTO;
	
	public LoginWrapper(
			final HttpStatus httpStatus, 
			final LoginUserReturnDTO loginUserReturnDTO) 
	{
		this.httpStatus = httpStatus;
		this.loginUserReturnDTO = loginUserReturnDTO;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public LoginUserReturnDTO getLoginUserReturnDTO() {
		return loginUserReturnDTO;
	}
		
}
