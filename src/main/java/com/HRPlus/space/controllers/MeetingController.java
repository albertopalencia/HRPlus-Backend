package com.HRPlus.space.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HRPlus.space.entities.Meeting;
import com.HRPlus.space.services.MeetingServiceImpl;

@RestController
public class MeetingController {

	@Autowired
	private MeetingServiceImpl meetingService;

	@GetMapping("/meetings")
	public List<Meeting> getAllMeetings() {
		return (List<Meeting>) meetingService.getAllMeetings();
	}

	@GetMapping("/meetings/{id}")
	public Optional<Meeting> findMeetingById(@PathVariable Long id) {
		return meetingService.findMeetingById(id);
	}

	@PostMapping("/meetings/create")
	public ResponseEntity<Meeting> CreateMeeting(@RequestBody Meeting meeting) {
		try {
			meetingService.saveMeeting(meeting);
			return new ResponseEntity<Meeting>(meeting, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Meeting>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PostMapping("meetings/update")
	public ResponseEntity<Meeting> updateMeeting(@RequestBody Meeting meeting) {
		try {
			meetingService.saveMeeting(meeting);
			return new ResponseEntity<Meeting>(meeting, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Meeting>(HttpStatus.NOT_ACCEPTABLE);

		}

	}

	@DeleteMapping("/meetings/delete/{id}")
	public ResponseEntity<Meeting> deleteMeeting(@PathVariable Long id) {
		Optional<Meeting> m = meetingService.findMeetingById(id);
		if (m.isPresent()) {
			meetingService.deleteMeeting(m.get());
			return new ResponseEntity<Meeting>(m.get(), HttpStatus.ACCEPTED);
		} else
			return new ResponseEntity<Meeting>(HttpStatus.NOT_ACCEPTABLE);
	}

}
