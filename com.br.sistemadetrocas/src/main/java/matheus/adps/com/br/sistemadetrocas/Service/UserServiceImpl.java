package matheus.adps.com.br.sistemadetrocas.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

import matheus.adps.com.br.sistemadetrocas.DTO.UserSignupDTO;
import matheus.adps.com.br.sistemadetrocas.DTO.UserUpdateDTO;
import matheus.adps.com.br.sistemadetrocas.Exception.InvalidPasswordException;
import matheus.adps.com.br.sistemadetrocas.Exception.UserDuplicateException;
import matheus.adps.com.br.sistemadetrocas.Exception.UserNotFoundException;
import matheus.adps.com.br.sistemadetrocas.Model.User;
import matheus.adps.com.br.sistemadetrocas.Repository.UserRepository;
import matheus.adps.com.br.sistemadetrocas.thread.ThreadLocalWithUserContext;


@Service
public class UserServiceImpl 
	implements 
		UserService 
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(
			final UserSignupDTO userSignupDTO)
	{
		final Optional<User> optionalUser = userRepository.findByEmail(userSignupDTO.getEmail() );
		if ( optionalUser.isPresent() ) {			
			throw new UserDuplicateException("Usuário já cadastrado");
		}		 
		final User user = new User
			(
				userSignupDTO.getEmail(),
				cryptographyPassword(userSignupDTO.getPassword()),
				userSignupDTO.getFullName(),
				userSignupDTO.getGender(),
				userSignupDTO.getAddress(),
				userSignupDTO.getHouseNumber(),
				userSignupDTO.getState(),
				userSignupDTO.getCity(),
				userSignupDTO.getZipCode(),
				userSignupDTO.getComplement(),
				userSignupDTO.getCompliance()
			);		
		return userRepository.save(user); 
	}

	@Override
	public User getByEmail(
			final String email) 
	{
		final Optional<User> optionalUser = userRepository.findByEmail(email);
		if ( ! optionalUser.isPresent() ) {
			throw new UserNotFoundException("Usuário não encontrado");
		}
		return optionalUser.get();
	}

	@Override
	public String update(
			final UserUpdateDTO userUpdateDTO) 
	{
		final User user = getByEmail(userUpdateDTO.getEmail());
		user.setAddress(userUpdateDTO.getAddress());
		user.setFullName(userUpdateDTO.getFullName());			
		user.setGender(userUpdateDTO.getGender());
		user.setHouseNumber(userUpdateDTO.getHouseNumber());
		user.setState(userUpdateDTO.getState());
		user.setCity(userUpdateDTO.getCity());
		user.setZipCode(userUpdateDTO.getZipCode());
		userRepository.save(user);
		return "Usuário atualizado com sucesso";
	}

	@Override
	public String updatePassword(
			final String newPassword) 
	{
		final User user = ThreadLocalWithUserContext.getUserContext();
		if ( cryptographyPassword(newPassword).equals(user.getPassword() ) ) {
			throw new InvalidPasswordException("Digite uma nova senha");
		}
		user.setPassword(cryptographyPassword(newPassword) );
		userRepository.save(user);
		return "Senha atualizada com sucesso";
	}	
	
	@Override
	public String cryptographyPassword(
			final String password)
	{
		return Hashing.sha256().newHasher().putString(password, StandardCharsets.UTF_8).hash().toString();
	}

}