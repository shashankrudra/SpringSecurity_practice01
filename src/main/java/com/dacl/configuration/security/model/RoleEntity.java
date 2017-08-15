package com.dacl.configuration.security.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class RoleEntity.
 */
@Entity
@Table(name = "tu_role")
public class RoleEntity extends BaseEntity implements Comparable<RoleEntity> {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The role id. */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID", nullable = false)
    private Long roleId;

    /** The name. */
    @Column(name = "ROLE_NAME", nullable = false)
    private String name;
    
    @Column(name = "ROLE_DESCRIPTION", nullable = false)
    private String roleDescription;
    
	/** The users. */
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tu_users_roles_xref", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    private List<UserEntity> users;

    /** The funcgrps. */
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name = "tu_roles_funcgrp_xref", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"), inverseJoinColumns = @JoinColumn(name = "funcgrp_id", referencedColumnName = "funcgrp_id"))
    private List<ResourcePrivilegeEntity> funcgrps;


    /**
     * Instantiates a new role entity.
     */
    public RoleEntity() {
        super();
    }

    /**
     * Instantiates a new role entity.
     *
     * @param name the name
     */
    public RoleEntity(final String name) {
        super();
        this.name = name;
    }

    /**
     * Gets the role id.
     *
     * @return the role id
     */
    public Long getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

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
    public void setName(final String name) {
        this.name = name;
    }

    /**
	 * @return the roleDescription
	 */
	public String getRoleDescription() {
		return roleDescription;
	}

	/**
	 * @param roleDescription the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

    /**
     * Gets the funcgrps.
     *
     * @return the funcgrps
     */
    public List<ResourcePrivilegeEntity> getFuncgrps() {
		return funcgrps;
	}

	/**
	 * Sets the funcgrps.
	 *
	 * @param funcgrps the new funcgrps
	 */
	public void setFuncgrps(List<ResourcePrivilegeEntity> funcgrps) {
		this.funcgrps = funcgrps;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoleEntity role = (RoleEntity) obj;
        if (!this.name.equals(role.name)) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Role [name=").append(name).append("]").append("[id=").append(roleId).append("]");
        return builder.toString();
    }
    
    @Override
    public int compareTo(RoleEntity role) {
    	return this.name.compareTo(role.getName());
    }
}