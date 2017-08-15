package com.dacl.configuration.security.model;

import java.util.List;
import java.util.Set;

/**
 * The Interface UserAdminEntityManager.
 */
public interface UserAdminEntityManager{
	
	/**
	 * Gets the role by name.
	 *
	 * @param role the role
	 * @return the role by name
	 */
	public RoleEntity getRoleByName(String role);
	
	/**
	 * Save entity.
	 *
	 * @param entity the entity
	 */
	public void saveEntity(UCLEntity entity);
	
	/**
	 * Merge entity.
	 *
	 * @param entity the entity
	 */
	public void mergeEntity(UCLEntity entity);
	
	/**
	 * Gets the user.
	 *
	 * @param email the email
	 * @return the user
	 */
	public UserEntity getUser(String email);
	
	/**
	 * Gets the user.
	 *
	 * @param id
	 * @return the user
	 */
	public UserEntity getUser(long id);
	
	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public List<UserEntity> getUsers();
	
	/**
	 * Get all the roles.
	 * @return
	 */
	public Set<RoleEntity> getRoles();
	
	/**
	 * Update.
	 *
	 * @param contact the contact
	 * @return contact
	 */
	public UserEntity update(UserEntity user);

}
