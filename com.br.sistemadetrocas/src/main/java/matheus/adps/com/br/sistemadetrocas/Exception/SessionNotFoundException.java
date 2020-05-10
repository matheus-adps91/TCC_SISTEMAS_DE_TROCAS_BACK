package matheus.adps.com.br.sistemadetrocas.Exception;

public class SessionNotFoundException 
	extends 
	RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public SessionNotFoundException(
			final String msg)
	{
		super(msg);
	}
}