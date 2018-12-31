package com.example.homework.repositories;

import com.example.homework.models.Product;
import com.example.homework.models.Seller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	Product findByProductId(Long productId);
	List <Product> findAllBySeller(Seller seller);
	List <Product> findAllByCategory(String category);
	List <Product> findTop5ByOrderByNbQueriesDesc();

}
