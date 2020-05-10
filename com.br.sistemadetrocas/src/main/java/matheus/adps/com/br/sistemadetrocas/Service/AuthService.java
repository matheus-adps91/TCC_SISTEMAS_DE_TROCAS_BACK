package matheus.adps.com.br.sistemadetrocas.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.LoginUserDTO;
import matheus.adps.com.br.sistemadetrocas.DTOReturn.LoginUserReturnDTO;
import matheus.adps.com.br.sistemadetrocas.DTOReturn.LogoutUserReturnDTO;

public interface AuthService 
{
	LoginUserReturnDTO login(
			LoginUserDTO loginUserDTO);
	
	LogoutUserReturnDTO logout(
			String token);
}