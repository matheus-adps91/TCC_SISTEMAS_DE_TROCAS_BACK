package matheus.adps.com.br.sistemadetrocas.Exception;

public class ProductDuplicate 
	extends 
		RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public ProductDuplicate(
			String message) {
		super(message);
	}
}