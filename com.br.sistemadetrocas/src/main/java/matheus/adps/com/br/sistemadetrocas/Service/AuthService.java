package matheus.adps.com.br.sistemadetrocas.service;

import matheus.adps.com.br.sistemadetrocas.dto.LoginUserDTO;
import matheus.adps.com.br.sistemadetrocas.wrapper.LoginWrapper;
import matheus.adps.com.br.sistemadetrocas.wrapper.LogoutWrapper;

public interface AuthService 
{
	LoginWrapper login(
			LoginUserDTO loginUserDTO);
	
	LogoutWrapper logout(
			String token);
}