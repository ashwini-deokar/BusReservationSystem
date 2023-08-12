package com.ashwini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwini.entity.Product;


public interface DataRepository extends JpaRepository<Product , Integer>{

	//Product findByName(String productName);

}
