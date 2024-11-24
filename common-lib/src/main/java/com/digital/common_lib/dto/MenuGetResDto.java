package com.digital.common_lib.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuGetResDto {

	private Integer totalItems = 0;
	
	private MenuDto menu;
	
	private List<MenuDetailDto> menuDetailList = new ArrayList<>();
}
