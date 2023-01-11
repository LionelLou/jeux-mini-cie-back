package fr.jeuxminicie.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.jeuxminicie.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);
	
	Optional<User> findByLogin(String login);
	
	List<User> findAllByLoginContainingOrEmailContaining(String login, String email);
	
	Page<User> findAllByLoginContainingOrEmailContaining(String login, String email, Pageable pageable);
}
