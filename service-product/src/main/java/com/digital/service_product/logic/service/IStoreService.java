package com.digital.service_product.logic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digital.service_product.entity.StoreEntity;

@Service
public interface IStoreService {
	List<StoreEntity> findAll();
}
