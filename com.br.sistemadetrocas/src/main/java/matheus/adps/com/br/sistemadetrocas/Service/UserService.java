package matheus.adps.com.br.sistemadetrocas.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.UserSignupDTO;
import matheus.adps.com.br.sistemadetrocas.DTO.UserUpdateDTO;
import matheus.adps.com.br.sistemadetrocas.Model.User;

public interface UserService
{
	public void create(
			final UserSignupDTO userSignupDTO);
	
	public User getByEmail(
			String email);
	
	public void update(
			final UserUpdateDTO userUpdateDTO);
}