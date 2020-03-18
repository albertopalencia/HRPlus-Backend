package com.HRPlus.space.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



import lombok.Data;

@Entity
@Data
public class Todo {
	
	@Id
	@GeneratedValue
	private long id ;
	private String title; 
	private String description;
	private boolean completed=false;
	private Date createdAt;
	
	public Todo(String title) {
		super();
		this.title = title;
	}
	
	
	
	
	
	
	
	
}
