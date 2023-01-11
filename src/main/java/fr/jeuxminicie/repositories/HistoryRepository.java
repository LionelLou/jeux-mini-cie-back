package fr.jeuxminicie.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.jeuxminicie.entities.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long>{

	List<History> findAllByUserLoginContainingOrUserEmailContainingOrGameNameContaining(String userLogin, String userEmail, String gameName);

	Page<History> findAllByUserLoginContainingOrUserEmailContainingOrGameNameContaining(String userLogin, String userEmail, String gameName, Pageable pageable);
	
	List<History> findAllByUserId(long userId);
	
}
