package com.elielbatiston.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elielbatiston.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByIdentifier(String identifier);
}
