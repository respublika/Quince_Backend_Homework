package com.example.homework.repositories;

import com.example.homework.models.Seller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long> {
	Seller findBySellerId(Long sellerId);
	List <Seller> findAllByOrderByRateDesc();
	List <Seller> findAllByOrderByRateAsc();
}
