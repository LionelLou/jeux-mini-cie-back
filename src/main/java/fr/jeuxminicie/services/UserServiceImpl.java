package fr.jeuxminicie.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.jeuxminicie.dtos.UserDto;
import fr.jeuxminicie.dtos.UserUpdateDto;
import fr.jeuxminicie.entities.User;
import fr.jeuxminicie.exceptions.CredentialsException;
import fr.jeuxminicie.exceptions.EmailException;
import fr.jeuxminicie.exceptions.NotFoundException;
import fr.jeuxminicie.repositories.UserRepository;
import fr.jeuxminicie.tools.DtoTools;
import fr.jeuxminicie.tools.EmailTools;
import fr.jeuxminicie.tools.HashTools;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	

	@Override
	public UserDto getById(long id) throws Exception {
		
		try {
			return DtoTools.convert(repository.getReferenceById(id), UserDto.class);
		}catch (Exception e) {
			throw new NotFoundException("The ressource with given id could not be found", e);
		}
			
	}

	@Override
	public List<UserDto> getAll() throws Exception {

		
		List<User> users = repository.findAll();
		
		List<UserDto> result = new ArrayList<>();
	
		for ( User user : users ) {
			result.add(DtoTools.convert(user, UserDto.class));
		}
		
		return result;

	}

	@Override
	public void deleteById(long id) throws Exception {
		
		try {
			repository.deleteById(id);
		}catch (Exception e){
			throw new NotFoundException("The ressource with given id could not be found", e);
		}
		
	}
	
	
	
	@Override
	public User checkIfUserEmailExistsAndReturnUser(UserUpdateDto userUpdateDto) throws Exception {
		
		User user = repository.findByEmail(userUpdateDto.getEmail()).orElse(null);
		
		
		if(user == null) {
			throw new EmailException("User with given email not found");
		}
		
		return user;
	}
	
	
	@Override
	public void checkUserCredentials(User user, UserUpdateDto userUpdateDto) throws Exception {
		
		if( !user.getPassword().equals(HashTools.hashSHA512(userUpdateDto.getPassword()))){
			throw new CredentialsException("Wrong credentials");
		}
		
	}

	@Override
	public UserDto updateUserEmail(UserUpdateDto userUpdateDto) throws Exception {

		User user = checkIfUserEmailExistsAndReturnUser(userUpdateDto);
		
		checkUserCredentials(user, userUpdateDto);
		
		if( !EmailTools.checkIfEmailIsValid(userUpdateDto.getNewEmail())) {
			throw new EmailException("Email format is not valid !");
		}
		
		user.setEmail(userUpdateDto.getNewEmail());

		User userPersisted = repository.saveAndFlush(user);
		
		UserDto userPersistedDto = DtoTools.convert(userPersisted, UserDto.class);
		
		return userPersistedDto;
		
	}

	@Override
	public UserDto updateUserPassword(UserUpdateDto userUpdateDto) throws Exception {

		
		User user = checkIfUserEmailExistsAndReturnUser(userUpdateDto);
		
		checkUserCredentials(user, userUpdateDto);
		
		if (userUpdateDto.getNewPassword().length() < 8) {
			throw new CredentialsException("Password is too short !");
		}
		
		
		user.setPassword(HashTools.hashSHA512(userUpdateDto.getNewPassword()));
		
		User userPersisted = repository.saveAndFlush(user);
		
		UserDto userPersistedDto = DtoTools.convert(userPersisted, UserDto.class);;
		
		return userPersistedDto;
	}

	@Override
	public UserDto createNewUser(UserUpdateDto newUser) throws Exception {

		// Checks if the login is already used
		User userLoginTest = repository.findByLogin(newUser.getLogin()).orElse(null);

		if (userLoginTest != null) {
			throw new CredentialsException("Login is already used !");
		}

		// Checks if the email is valid
		String userEmail = newUser.getEmail();

		// --- checks if the email matches the pattern
		if (!EmailTools.checkIfEmailIsValid(userEmail)) {
			throw new EmailException("Email format is not valid !");
		}

		// --- checks if the email already exists
		User userEmailTest = repository.findByEmail(userEmail).orElse(null);

		if (userEmailTest != null) {
			throw new EmailException("Email is already used !");
		}

		// Checks if password is long enough
		if (newUser.getPassword().length() < 8) {
			throw new CredentialsException("Password is too short !");
		}

		User userToPersist = DtoTools.convert(newUser, User.class);

		userToPersist.setId(0);
		userToPersist.setVersion(0);
		userToPersist.setPassword(HashTools.hashSHA512(newUser.getPassword()));

		User userPersisted = repository.saveAndFlush(userToPersist);
		UserDto userPersistedDto = DtoTools.convert(userPersisted, UserDto.class);

		return userPersistedDto;
	}

	@Override
	public UserDto resetUserPassword(UserUpdateDto userUpdateDto) throws Exception {

		
		User user = checkIfUserEmailExistsAndReturnUser(userUpdateDto);
		
		
		user.setPassword(HashTools.hashSHA512(userUpdateDto.getNewPassword()));
		
		User userPersisted = repository.saveAndFlush(user);
		
		UserDto userPersistedDto = DtoTools.convert(userPersisted, UserDto.class);
		
		return userPersistedDto;
		
	}





}
