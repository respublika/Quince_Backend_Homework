package com.example.homework.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.homework.models.CategorySalesDTO;
import com.example.homework.models.Error;
import com.example.homework.models.ProductSalesDTO;
import com.example.homework.models.Seller;
import com.example.homework.models.SellerSalesDTO;
import com.example.homework.models.Product;
import com.example.homework.repositories.ProductRepository;
import com.example.homework.repositories.RateRepository;
import com.example.homework.repositories.SellerRepository;
import com.example.homework.repositories.SaleRepository;
import com.example.homework.services.ProductService;
import com.example.homework.services.SaleService;
import com.example.homework.services.SellerService;

@RestController
public class StatController {
 private SellerRepository sellerRepository;
	 
 private ProductRepository productRepository;
	 
 private RateRepository rateRepository;
 
 private SaleRepository saleRepository;
	 
 private SellerService sellerService;
	 
 private ProductService productService;
 
 private SaleService saleService;
	 
 @Autowired
 public StatController(SellerRepository sellerRepository, ProductRepository productRepository,
		 RateRepository rateRepository, SaleRepository saleRepository,
		 SellerService sellerService, ProductService productService, SaleService saleService) {
	this.sellerRepository = sellerRepository;
	this.productRepository = productRepository;
	this.rateRepository = rateRepository;
	this.saleRepository = saleRepository;
	this.sellerService = sellerService;
	this.productService = productService;
	this.saleService = saleService;
	}
 
 @GetMapping(value = "/products/sales")
 public List<ProductSalesDTO> productsSales() {
	 return saleService.productsBySales("simple");
 }
 
 @GetMapping(value = "/products/sales-sorted-asc")
 public List<ProductSalesDTO> productsSalesbyValueAsc() {
	 return saleService.productsBySales("asc");
 }
 
 @GetMapping(value = "/products/sales-sorted-desc")
 public List<ProductSalesDTO> productsSalesbyValueDesc() {
	 return saleService.productsBySales("desc");
 }
 
 @GetMapping(value = "/sellers/sales")
 public List<SellerSalesDTO> sellersSales() {
	 return saleService.sellersBySales();
 }

 @GetMapping(value = "/sellers-sorted-rate-desc")
 public List<Seller> sellerRateSortDesc() {
	 return sellerRepository.findAllByOrderByRateDesc();
 }
 
 @GetMapping(value = "/sellers-sorted-rate-asc")
 public List<Seller> sellerRateSortAsc() {
	 return sellerRepository.findAllByOrderByRateAsc();
 }
 
 @GetMapping(value = "/sellers/sales-top-5")
 public List<SellerSalesDTO> top5SellerBySales() {
	 return saleService.top5SellersBySales();
 }
 
 @GetMapping(value = "/products/views-top-5")
 public List<Product> top5ProductView() {
	 return productRepository.findTop5ByOrderByNbQueriesDesc();
 }
 
 @GetMapping(value = "/products/sales-by-categories")
 public List<CategorySalesDTO> salesByCategories() {
	 return saleService.categoriesBySales();
 }
 
}


