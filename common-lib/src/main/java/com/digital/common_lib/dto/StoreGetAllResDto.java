package com.digital.common_lib.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StoreGetAllResDto {
	
	private Integer totalItems;

	private List<StoreDto> listStore;
}
