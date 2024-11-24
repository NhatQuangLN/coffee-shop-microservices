package com.digital.service_product.logic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.common_lib.dto.MenuDetailDto;
import com.digital.common_lib.dto.MenuDto;
import com.digital.common_lib.dto.MenuGetReqDto;
import com.digital.common_lib.dto.MenuGetResDto;
import com.digital.common_lib.enums.MenuEnum.MenuStatus;
import com.digital.service_product.entity.MenuDetailEntity;
import com.digital.service_product.entity.MenuEntity;
import com.digital.service_product.logic.service.IMenuService;

@RestController
@RequestMapping("/service-product/menu")
public class MenuController {

	@Autowired
	private IMenuService iMenuService;

	@GetMapping("/active")
	public MenuGetResDto getActiveMenu(MenuGetReqDto menuGetReqDto) {

		MenuGetResDto menuGetResDto = new MenuGetResDto();

		MenuEntity menu = iMenuService.findByUuidAndStatus(menuGetReqDto.getMenuUuid(), MenuStatus.Y);
		
		if (menu != null) {
			menuGetResDto.setTotalItems(menu.getMenuDetails().size());

			menuGetResDto.setMenu(convertToMenuDto(menu, new MenuDto()));
			
			List<MenuDetailDto> menuDetailDtoList = menu.getMenuDetails().stream().map(d -> {
				MenuDetailDto dto = new MenuDetailDto();
				return convertToMenuDetailDto(d, dto);
			}).toList();

			menuGetResDto.setMenuDetailList(menuDetailDtoList);
		}

		return menuGetResDto;
	}

	private static MenuDetailDto convertToMenuDetailDto(MenuDetailEntity detail, MenuDetailDto dto) {

		dto.setPrice(detail.getPrice());
		if (detail.getProduct() != null) {
			dto.setProductCode(detail.getProduct().getCode());
			dto.setProductUuid(detail.getProduct().getUuid());
		}
		return dto;
	}
	
	private static MenuDto convertToMenuDto(MenuEntity detail, MenuDto dto) {

		dto.setMenuName(detail.getMenuName());
		
		if (detail.getStore() != null) {
			dto.setStoreName(detail.getStore().getStoreName());
			dto.setStoreUuid(detail.getStore().getUuid());
		}
		
		return dto;
	}
}
