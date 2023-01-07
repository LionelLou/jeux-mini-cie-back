package fr.jeuxminicie.services;

import fr.jeuxminicie.dtos.UserDto;
import fr.jeuxminicie.dtos.UserUpdateDto;

public interface UserService {

	
	UserDto updateUserEmail(UserUpdateDto userUpdateDto) throws Exception;
	
	UserDto updateUserPassword(UserUpdateDto userUpdateDto) throws Exception;
	
	UserDto createNewUser(UserUpdateDto newUser) throws Exception;

}
