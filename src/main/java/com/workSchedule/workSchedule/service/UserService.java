package com.workSchedule.workSchedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.repository.UserRepository;

@Service
public class UserService {

	@Autowired UserRepository userRepo;
	
	public ResponseEntity<MyUser> getById(Long id){
		return new ResponseEntity<MyUser>(userRepo.getOne(id),HttpStatus.OK);
	}
}
