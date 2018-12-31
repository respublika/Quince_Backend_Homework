package com.example.homework.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.homework.models.Product;
import com.example.homework.models.Sale;
import com.example.homework.repositories.ProductRepository;
import com.example.homework.repositories.SellerRepository;
import com.example.homework.repositories.SaleRepository;

@Service
public class ProductService {
 private SellerRepository sellerRepository;
	 
 private ProductRepository productRepository;
 
 private SaleRepository saleRepository;
	 
 @Autowired
 public ProductService(SellerRepository sellerRepository, ProductRepository productRepository,
		 SaleRepository saleRepository) {
	this.sellerRepository = sellerRepository;
	this.productRepository = productRepository;
	this.saleRepository = saleRepository;
  }
 
 public void queryGrowSave(Long id) {
	 productRepository.findByProductId(id).queryGrow();
	 productRepository.save(productRepository.findByProductId(id));
 }
 
 public void saleProcess(Long id) {
	 productRepository.findByProductId(id).sale();
	 productRepository.save(productRepository.findByProductId(id));
	 Sale sale = new Sale(productRepository.findByProductId(id).getPrice(), productRepository.findByProductId(id));
	 saleRepository.save(sale);
 }
 
 public void productUpdate(Product product, Long id) {
	 product.setProductId(id);
	 if (product.getProductName() != null) {
		 product.setProductName(product.getProductName());
	 } else {
		 product.setProductName(productRepository.findByProductId(id).getProductName());
	 }
	 
	 if (product.getDescription() != null) {
		 product.setDescription(product.getDescription());
	 } else {
		 product.setDescription(productRepository.findByProductId(id).getDescription());
	 }
	 
	 if (product.getPrice() != null) {
		 product.setPrice(product.getPrice());
	 } else {
		 product.setPrice(productRepository.findByProductId(id).getPrice());
	 }
	 
	 if (product.getCategory() != null) {
		 product.setCategory(product.getCategory());
	 } else {
		 product.setCategory(productRepository.findByProductId(id).getCategory());
	 }
	 
	 if (product.getSeller() != null) {
		 product.setSeller(sellerRepository.findBySellerId(product.getSeller().getSellerId()));
	 } else {
		 product.setStock(productRepository.findByProductId(id).getStock());
	 }
	 
	 if (product.getStock() != null) {
		 product.setStock(product.getStock());
	 } else {
		 product.setStock(productRepository.findByProductId(id).getStock());
	 }
	 
	 if (product.getNbQueries() != null) {
		 product.setNbQueries(product.getNbQueries());
	 } else {
		 product.setNbQueries(productRepository.findByProductId(id).getNbQueries());
	 }
	  
	 productRepository.save(product);

	 }
 
 	public List<String> getUniqueCategories() {
 		List<String> categories = new ArrayList<>();
 		for(Product p : productRepository.findAll()) {
 			if (!categories.contains(p.getCategory())) {
 				categories.add(p.getCategory());
 			}
 		}
 		return categories;
 	}
 	
	
}
