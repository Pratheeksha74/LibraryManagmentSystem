package com.cg.lms.entity;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "publishers")
public class Publishers {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int publisherId;
	
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String publisherName;
	
	@Size(min = 10, max = 10, message = "Contact number should be 10 characters long")
	private String contactno;
	
	@Email(message = "Email should be in a valid format")
	private String email;
	
	@NotEmpty(message = "Address should not be empty")
	private String address1;
	
	private String address2;
	
	@NotEmpty(message = "City should not be empty")
	private String city;
	
	@NotEmpty(message = "State should not be empty")
	private String state;
	
	private int pincode;
	
	public Publishers() {
		super();
	}
	
	public Publishers(int publisherId, String publisherName, String contactno, String email, String address1,
			String address2, String city, String state, int pincode) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.contactno = contactno;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public Publishers(String publisherName, String contactno, String email, String address1,
			String address2, String city, String state, int pincode) {
		super();
		this.publisherName = publisherName;
		this.contactno = contactno;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}
