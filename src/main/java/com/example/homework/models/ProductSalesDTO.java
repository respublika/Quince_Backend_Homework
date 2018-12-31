package com.example.homework.models;

public class ProductSalesDTO implements Comparable<ProductSalesDTO> {
 private Long productId;
 private String productName;
 private Integer totalSalesUnit;
 private Integer totalSalesValue;
 
 public ProductSalesDTO() {}
	 
 public ProductSalesDTO(Long productId, String productName, Integer totalSalesUnit, Integer totalSalesValue) {
	this.productId = productId;
	this.productName = productName;
	this.totalSalesUnit = totalSalesUnit;
	this.totalSalesValue = totalSalesValue;
 }

public Long getProductId() {
	return productId;
 }
 
 public void setProductId(Long productId) {
	this.productId = productId;
 }
	
 public String getProductName() {
	return productName;
 }
	
 public void setProductName(String productName) {
	this.productName = productName;
 }
	
 public Integer getTotalSalesUnit() {
	return totalSalesUnit;
 }
	
 public void setTotalSalesUnit(Integer totalSalesUnit) {
	this.totalSalesUnit = totalSalesUnit;
 }
	
 public Integer getTotalSalesValue() {
	return totalSalesValue;
 }
	
 public void setTotalSalesValue(Integer totalSalesValue) {
	this.totalSalesValue = totalSalesValue;
 }
 
 @Override
 public int compareTo(ProductSalesDTO other) {
     if(this.getTotalSalesValue() > other.getTotalSalesValue())
         return 1;
     else if (this.getTotalSalesValue() == other.getTotalSalesValue())
         return 0 ;
     return -1 ;
 }

}
