package com.dacl.configuration.security.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The Class PrivilegeEntity.
 */
@Entity
@Table(name = "tu_privilege")
public class PrivilegeEntity extends BaseEntity {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The privilege id. */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRIVILEGE_ID", unique = true, nullable = false)
    private Long privilegeId;

    /** The name. */
    @Column(name = "PRIVILEGE_NAME", nullable = false)
    private String name;
    
    /** The resources. */
    @OneToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy="privilege")
	//@JoinTable(name = "resources_privileges", joinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "privilege_id"), inverseJoinColumns = @JoinColumn(name = "resource_id", referencedColumnName = "resource_id"))
    private List<ResourcePrivilegeEntity> resources;

    /**
     * Instantiates a new privilege entity.
     */
    public PrivilegeEntity() {
        super();
    }

    /**
     * Instantiates a new privilege entity.
     *
     * @param name the name
     */
    public PrivilegeEntity(final String name) {
        super();
        this.name = name;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return privilegeId;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(final Long id) {
        this.privilegeId = id;
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
	 * Gets the privilege id.
	 *
	 * @return the privilege id
	 */
	public Long getPrivilegeId() {
		return privilegeId;
	}

	/**
	 * Sets the privilege id.
	 *
	 * @param privilegeId the new privilege id
	 */
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}

	/**
	 * Gets the resources.
	 *
	 * @return the resources
	 */
	public List<ResourcePrivilegeEntity> getResources() {
		return resources;
	}

	/**
	 * Sets the resources.
	 *
	 * @param resources the new resources
	 */
	public void setResources(List<ResourcePrivilegeEntity> resources) {
		this.resources = resources;
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
        final PrivilegeEntity privilege = (PrivilegeEntity) obj;
        if (!this.name.equals(privilege.name)) {
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
        builder.append("Privilege [name=").append(name).append("]").append("[id=").append(privilegeId).append("]");
        return builder.toString();
    }

	
}

