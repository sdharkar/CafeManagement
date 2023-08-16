package com.order.manage.model;

import org.springframework.data.annotation.Id;

public class User {
	
	@Id
	private String userName;

	public User() {
		super();
	}

	public User(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
