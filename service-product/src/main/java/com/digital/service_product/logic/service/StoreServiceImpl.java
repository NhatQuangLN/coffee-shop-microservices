package com.digital.service_product.logic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.service_product.entity.StoreEntity;
import com.digital.service_product.logic.repository.IStoreRepository;

@Service
public class StoreServiceImpl implements IStoreService{
	
	@Autowired
	private IStoreRepository iStoreRepository;

	@Override
	public List<StoreEntity> findAll() {
		return iStoreRepository.findAll();
	}

}
