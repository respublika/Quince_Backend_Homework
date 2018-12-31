package com.example.homework.models;

public class CategorySalesDTO {
 private String category;
 private Integer totalSalesUnit;
 private Integer totalSalesValue;

 public CategorySalesDTO() {
 }
 
 public CategorySalesDTO(String category, Integer totalSalesUnit, Integer totalSalesValue) {
	this.category = category;
	this.totalSalesUnit = totalSalesUnit;
	this.totalSalesValue = totalSalesValue;
 }

 public String getCategory() {
	return category;
 }

 public void setCategory(String category) {
	this.category = category;
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
 
}
