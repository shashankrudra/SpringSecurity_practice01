package com.dacl.configuration.security.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dacl.configuration.security.jwt.UserContext;


public class SecurityContextUtil {
	
	public static UserContext getPrincipal(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserContext user = null;
		if(auth.isAuthenticated())
			user =(UserContext)auth.getPrincipal();
		return user;
	}
}
	