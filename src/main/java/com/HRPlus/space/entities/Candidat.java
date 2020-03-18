package com.HRPlus.space.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Candidat extends UserInformation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pathCv;
	private String pathMotivationLetter;
	private String niveauEtud;
	private String titreDiplome;
	private String university;
	private String niveauExp;
	private String experience;
	private Boolean archived ; 
	
	@OneToMany(mappedBy = "candidat")
	private List<CandidateAppelOffre> candidateAppelOffre ; 
}
