package fr.jeuxminicie.services;

import java.util.List;

public interface GenericService<T> {

	T getById(long id) throws Exception;
	
	List<T> getAll() throws Exception;
	
	void deleteById(long id) throws Exception;
	
}
