package com.example.homework.services;

import java.util.IntSummaryStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.homework.repositories.SellerRepository;
import com.example.homework.repositories.RateRepository;
import com.example.homework.models.Seller;

@Service
public class SellerService {
 private SellerRepository sellerRepository;
 
 private RateRepository rateRepository;
		 
 @Autowired
 public SellerService(SellerRepository sellerRepository, RateRepository rateRepository) {
	this.sellerRepository = sellerRepository;
	this.rateRepository = rateRepository;
 }
 
 public void countRateForSeller(Long id) {
	 Seller seller = sellerRepository.findBySellerId(id);
	 IntSummaryStatistics stats = rateRepository.findAllBySeller(sellerRepository.findBySellerId(id))
	 .stream().map(r -> r.getRatePoint()).mapToInt(Integer::intValue)
	    .summaryStatistics();
	 Double rateCount = stats.getAverage();
	 seller.setRate(rateCount);
	 sellerRepository.save(seller);
 }
 
 public void sellerUpdate(Seller seller, Long id) {
	 seller.setSellerId(id);
	 if (seller.getFirstName() != null) {
		 seller.setFirstName(seller.getFirstName());
	 } else {
		 seller.setFirstName(sellerRepository.findBySellerId(id).getFirstName());
	 }
	 
	 if (seller.getLastName() != null) {
		 seller.setLastName(seller.getLastName());
	 } else {
		 seller.setLastName(sellerRepository.findBySellerId(id).getLastName());
	 }
	 
	 if (seller.getEmail() != null) {
		 seller.setEmail(seller.getEmail());
	 } else {
		 seller.setEmail(sellerRepository.findBySellerId(id).getEmail());
	 }
	 
	 if (seller.getRate() != null) {
		 seller.setRate(seller.getRate());
	 } else {
		 seller.setRate(sellerRepository.findBySellerId(id).getRate());
	 }
	 
	 sellerRepository.save(seller);

	 }
	
}

