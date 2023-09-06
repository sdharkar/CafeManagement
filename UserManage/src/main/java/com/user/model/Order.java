package com.user.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "orders")
public class Order {
	
	@Id
	private String id;

	@DBRef
	private Set<User> username;

	@DBRef
	private List<String> Menu;

	private double totalAmount;
	private String status;
	
	public Order() {
		
	}

	public Order(String id, Set<User> username, List<String> menu, double totalAmount, String status) {
		super();
		this.id = id;
		this.username = username;
		Menu = menu;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<User> getUsername() {
		return username;
	}

	public void setUsername(Set<User> username) {
		this.username = username;
	}

	public List<String> getMenu() {
		return Menu;
	}

	public void setMenu(List<String> menu) {
		Menu = menu;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
