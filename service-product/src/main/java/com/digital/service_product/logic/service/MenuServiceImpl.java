package com.digital.service_product.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.common_lib.enums.MenuEnum.MenuStatus;
import com.digital.service_product.entity.MenuEntity;
import com.digital.service_product.logic.repository.IMenuRepository;

@Service
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private IMenuRepository iMenuRepository;

	@Override
	public MenuEntity findByUuidAndStatus(String uuid, MenuStatus status) {
		return iMenuRepository.findByUuidAndStatus(uuid, status);
	}

}
