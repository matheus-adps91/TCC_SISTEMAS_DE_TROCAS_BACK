package matheus.adps.com.br.sistemadetrocas.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.UserSignupDTO;
import matheus.adps.com.br.sistemadetrocas.DTO.UserUpdateDTO;
import matheus.adps.com.br.sistemadetrocas.Model.User;

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