package com.workSchedule.workSchedule.controller;

import java.util.List;

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

import com.workSchedule.workSchedule.dtos.AddProjectDTO;
import com.workSchedule.workSchedule.dtos.ProjectDTO;
import com.workSchedule.workSchedule.dtos.TimesheetEntryDTO;
import com.workSchedule.workSchedule.service.ProjectService;
import com.workSchedule.workSchedule.service.UserService;
import com.workSchedule.workSchedule.util.Authorized;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping()
	public ResponseEntity<List<ProjectDTO>> getAll( @RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return projectService.getAll(email);
	}
	@PostMapping()
	public ResponseEntity<ProjectDTO> saveProject(@RequestBody AddProjectDTO projectDTO, @RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return projectService.saveProject(projectDTO,email);
	}
	
}
