package com.cafe.management.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customer" )
public class Customer {
	
	 @Transient
	 public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
    private long id;
    private String image;
    private String name;
    private long mobile;
    private String emailId;
    private String address;
    private boolean verified;
    private String username;
    
	public Customer() {
		
	}
	public Customer(long id, String image, String name, long mobile, String emailId, String address, boolean verified,
			String username) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.mobile = mobile;
		this.emailId = emailId;
		this.address = address;
		this.verified = verified;
		this.username = username;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, emailId, id, image, mobile, name, username, verified);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(emailId, other.emailId) && id == other.id
				&& Objects.equals(image, other.image) && mobile == other.mobile && Objects.equals(name, other.name)
				&& Objects.equals(username, other.username) && verified == other.verified;
	}
    
    


}
