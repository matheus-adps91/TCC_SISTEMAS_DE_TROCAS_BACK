package matheus.adps.com.br.sistemadetrocas.exception;

public class UserDuplicateException 
	extends
		RuntimeException
{
	private static final long serialVersionUID = 1L;

	public UserDuplicateException(
			final String message) {
		super(message);
	}
}