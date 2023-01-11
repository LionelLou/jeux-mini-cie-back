package fr.jeuxminicie.services;

import java.util.List;

import fr.jeuxminicie.dtos.CountDto;

public interface GenericService<T> {

	List<T> getAll() throws Exception;

	List<T> getAllByPage(int page, int max, String search) throws Exception;
	
	T getById(long id) throws Exception;
	
	CountDto count(String search) throws Exception;
	
	void deleteById(long id) throws Exception;
}
