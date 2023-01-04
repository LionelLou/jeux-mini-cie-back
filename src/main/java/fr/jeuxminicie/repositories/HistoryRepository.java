package fr.jeuxminicie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.jeuxminicie.entities.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long>{

}
