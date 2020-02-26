package matheus.adps.com.br.sistemadetrocas.service;

import matheus.adps.com.br.sistemadetrocas.dto.LoginUserDTO;
import matheus.adps.com.br.sistemadetrocas.dto.LoginUserReturnDTO;
import matheus.adps.com.br.sistemadetrocas.dto.LogoutUserReturnDTO;

public interface AuthService 
{
	LoginUserReturnDTO login(
			LoginUserDTO loginUserDTO);
	
	LogoutUserReturnDTO logout(
			String token);
}