package com.workSchedule.workSchedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workSchedule.workSchedule.dtos.TimesheetEntryDTO;
import com.workSchedule.workSchedule.service.TimesheetEntryService;
import com.workSchedule.workSchedule.service.UserService;
import com.workSchedule.workSchedule.util.Authorized;

@RestController
@RequestMapping("/timesheetEntry")
public class TimesheetEntryController {
	
	@Autowired
	TimesheetEntryService tseService;
	 
	@Autowired
	private UserService userService;
	
	@GetMapping("/byMonth/{month}")
	public ResponseEntity<List<TimesheetEntryDTO>> getByMonth(@PathVariable String month, @RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return tseService.getTimesheetEntryByMonth(month,email);
	}
	@PostMapping()
	public ResponseEntity<TimesheetEntryDTO> saveTimesheetEntry(@RequestBody TimesheetEntryDTO tsEntryDTO){
		return tseService.saveTimesheetEntry(tsEntryDTO);
	}
	
	//Sta ako izbrisem onog sa pozicijom 0, to proveriti sta raditi, srediti to
	@DeleteMapping()
	public void delete() {
		
	}
}
