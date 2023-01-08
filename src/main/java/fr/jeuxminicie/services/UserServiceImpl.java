package fr.jeuxminicie.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.jeuxminicie.dtos.UserDto;
import fr.jeuxminicie.dtos.UserUpdateDto;
import fr.jeuxminicie.entities.User;
import fr.jeuxminicie.mappers.UserMapper;
import fr.jeuxminicie.repositories.UserRepository;
import fr.jeuxminicie.tools.EmailTools;
import fr.jeuxminicie.tools.HashTools;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService, GenericService<UserDto> {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserMapper mapper;

	@Override
	public UserDto getById(long id) throws Exception {
		return mapper.userToUserDto(repository.getReferenceById(id));
	}

	@Override
	public List<UserDto> getAll() throws Exception {

		return repository.findAll().stream().map(mapper::userToUserDto).collect(Collectors.toList());
	}

	@Override
	public void deleteById(long id) throws Exception {
		repository.deleteById(id);
	}
	
	
	
	@Override
	public User checkIfUserEmailExistsAndReturnUser(UserUpdateDto userUpdateDto) throws Exception {
		
		User user = repository.findByEmail(userUpdateDto.getEmail()).orElse(null);
		
		
		if(user == null) {
			throw new Exception("User with given email not found !");
		}
		
		return user;
	}
	
	
	@Override
	public void checkUserCredentials(User user, UserUpdateDto userUpdateDto) throws Exception {
		
		if( user.getPassword() != HashTools.hashSHA512(userUpdateDto.getPassword())){
			throw new Exception("Wrong password !");
		}
		
	}

	@Override
	public UserDto updateUserEmail(UserUpdateDto userUpdateDto) throws Exception {

		User user = checkIfUserEmailExistsAndReturnUser(userUpdateDto);
		
		checkUserCredentials(user, userUpdateDto);
		
		if( !EmailTools.checkIfEmailIsValid(userUpdateDto.getNewEmail())) {
			throw new Exception("Email format is not valid !");
		}
		
		user.setEmail(userUpdateDto.getNewEmail());

		User userPersisted = repository.saveAndFlush(user);
		
		UserDto userPersistedDto = mapper.userToUserDto(userPersisted);
		
		return userPersistedDto;
		
	}

	@Override
	public UserDto updateUserPassword(UserUpdateDto userUpdateDto) throws Exception {

		
		User user = checkIfUserEmailExistsAndReturnUser(userUpdateDto);
		
		checkUserCredentials(user, userUpdateDto);
		
		if (userUpdateDto.getNewPassword().length() < 8) {
			throw new Exception("Password is too short !");
		}
		
		
		user.setPassword(HashTools.hashSHA512(userUpdateDto.getNewPassword()));
		
		User userPersisted = repository.saveAndFlush(user);
		
		UserDto userPersistedDto = mapper.userToUserDto(userPersisted);
		
		return userPersistedDto;
	}

	@Override
	public UserDto createNewUser(UserUpdateDto newUser) throws Exception {

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
		if (newUser.getPassword().length() < 8) {
			throw new Exception("Password is too short !");
		}

		User userToPersist = mapper.userUpdateDtoToUser(newUser);

		userToPersist.setId(0);
		userToPersist.setVersion(0);
		userToPersist.setPassword(HashTools.hashSHA512(newUser.getPassword()));

		User userPersisted = repository.saveAndFlush(userToPersist);
		UserDto userPersistedDto = mapper.userToUserDto(userPersisted);

		return userPersistedDto;
	}

	@Override
	public UserDto resetUserPassword(UserUpdateDto userUpdateDto) throws Exception {

		
		User user = checkIfUserEmailExistsAndReturnUser(userUpdateDto);
		
		
		user.setPassword(HashTools.hashSHA512(userUpdateDto.getNewPassword()));
		
		User userPersisted = repository.saveAndFlush(user);
		
		UserDto userPersistedDto = mapper.userToUserDto(userPersisted);
		
		return userPersistedDto;
		
	}





}
