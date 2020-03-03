package matheus.adps.com.br.sistemadetrocas.service;

import matheus.adps.com.br.sistemadetrocas.dto.UserSignupDTO;
import matheus.adps.com.br.sistemadetrocas.dto.UserUpdateDTO;
import matheus.adps.com.br.sistemadetrocas.model.User;
import matheus.adps.com.br.sistemadetrocas.wrapper.SignupCreateWrapper;

public interface UserService
{
	SignupCreateWrapper create(
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