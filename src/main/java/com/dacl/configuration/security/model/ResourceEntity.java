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
 * The Class ResourceEntity.
 */
@Entity
@Table(name = "tu_resource")
public class ResourceEntity extends BaseEntity{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The resource id. */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESOURCE_ID", unique = true, nullable = false)
    private Long resourceId;

	/** The name. */
	@Column(name = "RESOURCE_NAME", nullable = false)
	private String name;

    /** The privileges. */
    @OneToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy="resource")
	//@JoinTable(name = "resources_privileges", joinColumns = @JoinColumn(name = "resource_id", referencedColumnName = "resource_id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "privilege_id"))
    private List<ResourcePrivilegeEntity> privileges;
    
    /**
     * Instantiates a new resource entity.
     */
    public ResourceEntity() {
        super();
    }

    /**
     * Instantiates a new resource entity.
     *
     * @param name the name
     */
    public ResourceEntity(final String name) {
        super();
        this.name = name;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return resourceId;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(final Long id) {
        this.resourceId = id;
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
	 * Gets the resource id.
	 *
	 * @return the resource id
	 */
	public Long getResourceId() {
		return resourceId;
	}

	/**
	 * Sets the resource id.
	 *
	 * @param resId the new resource id
	 */
	public void setResourceId(Long resId) {
		this.resourceId = resId;
	}


	/**
	 * Gets the privileges.
	 *
	 * @return the privileges
	 */
	public List<ResourcePrivilegeEntity> getPrivileges() {
		return privileges;
	}

	/**
	 * Sets the privileges.
	 *
	 * @param privileges the new privileges
	 */
	public void setPrivileges(List<ResourcePrivilegeEntity> privileges) {
		this.privileges = privileges;
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
        final ResourceEntity resource = (ResourceEntity) obj;
        if (!this.name.equals(resource.name)) {
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
        builder.append("Resource [name=").append(name).append("]").append("[id=").append(resourceId).append("]");
        return builder.toString();
    }

}
