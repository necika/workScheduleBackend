package com.workSchedule.workSchedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workSchedule.workSchedule.dtos.MorningMeetingDTO;
import com.workSchedule.workSchedule.dtos.TimesheetEntryDTO;
import com.workSchedule.workSchedule.service.MorningMeetingService;
import com.workSchedule.workSchedule.service.UserService;
import com.workSchedule.workSchedule.util.Authorized;

@RestController
@RequestMapping("/morningMeeting")
public class MorningMeetingController {

	@Autowired
	private MorningMeetingService meetingService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/byToday/{date}")
	public ResponseEntity<MorningMeetingDTO> byToday(@PathVariable String date, @RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return meetingService.getMorningMeetingByToday(date);
	}
	@PostMapping("{date}")
	public ResponseEntity<MorningMeetingDTO> saveMorningMeeting(@PathVariable String date,@RequestBody MorningMeetingDTO meetingDTO, @RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return meetingService.saveMorningMeeting(meetingDTO,date,email);
	}
	
}
