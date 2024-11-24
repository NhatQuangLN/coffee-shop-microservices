package com.digital.service_product.logic.service;

import org.springframework.stereotype.Service;

import com.digital.common_lib.enums.MenuEnum.MenuStatus;
import com.digital.service_product.entity.MenuEntity;

@Service
public interface IMenuService {

	MenuEntity findByUuidAndStatus(String uuid, MenuStatus status);
}
