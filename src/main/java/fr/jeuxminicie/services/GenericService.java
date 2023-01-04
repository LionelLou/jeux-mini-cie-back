package fr.jeuxminicie.services;

import java.util.List;

public interface GenericService<T> {

	T getById(long id);
	
	List<T> getAll();
	
	void deleteById(long id);
	
	T saveOrUpdate(T object);
	
}
