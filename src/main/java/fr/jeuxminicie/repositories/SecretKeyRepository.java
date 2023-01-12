package fr.jeuxminicie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.jeuxminicie.entities.SecretKey;


@Repository
public interface SecretKeyRepository extends JpaRepository<SecretKey, Long>{

	@Query("FROM SecretKey")
	SecretKey retrieveSecretKey();
}
