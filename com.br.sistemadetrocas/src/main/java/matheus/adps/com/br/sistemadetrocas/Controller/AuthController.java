package matheus.adps.com.br.sistemadetrocas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.adps.com.br.sistemadetrocas.dto.LoginUserDTO;
import matheus.adps.com.br.sistemadetrocas.dtoReturn.LoginUserReturnDTO;
import matheus.adps.com.br.sistemadetrocas.dtoReturn.LogoutUserReturnDTO;
import matheus.adps.com.br.sistemadetrocas.service.AuthService;
import matheus.adps.com.br.sistemadetrocas.wrapper.LoginWrapper;
import matheus.adps.com.br.sistemadetrocas.wrapper.LogoutWrapper;

@CrossOrigin( origins = "*", allowedHeaders = "*" )
@RestController
@RequestMapping ( "/auth" )
public class AuthController 
{
	@Autowired
	private AuthService authService;
	
	@PostMapping( "/login" )
	public ResponseEntity<LoginUserReturnDTO> login(
			@RequestBody @Valid final LoginUserDTO loginUserDTO )
	{
		final LoginWrapper login = authService.login(loginUserDTO);
		return new ResponseEntity<>(login.getLoginUserReturnDTO(), login.getHttpStatus());
	}
	
	@PostMapping( "/logout" )
	public ResponseEntity<LogoutUserReturnDTO> logout(
			@RequestHeader( name = "token" ) final String token )
	{
		final LogoutWrapper logout = authService.logout(token);
		return new ResponseEntity<>( logout.getLogoutUserReturnDTO(), logout.getHttpStatus());
	}
}