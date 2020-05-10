package matheus.adps.com.br.sistemadetrocas.Service;

import matheus.adps.com.br.sistemadetrocas.Model.Session;
import matheus.adps.com.br.sistemadetrocas.Model.User;

public interface SessionService 
{
	Session createSession(
			User user);
	
	Session getSessionByToken(
		String token);
	
	boolean finalizeSession(
			String token);
	
	boolean isValidSession(
			Session session);
}