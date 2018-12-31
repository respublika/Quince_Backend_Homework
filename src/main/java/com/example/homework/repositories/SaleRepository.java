package com.example.homework.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.homework.models.Sale;
import com.example.homework.models.Product;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Long> {
	Sale findBySaleId(Long saleId);
	List <Sale> findAllByProduct(Product product);
}


