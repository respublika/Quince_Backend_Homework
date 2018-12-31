package com.example.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.homework.repositories.ProductRepository;
import com.example.homework.repositories.SellerRepository;
import com.example.homework.repositories.RateRepository;
import com.example.homework.services.SellerService;

import com.example.homework.services.ProductService;
import com.example.homework.models.Product;
import com.example.homework.models.Seller;
import com.example.homework.models.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class QuinceHomeworkTSzApplication implements CommandLineRunner {
	
	private final
	SellerRepository sellerRepository;

    private final
    ProductRepository productRepository;
    
    private final
    RateRepository rateRepository;
    
    private final
    SellerService sellerService;
    
    private final
    ProductService productService;

    @Autowired
    public QuinceHomeworkTSzApplication(SellerRepository sellerRepository, ProductRepository productRepository,
    		RateRepository rateRepository, SellerService sellerService, ProductService productService) {
    	this.sellerRepository = sellerRepository;
	    this.productRepository = productRepository;
	    this.rateRepository = rateRepository;
	    this.sellerService = sellerService;
	    this.productService = productService;
    }

	public static void main(String[] args) {
		SpringApplication.run(QuinceHomeworkTSzApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		sellerRepository.save(new Seller("Ben", "Smith", "ben.smith@yahoo.com"));
		sellerRepository.save(new Seller("Pete", "Johnson", "pete.j@gmail.com"));
		sellerRepository.save(new Seller("Anne", "Lincoln", "a.lin@gmail.com"));
		productRepository.save(new Product("Television", "43inch smart tv", 83000, "Electronics", sellerRepository.findBySellerId((long) 1), 3));
		productRepository.save(new Product("Samsung J6", "Samsung J6 smartphone", 52000, "Phones and accessories", sellerRepository.findBySellerId((long) 1), 2, 5));
		productRepository.save(new Product("IPhone XS case", "IPhone XS phone case, more colour", 3500, "Phones and accessories", sellerRepository.findBySellerId((long) 2), 12));
		productRepository.save(new Product("Jeans", "Slim fit woman jeans, S-L", 6800, "Clothing", sellerRepository.findBySellerId((long) 3), 5, 3));
		productRepository.save(new Product("Eyeshadow palette", "130 colours eyeshadow palette in 2 different colour", 12500, "Beauty and health", sellerRepository.findBySellerId((long) 3), 7));
		rateRepository.save(new Rate(4, sellerRepository.findBySellerId((long) 1)));
		rateRepository.save(new Rate(3, sellerRepository.findBySellerId((long) 1)));
		sellerService.countRateForSeller((long) 1);
		rateRepository.save(new Rate(1, sellerRepository.findBySellerId((long) 3)));
		rateRepository.save(new Rate(3, sellerRepository.findBySellerId((long) 3)));
		sellerService.countRateForSeller((long) 3);
		productService.queryGrowSave((long) 1);
		productService.queryGrowSave((long) 1);
		productService.queryGrowSave((long) 1);
		productService.queryGrowSave((long) 2);
		productService.queryGrowSave((long) 3);
		productService.saleProcess((long) 1);
		productService.saleProcess((long) 1);
		productService.saleProcess((long) 1);
		productService.saleProcess((long) 2);
		productService.saleProcess((long) 2);
		productService.saleProcess((long) 4);
    }

}

