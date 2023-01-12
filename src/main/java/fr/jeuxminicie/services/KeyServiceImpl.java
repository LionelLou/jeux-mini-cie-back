package fr.jeuxminicie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import fr.jeuxminicie.entities.SecretKey;
import fr.jeuxminicie.repositories.SecretKeyRepository;

@Service
public class KeyServiceImpl implements KeyService {
	
	@Autowired
	private SecretKeyRepository repository;
	
	@Override
	@Cacheable("secretKey")
	public SecretKey getKey() {
		return repository.retrieveSecretKey();
	}

	
}
