package matheus.adps.com.br.sistemadetrocas.controller;

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

import matheus.adps.com.br.sistemadetrocas.dto.LoginUserDTO;
import matheus.adps.com.br.sistemadetrocas.service.AuthService;

@CrossOrigin( origins = "*", allowedHeaders = "*" )
@RestController
@RequestMapping ( "/auth" )
public class AuthController 
{
	@Autowired
	private AuthService authService;
	
	@PostMapping( "/login" )
	public ResponseEntity<String> login(
			@RequestBody @Valid final LoginUserDTO loginUserDTO )
	{
		return new ResponseEntity<>(authService.login(loginUserDTO), HttpStatus.CREATED );
	}
	
	@PostMapping( "/logout" )
	public ResponseEntity<String> logout(
			@RequestHeader( name = "token" ) final String token )
	{
		return new ResponseEntity<>(authService.logout(token), HttpStatus.OK );
	}
}