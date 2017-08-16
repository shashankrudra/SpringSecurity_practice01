package com.dacl.configuration.security.model;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * 
 */
public class CUser extends User {

	private static final long serialVersionUID = 1L;

	public CUser(String userName, String password, List<GrantedAuthority> authorities) {
		super(userName, password, authorities);
	}

}
