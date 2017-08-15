package com.deloitte.ucl.configuration.security.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class ResourcePrivilegeEntity.
 */
@Entity
@Table(name = "tu_resource_privs_xref")
/*@AssociationOverrides({ @AssociationOverride(name = "pk.resource", joinColumns = @JoinColumn(name = "resource_id")),
		@AssociationOverride(name = "pk.privilege", joinColumns = @JoinColumn(name = "privilege_id")) })*/
public class ResourcePrivilegeEntity extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The funcgrp id. */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FUNCGRP_ID", unique = true, nullable = false)
    private Long funcgrpId;
	 
	/** The roles. */
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="funcgrps")
	//@JoinTable(name = "roles_funcgrp", joinColumns = @JoinColumn(name = "funcgrp_id", referencedColumnName = "funcgrp_id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
	private List<RoleEntity> roles;
	
	/** The resource. */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="resource_id")
	ResourceEntity resource;
	
	/** The privilege. */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="privilege_id")
	PrivilegeEntity privilege;
	
	/**
	 * Instantiates a new resource privilege entity.
	 */
	public ResourcePrivilegeEntity() {
		super();
	}

	/**
	 * Gets the funcgrp id.
	 *
	 * @return the funcgrp id
	 */
	public Long getFuncgrpId() {
		return funcgrpId;
	}

	/**
	 * Sets the funcgrp id.
	 *
	 * @param funcgrpId the new funcgrp id
	 */
	public void setFuncgrpId(Long funcgrpId) {
		this.funcgrpId = funcgrpId;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public List<RoleEntity> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	/**
	 * Gets the resource.
	 *
	 * @return the resource
	 */
	public ResourceEntity getResource() {
		return resource;
	}

	/**
	 * Sets the resource.
	 *
	 * @param resource the new resource
	 */
	public void setResource(ResourceEntity resource) {
		this.resource = resource;
	}

	/**
	 * Gets the privilege.
	 *
	 * @return the privilege
	 */
	public PrivilegeEntity getPrivilege() {
		return privilege;
	}

	/**
	 * Sets the privilege.
	 *
	 * @param privilege the new privilege
	 */
	public void setPrivilege(PrivilegeEntity privilege) {
		this.privilege = privilege;
	}
}
