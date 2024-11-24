package com.digital.common_lib.utils;

import com.github.f4b6a3.uuid.UuidCreator;

public class UuidUtils {

	public static String generateUuid() {
		return UuidCreator.getTimeBased().toString();
	}
}
