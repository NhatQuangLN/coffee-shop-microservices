package com.digital.common_lib.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuDto {

	private String menuName;
	
	private String storeName;
	
	private String storeUuid;
}
