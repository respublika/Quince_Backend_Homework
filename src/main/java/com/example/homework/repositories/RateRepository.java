package com.example.homework.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.homework.models.Rate;
import com.example.homework.models.Seller;

@Repository
public interface RateRepository extends CrudRepository<Rate, Long> {
	Rate findByRateId(Long rateId);
	List <Rate> findAllBySeller(Seller seller);
}
