package matheus.adps.com.br.sistemadetrocas.thread;

import matheus.adps.com.br.sistemadetrocas.model.User;

public class ThreadLocalWithUserContext 
{
	private static ThreadLocal<User> userContext = new ThreadLocal<>();

	public static User getUserContext() 
	{
		return userContext.get();
	}

	public static void setUserContext(
			final User user) 
	{
		userContext.set(user);
	}

	public static void removeUserContext()
	{
		userContext.remove();
	}
}