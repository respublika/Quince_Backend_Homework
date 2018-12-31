package com.example.homework.controllers;

import com.example.homework.repositories.ProductRepository;
import com.example.homework.repositories.SellerRepository;
import com.example.homework.repositories.RateRepository;
import com.example.homework.models.Product;
import com.example.homework.models.Seller;
import com.example.homework.models.Error;
import com.example.homework.models.Rate;
import com.example.homework.services.SellerService;
import com.example.homework.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class BasicController {
 private SellerRepository sellerRepository;
 
 private ProductRepository productRepository;
 
 private RateRepository rateRepository;
 
 private SellerService sellerService;
 
 private ProductService productService;
 
 @Autowired
 public BasicController(SellerRepository sellerRepository, ProductRepository productRepository,
		 RateRepository rateRepository, SellerService sellerService, ProductService productService) {
	    this.sellerRepository = sellerRepository;
	    this.productRepository = productRepository;
	    this.rateRepository = rateRepository;
	    this.sellerService = sellerService;
	    this.productService = productService;
	}
 
 @PostMapping(value = "/sellers")
 public Object postSeller(@RequestBody(required = true) Seller seller) {
	 sellerRepository.save(seller);
     return sellerRepository.findAll();
 } 
 
 @PostMapping(value = "/sellers/{id}")
 public Object postProduct(@RequestBody(required = true) Product product,
		 @PathVariable Long id) {
	 product.setSeller(sellerRepository.findBySellerId(id));
     productRepository.save(product);
     return productRepository.findAll();
 }
 
 @GetMapping(value = "/products/{id}")
 public Object getProductsById(@PathVariable Long id) { 
	 if (productRepository.findByProductId(id) != null) {
		productService.queryGrowSave(id);
		return productRepository.findByProductId(id);
	 } else {
		return new Error("Requested product doesn't exist.");
	 }
 }
 
 @GetMapping(value = "/products/{id}/sale")
 public Object productSale(@PathVariable Long id) { 
	 if (productRepository.findByProductId(id) != null) {
		 if (productRepository.findByProductId(id).getStock()>0) {
			 productService.saleProcess(id);
			 return productRepository.findByProductId(id);
		 } else {
			 return new Error("Requested product run out of stock.");
		 }
	 } else {
		return new Error("Requested product doesn't exist.");
	 }
 }

 @GetMapping(value = "/sellers/{id}")
 public Object getSellersById(@PathVariable Long id) {
	 if (sellerRepository.findBySellerId(id) != null) {
			return sellerRepository.findBySellerId(id);
		 } else {
			return new Error("Requested seller doesn't exist.");
		 }
 }
 
 @PostMapping(value = "/sellers/{id}/rate")
 public Object sellerRate(@RequestBody(required = true) Integer ratePoint,
		 @PathVariable Long id) {
	 if (sellerRepository.findBySellerId(id) != null) {
		 	Rate rate = new Rate(ratePoint, sellerRepository.findBySellerId(id));
		 	rateRepository.save(rate);
		 	sellerService.countRateForSeller(id);
			return sellerRepository.findBySellerId(id);
		 } else {
			return new Error("Requested seller doesn't exist.");
		 }
 }
 
 @GetMapping(value = "/products")
 public Object getProducts() {
     return productRepository.findAll();
 }
 
 @GetMapping(value = "/sellers/{id}/products")
 public Object getProductsBySeller(@PathVariable Long id) {
	 if (sellerRepository.findBySellerId(id) == null) {
		 return new Error("Requested seller doesn't exist.");
	 } else if (productRepository.findAllBySeller(sellerRepository.findBySellerId(id)).size() > 0) {
		 return productRepository.findAllBySeller(sellerRepository.findBySellerId(id));
	 } else {
		 return new Error("Requested seller hasn't got any product.");
	 }
 }

 @GetMapping(value = "/sellers")
 public Object getSellers() {
     return sellerRepository.findAll();
 }
 
 @DeleteMapping(value = "/products/{id}")
 public Object deleteProductsById(@PathVariable Long id) {
	 if (productRepository.findByProductId(id) != null) {
		 productRepository.deleteById(id);
		 return productRepository.findAll();
	 } else {
		 return new Error("Requested product doesn't exist.");
	 }	 
 }

 @DeleteMapping(value = "/sellers/{id}")
 public Object deleteSellersById(@PathVariable Long id) {
	 if (sellerRepository.findBySellerId(id) != null) {
		 sellerRepository.deleteById(id);
	     return sellerRepository.findAll();
	 } else {
		 return new Error("Requested seller doesn't exist.");
	 }
 }

 @PatchMapping(value = "/products/{id}")
 public Object ModifyProductsById(@RequestBody Product product,
		 @PathVariable Long id) {
	 if (productRepository.findByProductId(id) != null) {
		 if (product.getSeller() != null && 
				 sellerRepository.findBySellerId(product.getSeller().getSellerId()) == null) {
			 return new Error("Requested seller doesn't exist.");
		 } else {
			 productService.productUpdate(product, (Long) id);
			 return productRepository.findAll();
	 } } else {
		 return new Error("Requested product doesn't exist.");
	 }
 }


 @PatchMapping(value = "/sellers/{id}")
 public Object ModifySellersById(@RequestBody Seller seller, 
		 @PathVariable Long id) {
	 if (sellerRepository.findBySellerId(id) != null) {
		 sellerService.sellerUpdate(seller, (Long) id);
		 return sellerRepository.findAll();
	 } else {
		 return new Error("Requested seller doesn't exist.");
	 }
 }
}





