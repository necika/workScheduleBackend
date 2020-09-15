package com.workSchedule.workSchedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.workSchedule.workSchedule.dtos.ChangingUserDataDTO;
import com.workSchedule.workSchedule.dtos.UserDTO;
import com.workSchedule.workSchedule.enums.JobTitle;
import com.workSchedule.workSchedule.enums.UserType;
import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.model.Project;
import com.workSchedule.workSchedule.repository.ProjectRepository;
import com.workSchedule.workSchedule.repository.UserRepository;
import com.workSchedule.workSchedule.util.JwtUtil;

@Service
public class UserService {

	@Autowired 
	UserRepository userRepo;
	
	@Autowired 
	ProjectRepository projectRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtil jwtUtil;
	
	public ResponseEntity<MyUser> getById(Long id){
		return new ResponseEntity<MyUser>(userRepo.getOneById(id),HttpStatus.OK);
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

	public ResponseEntity<Long> getId(String email) {
		MyUser user = userRepo.findByEmail(email);
		if(user == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Long>(user.getId(),HttpStatus.OK);
	}

	public ResponseEntity<MyUser> getLoggenUser(String email) {
		MyUser user = userRepo.findByEmail(email);
		if(user == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<MyUser>(user,HttpStatus.OK);
	}

	public ResponseEntity<List<MyUser>> getAll(String email) {
		MyUser user = userRepo.findByEmail(email);
		if(user == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		List<MyUser> users = userRepo.getAllByCompany(user.getCompany().getId());
		return new ResponseEntity<List<MyUser>>(users,HttpStatus.OK);
	}

	public ResponseEntity<List<MyUser>> getAllTeamLeaders(String email) {
		MyUser user = userRepo.findByEmail(email);
		if(user == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		List<MyUser> users = userRepo.getAllByCompanyAndTeamLeaders(user.getCompany().getId());
		return new ResponseEntity<List<MyUser>>(users,HttpStatus.OK);
	}

	public ResponseEntity<List<MyUser>> getAllByProject(String email) {
		MyUser user = userRepo.findByEmail(email);
		if(user == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		List<MyUser> users = userRepo.getAllByProject(user.getCompany().getId(),user.getProject().getId());
		return new ResponseEntity<List<MyUser>>(users,HttpStatus.OK);
	}

	public ResponseEntity<MyUser> changeUserData(ChangingUserDataDTO userDTO) {
		MyUser user = userRepo.getOneById(userDTO.getId());
		if(user == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		if(userDTO.getProjectId() != 0) {
			Project project = projectRepo.getOneById(userDTO.getProjectId());
			if(project == null) {
				return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			}
			user.setProject(project);
		}
		if(!userDTO.getTitle().equals("")) {
			user.setJobTitle(JobTitle.valueOf(userDTO.getTitle()));
		}
		user = userRepo.save(user);
		return new ResponseEntity(user,HttpStatus.OK);
	}

	public ResponseEntity<MyUser> addUser(UserDTO userDTO,String email) {
		MyUser admin = userRepo.findByEmail(email);
		if(admin == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		
		Project project = projectRepo.getOneById(userDTO.getProjectId());
		if(project == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		
		MyUser user = new MyUser(userDTO.getEmail(),encoder.encode(userDTO.getPassword()),userDTO.getFirstName(),userDTO.getLastName(),
				UserType.EMPLOYER,JobTitle.valueOf(userDTO.getJobTitle()),userDTO.getAge(),admin.getCompany(),project);
		user = userRepo.save(user);
		return new ResponseEntity(user,HttpStatus.OK);
	}
}
