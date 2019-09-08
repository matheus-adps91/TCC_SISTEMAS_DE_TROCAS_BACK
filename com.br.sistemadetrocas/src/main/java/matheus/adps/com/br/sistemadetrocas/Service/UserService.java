package matheus.adps.com.br.sistemadetrocas.service;

import matheus.adps.com.br.sistemadetrocas.dto.UserSignupDTO;
import matheus.adps.com.br.sistemadetrocas.dto.UserUpdateDTO;
import matheus.adps.com.br.sistemadetrocas.model.User;

public interface UserService
{
	void create(
			UserSignupDTO userSignupDTO);
	
	User getByEmail(
			String email);
	
	void update(
			UserUpdateDTO userUpdateDTO);
}