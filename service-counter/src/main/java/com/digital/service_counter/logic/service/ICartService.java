package com.digital.service_counter.logic.service;

import org.springframework.stereotype.Service;

import com.digital.service_counter.entity.CartEntity;

@Service
public interface ICartService {
	
	CartEntity findByUsernamAndStoreUuid(String username, String storeUuid);
}
