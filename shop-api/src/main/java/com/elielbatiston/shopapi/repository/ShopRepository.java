package com.elielbatiston.shopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elielbatiston.shopapi.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
