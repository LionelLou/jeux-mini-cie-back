package fr.jeuxminicie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.jeuxminicie.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
