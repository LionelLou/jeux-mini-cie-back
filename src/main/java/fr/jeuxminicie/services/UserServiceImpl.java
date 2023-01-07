package fr.jeuxminicie.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.jeuxminicie.dtos.UserDto;
import fr.jeuxminicie.mappers.UserMapper;
import fr.jeuxminicie.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService, GenericService<UserDto>{

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

		return repository.findAll().stream()
								   .map(mapper::userToUserDto)
								   .collect(Collectors.toList());
	}

	@Override
	public void deleteById(long id) throws Exception {
		repository.deleteById(id);
	}
	
	@Override
	public UserDto saveOrUpdate(UserDto userDto) throws Exception {
	
		
		return null;
	}

}
