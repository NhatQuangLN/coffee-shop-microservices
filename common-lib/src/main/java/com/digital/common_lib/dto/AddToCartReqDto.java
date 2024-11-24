package com.digital.common_lib.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddToCartReqDto {

	private String username;
	
	private String storeUuid;
	
	private String menuUuid;
	
	private List<ProductDto> listProduct;
}
