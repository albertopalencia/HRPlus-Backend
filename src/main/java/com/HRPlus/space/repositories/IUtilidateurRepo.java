package com.HRPlus.space.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HRPlus.space.entities.UserInformation;

@Repository
public interface IUtilidateurRepo extends JpaRepository<UserInformation, Long> {

}
