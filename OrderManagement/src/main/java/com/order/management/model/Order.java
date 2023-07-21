package com.order.management.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
	private String id;
	private String userId;
	private List<String> itemIds;
	private double totalAmount;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getItemIds() {
		return itemIds;
	}
	public void setItemIds(List<String> itemIds) {
		this.itemIds = itemIds;
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

	public Order() {

	}
	public Order(String id, String userId, List<String> itemIds, double totalAmount, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.itemIds = itemIds;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	
	
	
	

}
