package com.HRPlus.space.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRPlus.space.entities.Conge;
import com.HRPlus.space.repositories.ICongeRepo;

@Service
public class CongeServiceImpl  {
	
	@Autowired
	private ICongeRepo congeRepo ; 
	
	public List<Conge> getAllConges (Conge conge){
		return congeRepo.findAll(); 
	}
	public Optional<Conge> findCongeById (Long id) {
		return congeRepo.findById(id);
	}
	
	public Conge createConge (Conge conge) {
		return congeRepo.save(conge);
	}
	
	public Conge updateConge (Conge conge) {
		return congeRepo.save(conge);
		
	}
	
	public List<Conge> getAllConges() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Conge CreateConge(Conge conge) {
		// TODO Auto-generated method stub
		return null;
	}
	public void deleteConge(Conge conge) {
	   congeRepo.delete(conge);
		
	}
	

}
