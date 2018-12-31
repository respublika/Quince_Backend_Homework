package com.example.homework.models;

import javax.persistence.*;

@Entity
public class Product {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long productId;
 private String productName;
 private String description;
 private Integer price;
 private String category;
 @OneToOne(fetch = FetchType.EAGER)
 @JoinColumn(name = "sellerId")
 private Seller seller;
 private Integer stock;
 private Integer nbQueries = 0;
	 
 public Product() {
    }
	 
 public Product(String productName, String description, Integer price, String category,
				Seller seller, Integer stock) {
	 this.productName = productName;
	 this.description = description;
	 this.price = price;
	 this.category = category;
	 this.seller = seller;
	 this.stock = stock;
	}
 
 public Product(String productName, String description, Integer price, String category,
			Seller seller, Integer stock, Integer nbQueries) {
	 this.productName = productName;
	 this.description = description;
	 this.price = price;
	 this.category = category;
	 this.seller = seller;
	 this.stock = stock;
	 this.nbQueries = nbQueries;
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
 
 public String getDescription() {
	 return description;
	}
 
 public void setDescription(String description) {
	 this.description = description;
	}
 
 public Integer getPrice() {
	 return price;
	}
 
 public void setPrice(Integer price) {
	 this.price = price;
	}
		
 public String getCategory() {
	 return category;
	}
		
 public void setCategory(String category) {
	 this.category = category;
	}
		
 public Seller getSeller() {
	 return seller;
	}
		
 public void setSeller(Seller seller) {
	 this.seller = seller;
	}
		
 public Integer getStock() {
	 return stock;
	}
		
 public void setStock(Integer stock) {
	 this.stock = stock;
	}
 
 public Integer getNbQueries() {
	 return nbQueries;
	}
		
 public void setNbQueries(Integer nbQueries) {
	 this.nbQueries = nbQueries;
	}
 
 public void queryGrow() {
	 this.nbQueries++;
	}
 
 public void sale() {
	 this.stock--;
 }
}
