package com.workSchedule.workSchedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<MyUser> getById(@PathVariable Long id){
		return userService.getById(id);
	}
	
}
