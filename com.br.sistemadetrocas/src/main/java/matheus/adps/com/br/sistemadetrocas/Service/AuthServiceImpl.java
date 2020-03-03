package matheus.adps.com.br.sistemadetrocas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.dto.LoginUserDTO;
import matheus.adps.com.br.sistemadetrocas.dtoReturn.LoginUserReturnDTO;
import matheus.adps.com.br.sistemadetrocas.dtoReturn.LogoutUserReturnDTO;
import matheus.adps.com.br.sistemadetrocas.model.Session;
import matheus.adps.com.br.sistemadetrocas.model.User;
import matheus.adps.com.br.sistemadetrocas.wrapper.LoginWrapper;
import matheus.adps.com.br.sistemadetrocas.wrapper.LogoutWrapper;

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
	public LoginWrapper login(
			final LoginUserDTO loginUserDTO) 
	{	
		final User user = userService.getByEmail(loginUserDTO.getEmail());
		final String crypthografiedPass = userService.cryptographyPassword(loginUserDTO.getPassword());
		if ( !crypthografiedPass.equals(user.getPassword() ) ) {
			final LoginUserReturnDTO userNotAuth = new LoginUserReturnDTO(loginUserDTO.getEmail());
			return new LoginWrapper(HttpStatus.UNAUTHORIZED, userNotAuth);
		}
		final Session openedSession = sessionService.createSession(user);
		final LoginUserReturnDTO userAuth = new LoginUserReturnDTO(openedSession.getToken(), user.getEmail(), user.getFullName());
		return new LoginWrapper(HttpStatus.CREATED, userAuth);
	}

	@Override
	public LogoutWrapper logout(
			final String token) 
	{
		final boolean finalizedSession = sessionService.finalizeSession(token);
		final LogoutUserReturnDTO logoutReturn = new LogoutUserReturnDTO(true);
		return new LogoutWrapper(HttpStatus.OK,logoutReturn);
	}
}