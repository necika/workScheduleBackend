package com.workSchedule.workSchedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.workSchedule.workSchedule.service.TimesheetMonthService;
import com.workSchedule.workSchedule.service.UserService;
import com.workSchedule.workSchedule.util.Authorized;

@RestController
@RequestMapping("/timesheetMonth")
public class TimesheetMonthController {

	@Autowired
	TimesheetMonthService tsMonthService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getId/{month}")
	public ResponseEntity<Long> getTimesheetMonthId(@PathVariable String month, @RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return tsMonthService.getTimesheetMonthId(month);
	}
	
}
