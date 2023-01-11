package fr.jeuxminicie.services;

import fr.jeuxminicie.dtos.UserDto;
import fr.jeuxminicie.dtos.UserUpdateDto;
import fr.jeuxminicie.entities.User;

public interface UserService extends GenericService<UserDto> {
	
	UserDto updateUserEmail(UserUpdateDto userUpdateDto) throws Exception;
	
	UserDto updateUserPassword(UserUpdateDto userUpdateDto) throws Exception;
	
	UserDto createNewUser(UserUpdateDto newUser) throws Exception;
	
	UserDto resetUserPassword(UserUpdateDto userUpdateDto) throws Exception;
	
	void checkUserCredentials(User user, UserUpdateDto userUpdateDto) throws Exception;
	
	User checkIfUserEmailExistsAndReturnUser(UserUpdateDto userUpdateDto) throws Exception;

}
