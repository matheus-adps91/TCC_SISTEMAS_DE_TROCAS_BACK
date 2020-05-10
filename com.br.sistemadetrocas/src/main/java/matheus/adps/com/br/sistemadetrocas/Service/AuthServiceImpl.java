package matheus.adps.com.br.sistemadetrocas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.LoginUserDTO;
import matheus.adps.com.br.sistemadetrocas.DTOReturn.LoginUserReturnDTO;
import matheus.adps.com.br.sistemadetrocas.DTOReturn.LogoutUserReturnDTO;
import matheus.adps.com.br.sistemadetrocas.Model.Session;
import matheus.adps.com.br.sistemadetrocas.Model.User;

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
			return null;
		}
		final Session openedSession = sessionService.createSession(user);
		final LoginUserReturnDTO userAuth = new LoginUserReturnDTO(openedSession.getToken(), user.getEmail(), user.getFullName());
		return userAuth;
	}

	@Override
	public LogoutUserReturnDTO logout(
			final String token) 
	{
		final boolean finalizedSession = sessionService.finalizeSession(token);
		if ( !finalizedSession) {
			return new LogoutUserReturnDTO(false);
		}
		return new LogoutUserReturnDTO(true);
	}
}