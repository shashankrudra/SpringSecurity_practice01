package com.dacl.configuration.security.model;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * 
 */
public class UCLUser extends User {

	private static final long serialVersionUID = 1L;

	public UCLUser(String userName, String password, List<GrantedAuthority> authorities) {
		super(userName, password, authorities);
	}

}
