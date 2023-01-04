package fr.jeuxminicie.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.jeuxminicie.entities.Game;
import fr.jeuxminicie.entities.User;

@Repository
public interface MappingRepository {

	@Query("FROM game WHERE game.id = :gameId")
	Game findGameById(@Param("gameId") long gameId);
	
	@Query("FROM user WHERE user.id = :userId")
	User findUserById(@Param("userId") long userId);
	
	
	
}
