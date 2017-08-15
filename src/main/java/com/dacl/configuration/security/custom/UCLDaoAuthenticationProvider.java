package com.deloitte.ucl.configuration.security.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UCLDaoAuthenticationProvider extends DaoAuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(UCLDaoAuthenticationProvider.class);
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication){
		//do nothing 
		logger.info("additionalAuthenticationChecks called for DAO based authentication provider");
	}
	
	@Override
	protected void doAfterPropertiesSet() throws Exception {
		//Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
	}
}
