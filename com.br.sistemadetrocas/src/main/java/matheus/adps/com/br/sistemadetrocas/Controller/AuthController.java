package matheus.adps.com.br.sistemadetrocas.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.adps.com.br.sistemadetrocas.DTO.LoginUserDTO;
import matheus.adps.com.br.sistemadetrocas.DTOReturn.LoginUserReturnDTO;
import matheus.adps.com.br.sistemadetrocas.DTOReturn.LogoutUserReturnDTO;
import matheus.adps.com.br.sistemadetrocas.Service.AuthService;

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
		final LoginUserReturnDTO loginReturn =  authService.login(loginUserDTO);
		if (  loginReturn == null ) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(loginReturn, HttpStatus.CREATED);
	}
	
	@PostMapping( "/logout" )
	public ResponseEntity<LogoutUserReturnDTO> logout(
			@RequestHeader( name = "token" ) final String token )
	{
		final LogoutUserReturnDTO logouttReturn = authService.logout(token);
		if ( !logouttReturn.isSuccess()) {
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>( HttpStatus.OK) ;
	}
}