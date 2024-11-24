package com.digital.service_counter.logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.common_lib.dto.AddToCartReqDto;
import com.digital.common_lib.utils.UuidUtils;
import com.digital.service_counter.entity.CartEntity;
import com.digital.service_counter.logic.service.ICartService;

@RestController()
@RequestMapping("/service-counter/cart")
public class CartController {
	
	@Autowired
	private ICartService iCartService;

	@PostMapping("/add-to-cart")
	public void addToCart(@RequestBody AddToCartReqDto addToCartReqDto) {
		
		CartEntity cart = iCartService.findByUsernamAndStoreUuid(addToCartReqDto.getUsername(),
				addToCartReqDto.getStoreUuid());
		
		if (cart == null) {
			CartEntity cartAdd = new CartEntity();
			cartAdd.setStoreUuid(addToCartReqDto.getStoreUuid());
			cartAdd.setUsername(addToCartReqDto.getUsername());
			cartAdd.setUuid(UuidUtils.generateUuid());
		}
	}
}
