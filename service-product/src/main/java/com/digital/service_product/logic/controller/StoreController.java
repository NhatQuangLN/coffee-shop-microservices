package com.digital.service_product.logic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.common_lib.dto.StoreDto;
import com.digital.common_lib.dto.StoreGetAllResDto;
import com.digital.service_product.entity.StoreEntity;
import com.digital.service_product.logic.service.IStoreService;

@RestController
@RequestMapping("/service-product/store")
public class StoreController {
	
	@Autowired
	private IStoreService iStoreService;

	@GetMapping("/get-all")
	public StoreGetAllResDto getAllStore() {
		
		StoreGetAllResDto storeGetAllResDto = new StoreGetAllResDto();
		
		List<StoreEntity> storeList = iStoreService.findAll();
		
		if (!storeList.isEmpty()) {
			List<StoreDto> storeDtoList = storeList.stream().map(s -> {
				StoreDto dto = new StoreDto();
				
				convertToStoreDto(s, dto);
				return dto;
			}).toList();
			storeGetAllResDto.setTotalItems(storeDtoList.size());
			storeGetAllResDto.setListStore(storeDtoList);
		}
		
		return storeGetAllResDto;
	}
	
	private static StoreDto convertToStoreDto(StoreEntity store, StoreDto dto) {

		dto.setStoreName(store.getStoreName());
		dto.setUuid(store.getUuid());
		
		return dto;
	}
}
