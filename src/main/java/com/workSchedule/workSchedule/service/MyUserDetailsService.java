package com.workSchedule.workSchedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.model.MyUserDetails;
import com.workSchedule.workSchedule.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
    UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser user = userRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("User with the email " + username + " dose not exist");
        }
        return new MyUserDetails(user);
	}

}
