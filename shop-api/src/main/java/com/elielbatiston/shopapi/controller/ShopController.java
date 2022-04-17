package com.elielbatiston.shopapi.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elielbatiston.shopapi.dto.ShopDTO;
import com.elielbatiston.shopapi.model.Shop;
import com.elielbatiston.shopapi.model.ShopItem;
import com.elielbatiston.shopapi.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {
	
	private final ShopRepository shopRepository;
	
	@GetMapping
	public List<ShopDTO> getShop() {
		return shopRepository.findAll().stream()
				.map(shop -> ShopDTO.convert(shop)).collect(Collectors.toList());
	}
	
	@PostMapping
	public ShopDTO saveShop(@RequestBody ShopDTO shopDTO) {
		
		shopDTO.setIdentifier(UUID.randomUUID().toString());
		shopDTO.setDateShop(LocalDate.now());
		shopDTO.setStatus("PENDING");
		
		Shop shop = Shop.convert(shopDTO);
		for (ShopItem shopItem : shop.getItems()) {
			shopItem.setShop(shop);
		}
		
		return ShopDTO.convert(shopRepository.save(shop));
	}
}
