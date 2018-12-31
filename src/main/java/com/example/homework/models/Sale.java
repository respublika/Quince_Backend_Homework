package com.example.homework.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Sale {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long saleId;
 private Integer salesUnit = 1;
 private Integer salesValue;
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name = "productId")
 private Product product;
 
 public Sale() {}
 
 public Sale(Integer salesValue, Product product) {
	this.salesValue = salesValue;
	this.product = product;
 }
 
 public Long getSaleId() {
	return saleId;
 }
 
 public void setSaleId(Long saleId) {
	this.saleId = saleId;
 }
 
 public Integer getSalesUnit() {
	return salesUnit;
 }
 
 public void setSalesUnit(Integer salesUnit) {
	this.salesUnit = salesUnit;
 }
 
 public Integer getSalesValue() {
	return salesValue;
 }
 
 public void setSalesValue(Integer salesValue) {
	this.salesValue = salesValue;
 }
 
 public Product getProduct() {
	return product;
 }
 
 public void setProduct(Product product) {
	this.product = product;
 }
}



