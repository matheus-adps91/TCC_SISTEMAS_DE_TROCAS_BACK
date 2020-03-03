package matheus.adps.com.br.sistemadetrocas.wrapper;

import org.springframework.http.HttpStatus;

public abstract class CreateWrapper<T> {
	
	protected HttpStatus httpStatus;
	protected T returnDTO;
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public T getReturnEntity() {
		return returnDTO;
	}

}