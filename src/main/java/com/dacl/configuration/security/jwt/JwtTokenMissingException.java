package com.dacl.configuration.security.jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMissingException extends  AuthenticationException  {
	
	private static final long serialVersionUID = 1L;

	public JwtTokenMissingException(String message){
		super(message);
	}

}
