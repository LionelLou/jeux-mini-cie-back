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
	public UserDto getById(long id) {
		
		try {
			return mapper.userToUserDto(repository.getReferenceById(id));
		}catch(NotFoundException e) {
			
		}
		
	}

	@Override
	public List<UserDto> getAll() {

		return repository.findAll().stream()
								   .map(mapper::userToUserDto)
								   .collect(Collectors.toList());
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

	@Override
	public UserDto saveOrUpdate(UserDto object) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
