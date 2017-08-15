package com.deloitte.ucl.configuration.security.custom;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomUsernamePasswordAuthenticationFilter extends
UsernamePasswordAuthenticationFilter {

	final static Logger logger = LoggerFactory.getLogger(CustomUsernamePasswordAuthenticationFilter.class);
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain, Authentication authResult)
					throws IOException, ServletException {
		
		super.successfulAuthentication(request, response, chain, authResult);
		logger.info("==successful login==");
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException failed)
					throws IOException, ServletException {
		
		super.unsuccessfulAuthentication(request, response, failed);
		logger.info("==failed login==");
	}

}