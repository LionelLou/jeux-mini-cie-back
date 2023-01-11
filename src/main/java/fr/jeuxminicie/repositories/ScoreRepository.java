package fr.jeuxminicie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.jeuxminicie.entities.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>{

	
	List<Score> findAllByUserIdAndGameId(long userId, long gameId);
	
	List<Score> findAllByUserId(long userId);
	
	List<Score> findAllByGameId(long gameId);
	
	
	@Query("FROM Score WHERE user.id = :userId ORDER BY score DESC limit 10")
	List<Score> findTopScoresForUserId(@Param("userId") long userId);
	
	@Query("FROM Score WHERE game.id = :gameId ORDER BY score DESC limit 10")
	List<Score> findTopScoresForGameId(@Param("gameId") long gameId);
	
	@Query("FROM Score WHERE user.id = :userId ORDER BY time ASC limit 10")
	List<Score> findTopTimesForUserId(@Param("userId") long userId);
	
	@Query("FROM Score WHERE game.id = :gameId ORDER BY time ASC limit 10")
	List<Score> findTopTimesForGameId(@Param("gameId") long gameId);
	
	@Query("FROM Score WHERE user.id = :userId ORDER BY score DESC, time ASC limit 10")
	List<Score> findTopScoresWithTopTimesForUserId(@Param("userId") long userId);
	
	@Query("FROM Score WHERE user.id = :gameId ORDER BY score DESC, time ASC limit 10")
	List<Score> findTopScoresWithTopTimesForGameId(@Param("gameId") long gameId);
	
	@Query("FROM Score ORDER BY score DESC, time ASC limit 10")
	List<Score> findTopScoresWithTopTimesForAnyGameAndAnyUser();

	
}
