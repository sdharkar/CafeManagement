package com.order.manage.model;

import org.springframework.data.annotation.Id;

public class Menu {
	
	@Id
	private String itemId;
	private String name;
	private String description;
	private double price;
	private String category;
	private Boolean available;
	
	public Menu() {
		
	}

	public Menu(String itemId, String name, String description, double price, String category, Boolean available) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.available = available;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}
