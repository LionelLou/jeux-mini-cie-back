package fr.jeuxminicie.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.jeuxminicie.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

	List<Game> findAllByNameContaining(String name);
	
	Page<Game> findAllByNameContaining(String name, Pageable pageable);
}
