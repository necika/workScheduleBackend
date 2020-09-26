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
import com.workSchedule.workSchedule.dtos.TaskDTO;
import com.workSchedule.workSchedule.service.TaskService;
import com.workSchedule.workSchedule.service.UserService;
import com.workSchedule.workSchedule.util.Authorized;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping()
	public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO tasKDTO, @RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return taskService.addTask(tasKDTO,email);
	}
	
	@PostMapping("/changeToActive")
	public ResponseEntity<TaskDTO> changeToActive(@RequestBody TaskDTO tasKDTO, @RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return taskService.changeToActive(tasKDTO);
	}
	@PostMapping("/changeToClosed")
	public ResponseEntity<TaskDTO> changeToClosed(@RequestBody TaskDTO tasKDTO, @RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return taskService.changeToClosed(tasKDTO);
	}
	
	@GetMapping()
	public ResponseEntity<List<TaskDTO>> getAll( @RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return taskService.getAll(email);
	}
	@GetMapping("{id}")
	public ResponseEntity<List<TaskDTO>> getAllById(@PathVariable Long id,@RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return taskService.getAllById(id);
	}
}
