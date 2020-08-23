package com.workSchedule.workSchedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workSchedule.workSchedule.model.MyUserDetails;
import com.workSchedule.workSchedule.model.authentication.AuthenticationRequest;
import com.workSchedule.workSchedule.model.authentication.AuthenticationResponse;
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
	private JwtUtil jwtUtil;
	  
	@PostMapping("")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest auth_req) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(auth_req.getUsername(), auth_req.getPassword())
            );
        }catch (UsernameNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (BadCredentialsException e) {
            System.out.println("bad_credentials");
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        MyUserDetails myUD = (MyUserDetails) myUserDetailsService
                .loadUserByUsername(auth_req.getUsername());
        String jwt = jwtUtil.generateToken(myUD);
        return new ResponseEntity<>(
                new AuthenticationResponse(jwt,myUD.getUser()), HttpStatus.OK);
    }
	
}
