package matheus.adps.com.br.sistemadetrocas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matheus.adps.com.br.sistemadetrocas.dto.UserSignupDTO;
import matheus.adps.com.br.sistemadetrocas.dto.UserUpdateDTO;
import matheus.adps.com.br.sistemadetrocas.model.User;
import matheus.adps.com.br.sistemadetrocas.service.UserService;

@RestController
@RequestMapping( "/user")
public class UserController
{
	@Autowired
	private UserService userService;

	@PostMapping( path = "/create" )
	public void create(
			@RequestBody final UserSignupDTO userSignupDTO)
	{
		userService.create(userSignupDTO);
	}
	
	@GetMapping( path = "/get" )
	public ResponseEntity<User> get(
			@RequestBody final String email)
	{
		return new ResponseEntity<>(userService.getByEmail(email),HttpStatus.OK);
	}
	
	@PatchMapping( path = "/update" )
	public void update(
			@RequestBody final UserUpdateDTO userUpdateDTO)
	{
		userService.update(userUpdateDTO);
	}
}
