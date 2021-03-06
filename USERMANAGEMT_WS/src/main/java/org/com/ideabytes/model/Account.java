package org.com.ideabytes.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 * The Account class is an entity model object. An Account describes the security credentials and authentication flags
 * that permit access to application functionality.
 * 
 * @author Matt Warman
 */
@Entity(name = "account")
public class Account  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private boolean enabled = true;

    @NotNull
    private boolean credentialsexpired;

    @NotNull
    private boolean expired;

    @NotNull
    private boolean locked;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "account_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id"))
    private Set<Role> roles;

    public Account() {
        super();
    }

    /**
     * Create a new Account object with the supplied username and password values.
     * 
     * @param username A String username value.
     * @param password A String clear text password value.
     */
    public Account(final String username, final String password) {
        super();
        this.username = username;
        this.password = password;
    }

    /**
     * Create a new Account object with the supplied username, password, and Set of Role objects.
     * 
     * @param username A String username value.
     * @param password A String clear text password value.
     * @param roles A Set of Role objects.
     */
    public Account(final String username, final String password, final Set<Role> roles) {
        super();
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isCredentialsexpired() {
        return credentialsexpired;
    }

    public void setCredentialsexpired(final boolean credentialsexpired) {
        this.credentialsexpired = credentialsexpired;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(final boolean expired) {
        this.expired = expired;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(final boolean locked) {
        this.locked = locked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Set<Role> roles) {
        this.roles = roles;
    }

}
