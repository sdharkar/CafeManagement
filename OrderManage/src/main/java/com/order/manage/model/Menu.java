package com.order.manage.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="menu")
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
	
	@Override
	public String toString() {
		return "Menu [itemId=" + itemId + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", available=" + available + ", getItemId()=" + getItemId()
				+ ", getName()=" + getName() + ", getDescription()=" + getDescription() + ", getPrice()=" + getPrice()
				+ ", getCategory()=" + getCategory() + ", getAvailable()=" + getAvailable() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(available, category, description, itemId, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		return Objects.equals(available, other.available) && Objects.equals(category, other.category)
				&& Objects.equals(description, other.description) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	

}
