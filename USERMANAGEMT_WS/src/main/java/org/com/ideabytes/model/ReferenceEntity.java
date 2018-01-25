package org.com.ideabytes.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;


/**
 * The parent class for all reference entities (i.e. reference data as opposed to transactional data).
 * 
 * @see com.leanstacks.ws.model.TransactionalEntity
 * 
 * @author Matt Warman
 */
@MappedSuperclass
public class ReferenceEntity implements Serializable {

    /**
     * The default serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The primary key identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The unique code value, sometimes used for external reference.
     */
    @NotNull
    private String code;

    /**
     * A brief description of the entity.
     */
    @NotNull
    private String label;

    /**
     * The ordinal value facilitates sorting the entities.
     */
    @NotNull
    private Integer ordinal;

    /**
     * The timestamp at which the entity's values may be applied or used by the system.
     */
    @NotNull
    private Date effectiveAt;

    /**
     * The timestamp at which the entity's values cease to be used by the system. If <code>null</code> the entity is not
     * expired.
     */
    private Date expiresAt;

    /**
     * The timestamp when this entity instance was created.
     */
    @NotNull
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(final Integer ordinal) {
        this.ordinal = ordinal;
    }

    public Date getEffectiveAt() {
        return effectiveAt;
    }

    public void setEffectiveAt(final Date effectiveAt) {
        this.effectiveAt = effectiveAt;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(final Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

}
