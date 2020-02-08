package com.HRPlus.space.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.HRPlus.space.entities.Conge;
import com.HRPlus.space.services.CongeServiceImpl;


public class CongeController {
	
	private CongeServiceImpl congeService ;
	
	@GetMapping("/conges")
	public List<Conge> getAllConge(){
		return congeService.getAllConges();
				
	}
	
	
}
