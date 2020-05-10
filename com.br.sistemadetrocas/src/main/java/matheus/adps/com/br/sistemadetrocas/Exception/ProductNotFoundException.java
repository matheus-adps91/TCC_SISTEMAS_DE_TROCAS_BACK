package matheus.adps.com.br.sistemadetrocas.Exception;

public class ProductNotFoundException
	extends 
		RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(
			final String message)
	{
		super(message);	
	}
}