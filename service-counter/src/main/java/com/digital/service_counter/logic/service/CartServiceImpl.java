package com.digital.service_counter.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.service_counter.entity.CartEntity;
import com.digital.service_counter.logic.repository.ICartRepository;

@Service
public class CartServiceImpl implements ICartService{
	
	@Autowired
	private ICartRepository iCartRepository;

	@Override
	public CartEntity findByUsernamAndStoreUuid(String username, String storeUuid) {

		return iCartRepository.findByUsernamAndStoreUuid(username, storeUuid);
	}
	
}
