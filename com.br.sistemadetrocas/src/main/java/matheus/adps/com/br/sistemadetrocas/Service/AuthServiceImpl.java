package matheus.adps.com.br.sistemadetrocas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.dto.LoginUserDTO;
import matheus.adps.com.br.sistemadetrocas.dto.LoginUserReturnDTO;
import matheus.adps.com.br.sistemadetrocas.dto.LogoutUserReturnDTO;
import matheus.adps.com.br.sistemadetrocas.exception.InvalidPasswordException;
import matheus.adps.com.br.sistemadetrocas.model.Session;
import matheus.adps.com.br.sistemadetrocas.model.User;

@Service
public class AuthServiceImpl 
	implements 
		AuthService 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private SessionService sessionService;

	@Override
	public LoginUserReturnDTO login(
			final LoginUserDTO loginUserDTO) 
	{	
		final User user = userService.getByEmail(loginUserDTO.getEmail());
		final String crypthografiedPass = userService.cryptographyPassword(loginUserDTO.getPassword());
		if ( !crypthografiedPass.equals(user.getPassword() ) ) {
			throw new InvalidPasswordException(
					String.format("Palavra passe errada para o login: ", user.getEmail()));
		}
		final Session openedSession = sessionService.createSession(user);
		final LoginUserReturnDTO loginReturn = new LoginUserReturnDTO(true, openedSession.getToken());
		return loginReturn;
	}

	@Override
	public LogoutUserReturnDTO logout(
			final String token) 
	{
		final String message = sessionService.finalizeSession(token);
		final LogoutUserReturnDTO logoutReturn = new LogoutUserReturnDTO(true, message);
		return logoutReturn;
	}
}