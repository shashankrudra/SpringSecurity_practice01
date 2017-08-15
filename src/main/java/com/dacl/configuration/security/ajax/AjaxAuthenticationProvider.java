package com.dacl.configuration.security.ajax;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

//@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return false;
	}
	/*
	 * private final BCryptPasswordEncoder encoder; private final
	 * UCLUserDetailsService userService;
	 * 
	 * //@Autowired public AjaxAuthenticationProvider(final
	 * UCLUserDetailsService userService, final BCryptPasswordEncoder encoder) {
	 * this.userService = userService; this.encoder = encoder; }
	 * 
	 * @Override public Authentication authenticate(Authentication
	 * authentication) throws AuthenticationException { return authentication;
	 * /* Assert.notNull(authentication, "No authentication data provided");
	 * 
	 * UCLUser username = (UCLUser) authentication.getPrincipal(); String
	 * password = (String) authentication.getCredentials();
	 * 
	 * User user = userService.getByUsername(username).orElseThrow(() -> new
	 * UsernameNotFoundException("User not found: " + username));
	 * 
	 * if (!encoder.matches(password, user.getPassword())) { throw new
	 * BadCredentialsException("Authentication Failed. Username or Password not valid."
	 * ); }
	 * 
	 * if (user.getRoles() == null) throw new
	 * InsufficientAuthenticationException("User has no roles assigned");
	 * 
	 * List<GrantedAuthority> authorities = user.getRoles().stream()
	 * .map(authority -> new
	 * SimpleGrantedAuthority(authority.getRole().authority()))
	 * .collect(Collectors.toList());
	 * 
	 * UserContext userContext = UserContext.create(user.getUsername(),
	 * authorities);
	 * 
	 * return new UsernamePasswordAuthenticationToken(userContext, null,
	 * userContext.getAuthorities()); }
	 * 
	 * @Override public boolean supports(Class<?> authentication) { return
	 * (UsernamePasswordAuthenticationToken.class.isAssignableFrom(
	 * authentication)); }
	 */
}
