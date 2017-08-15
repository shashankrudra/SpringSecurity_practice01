package com.deloitte.ucl.configuration.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deloitte.ucl.configuration.security.model.RoleEntity;
import com.deloitte.ucl.configuration.security.model.UCLUser;
import com.deloitte.ucl.configuration.security.model.UserAdminEntityManager;
import com.deloitte.ucl.configuration.security.model.UserEntity;


/**
 * UCLUserDetailsService loads user specific details if user is found in the database.
 * This includes roles,resources and privileges. If user is not found in the database
 * with the email entered an exception is thrown indicating that authentication of the 
 * user failed.
 */
@Service("uclUserDetailsService")
@Transactional
public class UCLUserDetailsService implements UserDetailsService {

	@SuppressWarnings("unused")
	private UserAdminEntityManager userAdminEntityManager;
	
	public UCLUserDetailsService() {
        super();
    }
	
	/**
	 * @param userAdminEntityManager the new user admin entity manager
	 */
	@Autowired
	public void setUserAdminEntityManager(UserAdminEntityManager userAdminEntityManager){
		this.userAdminEntityManager = userAdminEntityManager;
	}
	
	/**
	 * load user from the database with the provided email address. 
	 * Throw an exception if user not found.
	 *
	 * @param email the email
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
    	return returnStaticEntry();
     
    	/*
        try {
            final UserEntity user = userAdminEntityManager.getUser(email);
            if (user == null) {
                throw new UsernameNotFoundException("No user found with username: " + email);
            }
            
            /*
             * Custom User object to be used during custom implementation of Access Decision Manager.
             * The User object can carry information related to resources and privileges as well.
             */ 
            
            /*
             * Send in an empty password. As this is an SSO authentication and the username coming to 
               UCL is already authenticated. Password is not Required.
            */
           /* return new UCLUser(user.getEmail(), "", true, true, true, true,getGrantedAuth(user),user);

        } catch (final Exception e) {
            throw new UCLException("System currently unavailable.", e);
        }*/
    }
    
    private UserDetails returnStaticEntry(){
    	RoleEntity re = new RoleEntity();
    	re.setName("User");
    	re.setRoleDescription("User");
    	re.setRoleId(1L);
    	List<RoleEntity> roles = new ArrayList<>();
    	roles.add(re);
    	
    	UserEntity user = new UserEntity();
    	user.setEmail("");
    	user.setFirstName("user");
    	user.setRoles(roles);
    	
    	List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("user"));
    	UCLUser uu = new UCLUser("user", "password", authorities);
    	//uu.setRoles(user);
    	return uu;
    }

    /**
     * Set up the Granted Authorities in the User Object i.e. the roles.
     *
     * @param user the user
     * @return the granted auth
     */
	@SuppressWarnings("unused")
	private final List<GrantedAuthority> getGrantedAuth(UserEntity user) {

		List<RoleEntity> roles = user.getRoles();
		final List<GrantedAuthority> authorities = new ArrayList<>();

		for (RoleEntity role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return authorities;
	}	
}
