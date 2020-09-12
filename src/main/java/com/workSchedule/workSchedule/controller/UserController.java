package com.workSchedule.workSchedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.service.UserService;
import com.workSchedule.workSchedule.util.Authorized;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired UserService userService;
	
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
