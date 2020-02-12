package com.pravnainformatikasemantickiweb.questionanswerlegaldoc.security.dto;

import java.util.ArrayList;

import lombok.ToString;

@ToString
public class UserDTO {

	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private ArrayList<String> roles = new ArrayList<String>();
	private boolean enabled;
	private boolean deleted;
	
	
	public UserDTO() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public ArrayList<String> getRoles() {
		return roles;
	}


	public void setRoles(ArrayList<String> roles) {
		this.roles = roles;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



	
	
}
