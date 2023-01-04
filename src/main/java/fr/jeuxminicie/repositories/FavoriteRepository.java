package fr.jeuxminicie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.jeuxminicie.entities.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long>{

	
}
