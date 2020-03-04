package matheus.adps.com.br.sistemadetrocas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.adps.com.br.sistemadetrocas.dto.UserSignupDTO;
import matheus.adps.com.br.sistemadetrocas.dto.UserUpdateDTO;
import matheus.adps.com.br.sistemadetrocas.dtoReturn.UserSignupReturnDTO;
import matheus.adps.com.br.sistemadetrocas.model.User;
import matheus.adps.com.br.sistemadetrocas.service.UserService;
import matheus.adps.com.br.sistemadetrocas.wrapper.SignupCreateWrapper;

@CrossOrigin( origins = "*", allowedHeaders = "*" )
@RestController
@RequestMapping( "/user" )
public class UserController
{
	@Autowired
	private UserService userService;
	
	@PostMapping( path = "/create" )
	public ResponseEntity<UserSignupReturnDTO> create(
			@RequestBody final UserSignupDTO userSignupDTO)
	{
		final SignupCreateWrapper signup = userService.create(userSignupDTO);
		return new ResponseEntity<>(signup.getEntity() , signup.getHttpStatus());
	}
	
	@GetMapping( path = "/get-by-email/{email}" )
	public ResponseEntity<User> getByEmail(
			@PathVariable final String email)
	{
		return new ResponseEntity<>(userService.getByEmail(email), HttpStatus.OK);
	}
	
	@PatchMapping( path = "/update" )
	public ResponseEntity<String> update(
			@RequestBody final UserUpdateDTO userUpdateDTO)
	{
		return new ResponseEntity<>(userService.update(userUpdateDTO), HttpStatus.OK);
	}
	
	@PatchMapping( path = "/update-password" )
	public ResponseEntity<String> updatePassword(
			@RequestBody final String newPassword)
	{
		return new ResponseEntity<>(userService.updatePassword(newPassword), HttpStatus.OK);
	}
}
