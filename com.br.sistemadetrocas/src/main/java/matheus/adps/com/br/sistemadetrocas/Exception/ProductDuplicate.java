package matheus.adps.com.br.sistemadetrocas.exception;

public class ProductDuplicate 
	extends 
		RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public ProductDuplicate(
			final String message) 
	{
		super(message);
	}
}