package matheus.adps.com.br.sistemadetrocas.service;

import matheus.adps.com.br.sistemadetrocas.dto.LoginUserDTO;

public interface AuthService 
{
	String login(
			LoginUserDTO loginUserDTO);
	
	String logout(
			String token);
}