package com.deloitte.ucl.configuration.security.ajax;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.deloitte.ucl.configuration.security.custom.AuthMethodNotSupportedException;
import com.deloitte.ucl.configuration.security.jwt.JwtExpiredTokenException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class AjaxAwareAuthenticationFailureHandler implements AuthenticationFailureHandler {
    
	private ObjectMapper objectMapper;
    
    @Autowired
    public AjaxAwareAuthenticationFailureHandler(ObjectMapper mapper) {
        this.objectMapper = mapper;
    }
    
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException e) throws IOException, ServletException {
		
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		if (e instanceof BadCredentialsException) {
			objectMapper.writeValue(response.getWriter(), ErrorResponse.of(e.getMessage(), ErrorCode.AUTHENTICATION, HttpStatus.UNAUTHORIZED));
		} else if (e instanceof JwtExpiredTokenException) {
			objectMapper.writeValue(response.getWriter(), ErrorResponse.of(e.getMessage(), ErrorCode.JWT_TOKEN_EXPIRED, HttpStatus.UNAUTHORIZED));
		} else if (e instanceof AuthMethodNotSupportedException) {
		    objectMapper.writeValue(response.getWriter(), ErrorResponse.of(e.getMessage(), ErrorCode.AUTHENTICATION, HttpStatus.UNAUTHORIZED));
		} else {
			objectMapper.writeValue(response.getWriter(), ErrorResponse.of("Authentication failed", ErrorCode.AUTHENTICATION, HttpStatus.UNAUTHORIZED));
		}
	}
}
