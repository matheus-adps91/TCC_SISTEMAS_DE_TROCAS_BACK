package matheus.adps.com.br.sistemadetrocas.wrapper;

import org.springframework.http.HttpStatus;

import matheus.adps.com.br.sistemadetrocas.dtoReturn.LogoutUserReturnDTO;

public class LogoutWrapper {

	private HttpStatus httpStatus;
	private LogoutUserReturnDTO logoutUserReturnDTO;
	
	public LogoutWrapper(
			final HttpStatus httpStatus, 
			final LogoutUserReturnDTO logoutUserReturnDTO) 
	{
		this.httpStatus = httpStatus;
		this.logoutUserReturnDTO = logoutUserReturnDTO;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public LogoutUserReturnDTO getLogoutUserReturnDTO() {
		return logoutUserReturnDTO;
	}
		
}
