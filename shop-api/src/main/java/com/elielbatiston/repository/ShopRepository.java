package com.elielbatiston.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elielbatiston.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

	public Shop findByIdentifier(String identifier);
}
