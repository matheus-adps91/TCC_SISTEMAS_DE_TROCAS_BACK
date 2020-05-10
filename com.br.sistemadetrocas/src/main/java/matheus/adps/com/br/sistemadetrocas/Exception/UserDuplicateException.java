package matheus.adps.com.br.sistemadetrocas.Exception;

public class UserDuplicateException 
	extends
		RuntimeException
{
	private static final long serialVersionUID = 1L;

	public UserDuplicateException(
			final String message) 
	{
		super(message);
	}
}