package matheus.adps.com.br.sistemadetrocas.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.exception.SessionNotFoundException;
import matheus.adps.com.br.sistemadetrocas.model.Session;
import matheus.adps.com.br.sistemadetrocas.model.User;
import matheus.adps.com.br.sistemadetrocas.repository.SessionRepository;

@Service
public class SessionServiceImpl 
	implements 
		SessionService 
{
	@Autowired
	private SessionRepository sessionRepository;
	
	@Override
	public Session createSession(
			final User user ) 
	{
		final LocalDateTime currentDateTime = LocalDateTime.now();
		final LocalDateTime expirationDateTime = evaluateTimeSession( currentDateTime, 60 );
		final String token = generateToken(currentDateTime);
		final Session session = new Session(
				currentDateTime,
				expirationDateTime,
				token,
				user
		);		
		return sessionRepository.save(session); 
	}

	@Override
	public Session getSessionByToken(
			final String token ) 
	{
		Optional<Session> optionalSession = sessionRepository.findByToken(token);
		if ( !optionalSession.isPresent() ) {
			throw new SessionNotFoundException("Sessão não encontrada");
		}
		return optionalSession.get();
	}

	@Override
	public boolean finalizeSession(
			final String token ) 
	{
		final Session session = getSessionByToken(token);
		final LocalDateTime currentDateTime = LocalDateTime.now();
		session.setExpirationDate(currentDateTime);
		sessionRepository.save(session);
		return true;
	}

	@Override
	public boolean isValidSession(
			final Session session ) 
	{
		return session.getExpirationDate().isAfter(LocalDateTime.now());
	}
	
	private LocalDateTime evaluateTimeSession(
			LocalDateTime currDateTime, 
			int minuteTimeSession) 
	{
		return currDateTime.plusMinutes(minuteTimeSession);
	}
	
	private String generateToken(
			LocalDateTime currentDateTime) 
	{		
		return Integer.toString(Math.abs(currentDateTime.hashCode()));
	}
}