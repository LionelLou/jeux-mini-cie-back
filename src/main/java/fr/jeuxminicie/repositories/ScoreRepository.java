package fr.jeuxminicie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.jeuxminicie.entities.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>{

}
