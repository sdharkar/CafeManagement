package com.cafe.management.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="order" )
public class Order {
	
		@Id
	    private long orderId;
	    private Customer customer;
	    private List<Menu> product;
	    private LocalDate orderDate;
	    private long totalPrice;
	    private String orderStatus;
	    private String username;
	    
		public Order() {
			
		}

		public Order(long orderId, Customer customer, List<Menu> product, LocalDate orderDate, long totalPrice,
				String orderStatus, String username) {
			super();
			this.orderId = orderId;
			this.customer = customer;
			this.product = product;
			this.orderDate = orderDate;
			this.totalPrice = totalPrice;
			this.orderStatus = orderStatus;
			this.username = username;
		}

		public long getOrderId() {
			return orderId;
		}

		public void setOrderId(long orderId) {
			this.orderId = orderId;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public List<Menu> getProduct() {
			return product;
		}

		public void setProduct(List<Menu> product) {
			this.product = product;
		}

		public LocalDate getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}

		public long getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(long totalPrice) {
			this.totalPrice = totalPrice;
		}

		public String getOrderStatus() {
			return orderStatus;
		}

		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		@Override
		public int hashCode() {
			return Objects.hash(customer, orderDate, orderId, orderStatus, product, totalPrice, username);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Order other = (Order) obj;
			return Objects.equals(customer, other.customer) && Objects.equals(orderDate, other.orderDate)
					&& orderId == other.orderId && Objects.equals(orderStatus, other.orderStatus)
					&& Objects.equals(product, other.product) && totalPrice == other.totalPrice
					&& Objects.equals(username, other.username);
		}
		
		
	    
	    

}
