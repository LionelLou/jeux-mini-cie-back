package fr.jeuxminicie.services;

import java.util.List;

import fr.jeuxminicie.dtos.UserDto;
import fr.jeuxminicie.dtos.UserUpdateDto;
import fr.jeuxminicie.entities.User;

public interface UserService {

	UserDto getById(long id) throws Exception;
	
	List<UserDto> getAll() throws Exception;
	
	void deleteById(long id) throws Exception;
	
	UserDto updateUserEmail(UserUpdateDto userUpdateDto) throws Exception;
	
	UserDto updateUserPassword(UserUpdateDto userUpdateDto) throws Exception;
	
	UserDto createNewUser(UserUpdateDto newUser) throws Exception;
	
	UserDto resetUserPassword(UserUpdateDto userUpdateDto) throws Exception;
	
	void checkUserCredentials(User user, UserUpdateDto userUpdateDto) throws Exception;
	
	User checkIfUserEmailExistsAndReturnUser(UserUpdateDto userUpdateDto) throws Exception;

}
