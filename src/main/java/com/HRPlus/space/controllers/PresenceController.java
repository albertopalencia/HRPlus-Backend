package com.HRPlus.space.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HRPlus.space.entities.Presence;
import com.HRPlus.space.repositories.PresenceRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PresenceController {

	@Autowired
	private PresenceRepository presenceRepo ; 
	
	@GetMapping("/presences")
	public List<Presence> getAllpresences() {
		return presenceRepo.findAll();
	}
	
	@PostMapping("/createPresence")
	public Presence createPresence(@RequestBody Presence presence) {
		return presenceRepo.save(presence);
	}
}
