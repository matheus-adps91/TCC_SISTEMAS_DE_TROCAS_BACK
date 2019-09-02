package matheus.adps.com.br.sistemadetrocas.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matheus.adps.com.br.sistemadetrocas.DTO.UserSignupDTO;
import matheus.adps.com.br.sistemadetrocas.DTO.UserUpdateDTO;
import matheus.adps.com.br.sistemadetrocas.Exception.UserDuplicateException;
import matheus.adps.com.br.sistemadetrocas.Exception.UserNotFoundException;
import matheus.adps.com.br.sistemadetrocas.Model.User;
import matheus.adps.com.br.sistemadetrocas.Repository.UserRepository;
import matheus.adps.com.br.sistemadetrocas.Service.UserService;

@Service
public class UserServiceImpl 
	implements 
		UserService 
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public void create(
			final UserSignupDTO userSignupDTO)
	{
		final Optional<User> optionalUser = userRepository.findByEmail(userSignupDTO.getEmail());
		if ( optionalUser.isPresent() ) {
			throw new UserDuplicateException("Usuário já cadastrado");
		}
		final User user = new User
				(
					userSignupDTO.getEmail(),
					userSignupDTO.getPassword(),
					userSignupDTO.getFullName(),
					userSignupDTO.getGender(),
					userSignupDTO.getAddress(),
					userSignupDTO.getComplement(),
					userSignupDTO.getState(),
					userSignupDTO.getCity(),
					userSignupDTO.getZipCode()
				);

		userRepository.save(user);
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
	public void update(
			final UserUpdateDTO userUpdateDTO) 
	{
		final Optional<User> optionalUser = userRepository.findByEmail(userUpdateDTO.getEmail());
		final User user = optionalUser.get();
		user.setAddress(userUpdateDTO.getAddress());
		user.setFullName(userUpdateDTO.getFullName());			
		user.setGender(userUpdateDTO.getGender());
		user.setComplement(userUpdateDTO.getComplement());
		user.setState(userUpdateDTO.getState());
		user.setCity(userUpdateDTO.getCity());
		user.setZipCode(userUpdateDTO.getZipCode());
		userRepository.save(user);
	}	
}