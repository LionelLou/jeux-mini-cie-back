package fr.jeuxminicie.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.jeuxminicie.entities.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long>{

	
	List<Favorite> findAllByUserLoginContainingOrUserEmailContainingOrGameNameContaining(String userLogin, String userEmail, String gameName);
	
	Page<Favorite> findAllByUserLoginContainingOrUserEmailContainingOrGameNameContaining(String userLogin, String userEmail, String gameName, Pageable pageable);
	
	List<Favorite> findAllByUserIdAndGameNameContaining(long userId, String gameName);
	
	Page<Favorite> findAllByUserIdAndGameNameContaining(long userId, String gameName,  Pageable pageable);
	
}
