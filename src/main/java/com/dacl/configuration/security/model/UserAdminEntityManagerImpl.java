package com.deloitte.ucl.configuration.security.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


/**
 * 
 * UserAdminEntityManager contains CRUD operations to be performed on a User.
 * @author sarsharma
 *
 */
@Repository("userAdminEntityManager")
@SuppressWarnings("rawtypes")
public class UserAdminEntityManagerImpl implements UserAdminEntityManager {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(UserAdminEntityManagerImpl.class);
	/**
	 * Get user by email. The method should only be called from Spring Security 
	 * implementation of UserDetailsService.
	 *
	 * @param email the email
	 * @return the user
	 */
	@Override
	public UserEntity getUser(String email){
		
		String hql = "select user FROM UserEntity user WHERE lower(user.email) = ?";
		//Query query = getCurrentSession().createQuery(hql).setParameter(0, email.toLowerCase());
		//List results = query.list();
		//return  (results!=null && !results.isEmpty())?(UserEntity)results.get(0):null;
		return new UserEntity();
	}

	/* (non-Javadoc)
	 * @see usdc.domain.client.app.persistence.UserAdminEntityManager#getRoleByName(java.lang.String)
	 */
	@Override
	public RoleEntity getRoleByName(String role) {
		String hql = "from RoleEntity role where role.name = :rolename";
		// Query query= this.getCurrentSession().createQuery(hql);
		// query.setParameter("rolename", role);
		//List results = query.list();
		 //return (RoleEntity)((results!=null && !results.isEmpty())?results.get(0):results);
		return new RoleEntity();
	}
	
	/* (non-Javadoc)
	 * @see usdc.domain.client.app.persistence.UserAdminEntityManager#getRoles
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<RoleEntity> getRoles() {
		String hql = "FROM RoleEntity role";
		/*Query query = this.getCurrentSession().createQuery(hql);
		List<RoleEntity> results = query.list();*/
		Set<RoleEntity> roles = new TreeSet<RoleEntity>();
		/*for(RoleEntity result : results) {
			roles.add(result);
		}*/
		return roles;
	}

	/* (non-Javadoc)
	 * @see usdc.domain.client.app.persistence.BaseEntityManagerImpl#saveEntity(usdc.domain.client.app.persistence.model.UCLEntity)
	 */
	@Override
	public void saveEntity(UCLEntity entity){
		//getCurrentSession().save(entity);
	}
	
	/* (non-Javadoc)
	 * @see usdc.domain.client.app.persistence.UserAdminEntityManager#mergeEntity(usdc.domain.client.app.persistence.model.UCLEntity)
	 */
	@Override
	public void mergeEntity(UCLEntity entity){
		//getCurrentSession().saveOrUpdate(entity);
	}
	
	/* (non-Javadoc)
	 * @see usdc.domain.client.app.persistence.UserAdminEntityManager#getUsers()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUsers() {
		List<UserEntity> list = new ArrayList<>();
		String hql = "FROM UserEntity user";
		//Query query = getCurrentSession().createQuery(hql);
		//return query.list();
		return list;
	}

	@Override
	public UserEntity getUser(long id) {
		logger.debug(" - Entering getUser By Id - ");
		String hql = "FROM UserEntity userEntity where userEntity.userId = :id";
		//Query query = getCurrentSession().createQuery(hql);
		//query.setParameter("id", id);
		/*List results = query.list();
		logger.debug(" - Exiting readById - ");
		return (UserEntity) ((results != null && !results.isEmpty()) ? results.get(0) : null);*/
		return new UserEntity();
	}

	@Override
	public UserEntity update(UserEntity user) {
		logger.debug(" - Entering update - ");
		//getCurrentSession().update(user);
		logger.debug(" - Exiting  update - ");
		return user;
	}
}
