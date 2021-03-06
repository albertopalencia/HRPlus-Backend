package com.HRPlus.space.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HRPlus.space.entities.UserInformation;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUtilidateurRepo extends JpaRepository <UserInformation, Long> {
	
	Optional<UserInformation> findByUsername (String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
   
 

}
