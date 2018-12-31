package com.example.homework.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Rate {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long rateId;
 private Integer ratePoint;
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name = "sellerId")
 private Seller seller;
 
 public Rate() {
	 
 }
 
 public Rate(Integer ratePoint, Seller seller) {
	this.ratePoint = ratePoint;
	this.seller = seller;
 }
 
 public Long getRateId() {
	return rateId;
 }
 
 public void setRateId(Long rateId) {
	this.rateId = rateId;
 }
 
 public Integer getRatePoint() {
	return ratePoint;
 }
 
 public void setRatePoint(Integer ratePoint) {
	this.ratePoint = ratePoint;
 }
 
 public Seller getSeller() {
	return seller;
 }
 
 public void setSeller(Seller seller) {
	this.seller = seller;
 }

}
