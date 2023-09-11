package com.user.model;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;

public class AuthRequest {
	
	@NotNull @Length(min = 5, max = 50)
    private String username;
     
    @NotNull @Length(min = 5, max = 10)
    private String password;

	public AuthRequest() {
		
	}

	public AuthRequest(@NotNull @Length(min = 5, max = 50) String username,
			@NotNull @Length(min = 5, max = 10) String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
    
    
    
	 

}
