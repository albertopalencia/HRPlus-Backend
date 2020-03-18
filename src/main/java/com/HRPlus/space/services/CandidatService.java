package com.HRPlus.space.services;

import java.util.List;

import com.HRPlus.space.entities.Candidat;
import com.HRPlus.space.repositories.ICandidatRepo;

public class CandidatServiceImpl {
	
	private ICandidatRepo candidatRepo ; 

	public List<Candidat> getAllCandidate()
	{
		return candidatRepo.findAll();
	}
	

	
	
}

