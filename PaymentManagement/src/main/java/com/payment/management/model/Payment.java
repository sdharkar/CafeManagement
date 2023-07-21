package com.payment.management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	 @Id
	 private String id;
	 private String orderId;
	 private double amount;
	 private String status;
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Payment() {
		
	}
	
	public Payment(String id, String orderId, double amount, String status) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.amount = amount;
		this.status = status;
	}
	
	
	
	 
	 
	 

}