package matheus.adps.com.br.sistemadetrocas.exception;

public class ProductCategoryNotFoundException 
	extends 
		RuntimeException
{
	private static final long serialVersionUID = 1L;

	public ProductCategoryNotFoundException(
			final String msg) 
	{
		super(msg);
	}	
}