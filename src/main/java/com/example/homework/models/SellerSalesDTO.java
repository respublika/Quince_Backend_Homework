package com.example.homework.models;

public class SellerSalesDTO implements Comparable<SellerSalesDTO> {
 private Long sellerId;
 private String firstName;
 private String lastName;
 private Integer totalSalesUnit;
 private Integer totalSalesValue;
 
 public SellerSalesDTO() {
 }
 
 public SellerSalesDTO(Long sellerId, String firstName, String lastName, Integer totalSalesUnit,
			Integer totalSalesValue) {
	this.sellerId = sellerId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.totalSalesUnit = totalSalesUnit;
	this.totalSalesValue = totalSalesValue;
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
 public int compareTo(SellerSalesDTO other) {
    if(this.getTotalSalesValue() > other.getTotalSalesValue())
        return 1;
    else if (this.getTotalSalesValue() == other.getTotalSalesValue())
        return 0 ;
    return -1 ;
 }

}
