package com.inventory.manage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="inventory")
public class Inventory {
	
	@Id
	private String id;
	private String name;
	private String quantity;
	
	public Inventory() {
		
	}
	
	public Inventory(String id, String name, String quantity) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}
