package com.digital.common_lib.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuDetailDto {

	private String productUuid;
	
	private String productCode;
	
	private Double price;
}
