package matheus.adps.com.br.sistemadetrocas.Exception;

public class ProductNotFoundException
	extends 
		RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(
			String message)
	{
		super(message);	
	}

	
}
