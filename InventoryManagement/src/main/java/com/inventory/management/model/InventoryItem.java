package com.inventory.management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="inventoryItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItem {
	
	@Id
	private String id;
	private String name;
	private String quantity;
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
	
	public InventoryItem() {
		
	}
	
	public InventoryItem(String id, String name, String quantity) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}
	
}