package matheus.adps.com.br.sistemadetrocas.service;

import matheus.adps.com.br.sistemadetrocas.dto.UserSignupDTO;
import matheus.adps.com.br.sistemadetrocas.dto.UserUpdateDTO;
import matheus.adps.com.br.sistemadetrocas.model.User;

public interface UserService
{
	User create(
			UserSignupDTO userSignupDTO);
	
	User getByEmail(
			String email);
	
	String update(
			UserUpdateDTO userUpdateDTO);
	
	String updatePassword(
			String newPassword);
	
	String cryptographyPassword(
			String password); 
}