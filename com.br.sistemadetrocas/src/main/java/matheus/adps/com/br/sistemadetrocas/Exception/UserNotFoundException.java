package matheus.adps.com.br.sistemadetrocas.Exception;

public class UserNotFoundException 
	extends
		RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(
			final String message) 
	{
		super(message);
	}
}