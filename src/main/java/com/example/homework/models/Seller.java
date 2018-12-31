package com.example.homework.models;

import javax.persistence.*;

@Entity
public class Seller {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long sellerId;
 private String firstName;
 private String lastName;
 private String email;
 private Double rate = 0.0;

 public Seller() {

	}
 
 public Seller(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
 
 public Seller(String firstName, String lastName, String email, Double rate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.rate = rate;
	}
	 
 public Long getSellerId() {
		return sellerId;
	}
 
 public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
 
 public String getFirstName() {
		return firstName;
	}
 
 public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
 public String getLastName() {
		return lastName;
	}
 
 public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
 public String getEmail() {
		return email;
	}
 
 public void setEmail(String email) {
		this.email = email;
	}
 
 public Double getRate() {
		return rate;
	}
 
 public void setRate(Double rate) {
		this.rate = rate;
	}
 }
