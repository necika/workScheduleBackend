package com.workSchedule.workSchedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workSchedule.workSchedule.dtos.AddCompanyDTO;
import com.workSchedule.workSchedule.dtos.TimesheetEntryDTO;
import com.workSchedule.workSchedule.service.CompanyService;
import com.workSchedule.workSchedule.service.UserService;
import com.workSchedule.workSchedule.util.Authorized;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping()
	public ResponseEntity<AddCompanyDTO> saveTimesheetEntry(@RequestBody AddCompanyDTO companyDTO, @RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return companyService.save(companyDTO);
	}
}
