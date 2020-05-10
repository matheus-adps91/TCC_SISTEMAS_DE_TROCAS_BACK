package matheus.adps.com.br.sistemadetrocas.Controller;

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

import matheus.adps.com.br.sistemadetrocas.DTO.UserSignupDTO;
import matheus.adps.com.br.sistemadetrocas.DTO.UserUpdateDTO;
import matheus.adps.com.br.sistemadetrocas.DTOReturn.UserSignupReturnDTO;
import matheus.adps.com.br.sistemadetrocas.Model.User;
import matheus.adps.com.br.sistemadetrocas.Service.UserService;

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
		final  User userCreated = userService.create(userSignupDTO);
		if ( userCreated == null ) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
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
