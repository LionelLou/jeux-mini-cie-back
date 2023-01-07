package fr.jeuxminicie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.jeuxminicie.dtos.NewUserDto;
import fr.jeuxminicie.dtos.UserDto;
import fr.jeuxminicie.entities.User;
import fr.jeuxminicie.mappers.UserMapper;
import fr.jeuxminicie.repositories.UserRepository;
import fr.jeuxminicie.tools.EmailTools;
import fr.jeuxminicie.tools.HashTools;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SignUpService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserMapper mapper;

	public UserDto createNewUser(NewUserDto newUser) throws Exception {

		// Checks if the login is already used
		User userLoginTest = repository.findByLogin(newUser.getLogin()).orElse(null);

		if (userLoginTest != null) {
			throw new Exception("Login is already used !");
		}

		// Checks if the email is valid
		String userEmail = newUser.getEmail();

		// --- checks if the email matches the pattern
		if (EmailTools.checkIfEmailIsValid(userEmail)) {
			throw new Exception("Email format is not valid !");
		}

		// --- checks if the email already exists
		User userEmailTest = repository.findByEmail(userEmail).orElse(null);

		if (userEmailTest != null) {
			throw new Exception("Email is already used !");
		}
		
		// Checks if password is long enough 
		if(newUser.getPassword().length() < 8) {
			throw new Exception("Password is too short !");
		}
		
		
		User userToPersist = mapper.newUserDtoToUser(newUser);
		
		userToPersist.setId(0);
		userToPersist.setVersion(0);
		userToPersist.setPassword(HashTools.hashSHA512(newUser.getPassword()));

		User userPersisted = repository.saveAndFlush(userToPersist);
		UserDto userPersistedDto = mapper.userToUserDto(userPersisted);
		
		return userPersistedDto;
		
	}

}
