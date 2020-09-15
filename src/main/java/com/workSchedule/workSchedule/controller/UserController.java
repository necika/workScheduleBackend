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

import com.workSchedule.workSchedule.dtos.ChangingUserDataDTO;
import com.workSchedule.workSchedule.dtos.UserDTO;
import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.service.UserService;
import com.workSchedule.workSchedule.util.Authorized;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired UserService userService;
	
	@PostMapping()
	public ResponseEntity<MyUser> addUser(@RequestBody UserDTO userDTO,@RequestHeader("Authorization") String token) {
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return userService.addUser(userDTO,email);
	}
	
	@GetMapping()
	public ResponseEntity<List<MyUser>> getAll(@RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return userService.getAll(email);
	}
	
	@PostMapping("/change")
	public ResponseEntity<MyUser> changeUserData(@RequestBody ChangingUserDataDTO userDTO,@RequestHeader("Authorization") String token) {
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return userService.changeUserData(userDTO);
	}
	
	@GetMapping("/inTeam")
	public ResponseEntity<List<MyUser>> getAllByProject(@RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return userService.getAllByProject(email);
	}
	
	@GetMapping("/getTeamLeaders")
	public ResponseEntity<List<MyUser>> getTeamLeaders(@RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return userService.getAllTeamLeaders(email);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MyUser> getById(@PathVariable Long id){
		return userService.getById(id);
	}
	
	@GetMapping("/getId/{id}")
	public ResponseEntity<Long> getId(@RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return userService.getId(email);
	}
	@GetMapping("/getLogged")
	public ResponseEntity<MyUser> getLoggedUser(@RequestHeader("Authorization") String token){
		String email = userService.getEmailFromToken(token);
		if(email != null && !Authorized.isAuthorised(email)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		return userService.getLoggenUser(email);
	}
	
}
