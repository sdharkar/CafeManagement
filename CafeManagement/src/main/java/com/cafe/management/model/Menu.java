package com.cafe.management.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="menu")
public class Menu {
	
	@Id
    private String menuName;
    private String image;
    private String menuCategory;
    private int menuQuantity;
    private int productPrice;
    private String username;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(String menuName, String image, String menuCategory, int menuQuantity, int productPrice,
			String username) {
		super();
		this.menuName = menuName;
		this.image = image;
		this.menuCategory = menuCategory;
		this.menuQuantity = menuQuantity;
		this.productPrice = productPrice;
		this.username = username;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMenuCategory() {
		return menuCategory;
	}
	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}
	public int getMenuQuantity() {
		return menuQuantity;
	}
	public void setMenuQuantity(int menuQuantity) {
		this.menuQuantity = menuQuantity;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public int hashCode() {
		return Objects.hash(image, menuCategory, menuName, menuQuantity, productPrice, username);
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
		return Objects.equals(image, other.image) && Objects.equals(menuCategory, other.menuCategory)
				&& Objects.equals(menuName, other.menuName) && menuQuantity == other.menuQuantity
				&& productPrice == other.productPrice && Objects.equals(username, other.username);
	}
	
	
    
    

}
