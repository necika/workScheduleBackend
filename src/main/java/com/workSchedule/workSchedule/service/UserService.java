package com.workSchedule.workSchedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.repository.UserRepository;
import com.workSchedule.workSchedule.util.JwtUtil;

@Service
public class UserService {

	@Autowired 
	UserRepository userRepo;
	
	@Autowired
	JwtUtil jwtUtil;
	
	public ResponseEntity<MyUser> getById(Long id){
		return new ResponseEntity<MyUser>(userRepo.getOne(id),HttpStatus.OK);
	}
	
	public String getEmailFromToken(String token) {
		String email = token.substring(7);
		try {
			email = jwtUtil.extractUsername(email);
			return email;
		}catch(Exception e) {
			return null;
		}
	}
}
