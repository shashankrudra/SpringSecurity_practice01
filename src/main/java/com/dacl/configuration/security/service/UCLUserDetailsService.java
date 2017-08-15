package com.dacl.configuration.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dacl.configuration.security.model.UCLUser;

/**
 * UCLUserDetailsService loads user specific details if user is found in the
 * database. This includes roles,resources and privileges. If user is not found
 * in the database with the email entered an exception is thrown indicating that
 * authentication of the user failed.
 */
@Service("uclUserDetailsService")
@Transactional
public class UCLUserDetailsService implements UserDetailsService {

	public UCLUserDetailsService() {
		super();
	}

	/**
	 * load user from the database with the provided email address. Throw an
	 * exception if user not found.
	 *
	 * @param email
	 *            the email
	 * @return the user details
	 * @throws UsernameNotFoundException
	 *             the username not found exception
	 */
	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("user"));
		return new UCLUser("dummy", "dummy", authorities);
	}

}
