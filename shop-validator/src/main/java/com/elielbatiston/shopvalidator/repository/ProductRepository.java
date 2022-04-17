package com.elielbatiston.shopvalidator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elielbatiston.shopvalidator.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByIdentifier(String identifier);
}
