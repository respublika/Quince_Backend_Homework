package com.example.homework.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.homework.repositories.SaleRepository;
import com.example.homework.repositories.ProductRepository;
import com.example.homework.repositories.SellerRepository;
import com.example.homework.models.Sale;
import com.example.homework.models.Seller;
import com.example.homework.models.SellerSalesDTO;
import com.example.homework.models.CategorySalesDTO;
import com.example.homework.models.Product;
import com.example.homework.models.ProductSalesDTO;

@Service
public class SaleService {
	private SaleRepository saleRepository;
	
	private ProductRepository productRepository;
	
	private SellerRepository sellerRepository;
	
	private ProductService productService;
	 
	@Autowired
	public SaleService(SaleRepository saleRepository, ProductRepository productRepository,
			SellerRepository sellerRepository, ProductService productService) {
		this.saleRepository = saleRepository;
		this.productRepository = productRepository;
		this.sellerRepository = sellerRepository;
		this.productService = productService;
	}
	
	public Integer sumSalesUnitsByProduct(Product product) {
		Integer sumUnit = 0;
		for(Sale s : saleRepository.findAllByProduct(product)) {
			sumUnit += s.getSalesUnit();
		}
		return sumUnit;
	}
	
	public Integer sumSalesValuesByProduct(Product product) {
		Integer sumValue = 0;
		for(Sale s : saleRepository.findAllByProduct(product)) {
			sumValue += s.getSalesValue();
		}
		return sumValue;
	}
	
	public List<ProductSalesDTO> productsBySales(String method) {
		List<ProductSalesDTO> productSales = new ArrayList<>();
		for(Product p : productRepository.findAll()) {
			productSales.add(new ProductSalesDTO(p.getProductId(), p.getProductName(), sumSalesUnitsByProduct(p), sumSalesValuesByProduct(p)));
		}
		if (method=="simple") {	
			return productSales;
		} else if (method=="asc") {
			productSales.sort(null);
			return productSales;
		} else if (method=="desc") {
			productSales.sort(Collections.reverseOrder());
			return productSales;
		} else {
			return productSales;
		}
	}
	
	public List<SellerSalesDTO> sellersBySales() {
		List<SellerSalesDTO> sellerSales = new ArrayList<>();
		for(Seller s : sellerRepository.findAll()) {
			Integer sellerSalesUnit = 0;
			Integer sellerSalesValue = 0;
			for(Product p : productRepository.findAllBySeller(s)) {
				sellerSalesUnit += sumSalesUnitsByProduct(p);
				sellerSalesValue += sumSalesValuesByProduct(p);
			}
			sellerSales.add(new SellerSalesDTO(s.getSellerId(), s.getFirstName(), s.getLastName(), sellerSalesUnit, sellerSalesValue));
		}
		return sellerSales;
	}
	
	public List<SellerSalesDTO> top5SellersBySales() {
		List<SellerSalesDTO> sellerSales = sellersBySales();
		sellerSales.sort(Collections.reverseOrder());
		if (sellerSales.size() < 5) {
			return sellerSales;
		} else {
			return sellerSales.subList(0, 4);
		}
	}
	
	public List<CategorySalesDTO> categoriesBySales() {
		List<CategorySalesDTO> categorySales = new ArrayList<>();
		for(String s : productService.getUniqueCategories()) {
			Integer sellerSalesUnit = 0;
			Integer sellerSalesValue = 0;
			for(Product p : productRepository.findAllByCategory(s)) {
				sellerSalesUnit += sumSalesUnitsByProduct(p);
				sellerSalesValue += sumSalesValuesByProduct(p);
			}
			categorySales.add(new CategorySalesDTO(s, sellerSalesUnit, sellerSalesValue));
		}
		return categorySales;
	}

}
