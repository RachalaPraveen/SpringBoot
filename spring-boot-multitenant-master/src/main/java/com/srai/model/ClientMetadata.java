package com.srai.model;

import javax.persistence.Column;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Account class is an entity model object. An Account describes the security credentials and authentication flags
 * that permit access to application functionality.
 * 
 * @author Matt Warman
 */

@Entity
@Table(name = "client_metadata")
public class ClientMetadata {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@Column(name = "schma_name")
	public String schemaName;
	@Column(name = "user_name")
	public double username;
	@Column(name = "password")
	public double password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchemaName() {
		return schemaName;
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	public double getUsername() {
		return username;
	}
	public void setUsername(double username) {
		this.username = username;
	}
	public double getPassword() {
		return password;
	}
	public void setPassword(double password) {
		this.password = password;
	}
	

}
