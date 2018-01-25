package org.com.ideabytes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "user_details")
public class UserDetails {

    /**
     * The primary key identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Here we will store User First name.
     */
    @NotNull
    private String firstName;

    /**
     * Here we will store User last Name.
     */
    @NotNull
    private String lastName;

    /**
     * Here we will store User email.
     */
    @NotNull
    private String email;

    /**
     * Here we will store User phone.
     */
    @NotNull
    private String phone;

    /**
     *Here we will store User username.
     */
    @NotNull
    private String userName;
    
    /**
     * Here we will store User password.
     */
    @NotNull
    private String password;
    
    /**
     * THere we will store User country.
     */
    @NotNull
    private String country;
    
    
    /**
     * THere we will store User userType, if user type is 1:Admin,2:manager;3:User.
     */
    @NotNull
    private Integer userType;
    

    /**
     * THere we will store User dgCertificate Date.
     */
    @NotNull
    private Date dgCertificate;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUsername() {
		return userName;
	}


	public void setUsername(String username) {
		this.userName = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Integer getUserType() {
		return userType;
	}


	public void setUserType(Integer userType) {
		this.userType = userType;
	}


	public Date getDgCertificate() {
		return dgCertificate;
	}


	public void setDgCertificate(Date dgCertificate) {
		this.dgCertificate = dgCertificate;
	}


    
}
