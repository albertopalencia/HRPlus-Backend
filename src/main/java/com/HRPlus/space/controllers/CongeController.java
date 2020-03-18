package com.HRPlus.space.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HRPlus.space.entities.Conge;
import com.HRPlus.space.repositories.ICongeRepo;
import com.HRPlus.space.services.CongeServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CongeController {
	
	@Autowired
	private CongeServiceImpl congeService ;
	
	@Autowired
	private ICongeRepo congeRepo ; 
	
	@GetMapping("/conges")
	public List<Conge> getAllConge(){
		return congeService.getAllConges();
				
	}
	
	@PostMapping("/createConge")
	public Conge createConge ( @Valid @RequestBody Conge conge) {
		return congeRepo.save(conge);
	}
	
	
}
