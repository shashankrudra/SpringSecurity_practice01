package com.deloitte.ucl.configuration.security.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * The Class Role.
 */
public class Role implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2598920912004376626L;
	
	/** The name. */
	private String name;
	
	/** The username. */
	private String username;
	
	/** The resources. */
	private Map<String,List<String>> resources;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the resources.
	 *
	 * @return the resources
	 */
	public Map<String,List<String>> getResources() {
		return resources;
	}

	/**
	 * Sets the resources.
	 *
	 * @param resources the resources
	 */
	public void setResources(Map<String,List<String>> resources) {
		this.resources = resources;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
