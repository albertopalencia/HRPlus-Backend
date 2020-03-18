package com.HRPlus.space.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;

import com.HRPlus.space.entities.Mail;
import com.HRPlus.space.services.EmailService;

public class EmailController {

		@Autowired
	    public EmailService emailService;
		
		@PostMapping("/sendMessage")
		public void sendMessage() {
			Mail mail = new Mail();
			mail.setFrom("hibaattia1@gmail.com");
			mail.setTo("hibaattia1@gmail.com");
			mail.setSubject("titre");
			mail.setContent("content");
			emailService.sendSimpleMessage(mail);
			
		}
		
		
}