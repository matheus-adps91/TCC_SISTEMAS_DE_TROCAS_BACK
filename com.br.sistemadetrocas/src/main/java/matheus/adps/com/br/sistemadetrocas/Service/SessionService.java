package matheus.adps.com.br.sistemadetrocas.service;

import matheus.adps.com.br.sistemadetrocas.model.Session;
import matheus.adps.com.br.sistemadetrocas.model.User;

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