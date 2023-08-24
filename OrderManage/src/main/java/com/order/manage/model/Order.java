package com.order.manage.model;

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
	private Set<User> userName;

	@DBRef
	private List<String> Menu;

	private double totalAmount;
	private String status;

	public Order() {
		super();
	}

	public Order(String id, Set<User> userName, List<String> menu, double totalAmount, String status) {
		super();
		this.id = id;
		this.userName = userName;
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

	public Set<User> getUserName() {
		return userName;
	}

	public void setUserName(Set<User> userName) {
		this.userName = userName;
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", userName=" + userName + ", Menu=" + Menu + ", totalAmount=" + totalAmount
				+ ", status=" + status + ", getId()=" + getId() + ", getUserName()=" + getUserName() + ", getMenu()="
				+ getMenu() + ", getTotalAmount()=" + getTotalAmount() + ", getStatus()=" + getStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
