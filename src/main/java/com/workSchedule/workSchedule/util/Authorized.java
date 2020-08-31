package com.workSchedule.workSchedule.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import com.workSchedule.workSchedule.enums.UserType;
import com.workSchedule.workSchedule.model.MyUserDetails;

public class Authorized {
	
	public static boolean isAuthorised(UserType role){
        String user_role = SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities().toArray()[0].toString();
        if (user_role.equals(role.toString()))
            return true;
        return false;
    }

    //Check the email(username) of logged user
    public static boolean isAuthorised(String email){
        if(!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
            return false;
        }
        if(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken){
            return false;
        }
        UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        
        if(((MyUserDetails)upat.getPrincipal()).getUser().getEmail().equals(email))
            return true;
        return false;
    }
	
}
