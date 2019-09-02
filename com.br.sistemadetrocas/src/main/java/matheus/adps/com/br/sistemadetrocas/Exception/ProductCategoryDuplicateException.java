package matheus.adps.com.br.sistemadetrocas.Exception;

public class ProductCategoryDuplicateException 
	extends 
		RuntimeException
{
	private static final long serialVersionUID = 1L;

	public ProductCategoryDuplicateException(
			String message) {
		super(message);
	}	
}