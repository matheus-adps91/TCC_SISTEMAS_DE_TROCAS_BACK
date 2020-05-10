package matheus.adps.com.br.sistemadetrocas.Exception;

public class InvalidPasswordException 
	extends 
		RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException(
			final String msg) 
	{
		super(msg);
	}
}