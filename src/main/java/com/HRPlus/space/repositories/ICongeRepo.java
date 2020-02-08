package com.HRPlus.space.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HRPlus.space.entities.Conge;

@Repository
public interface ICongeRepo extends JpaRepository<Conge, Long> {

}
