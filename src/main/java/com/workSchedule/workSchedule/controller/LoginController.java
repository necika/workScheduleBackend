package com.workSchedule.workSchedule.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.model.MyUserDetails;
import com.workSchedule.workSchedule.model.authentication.AuthenticationRequest;
import com.workSchedule.workSchedule.model.authentication.AuthenticationResponse;
import com.workSchedule.workSchedule.repository.UserRepository;
import com.workSchedule.workSchedule.service.MyUserDetailsService;
import com.workSchedule.workSchedule.util.JwtUtil;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtil jwtUtil;
	  
	@PostMapping("")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest auth_req) {
		MyUser user = userRepo.findByEmail(auth_req.getUsername());
		if(user == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		if(!passwordEncoder.matches(auth_req.getPassword(), user.getPassword())) {
			return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
		}
		MyUserDetails myUD = (MyUserDetails) myUserDetailsService
                .loadUserByUsername(auth_req.getUsername());
        String jwt = jwtUtil.generateToken(myUD);
        return new ResponseEntity<>(
                new AuthenticationResponse(jwt,myUD.getUser()), HttpStatus.OK);
    }
	
}
