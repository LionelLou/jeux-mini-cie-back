package fr.jeuxminicie.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.jeuxminicie.dtos.UserDto;
import fr.jeuxminicie.entities.User;

@Mapper( componentModel="spring" )

public interface UserMapper {

	UserDto userToUserDto(User user);
	
	@Mapping(target = "password", ignore = true)
	User userDtoToUser(UserDto userDto);
	
}
