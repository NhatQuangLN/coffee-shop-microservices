package com.digital.common_lib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.digital.common_lib.utils.UuidUtils;

@SpringBootApplication
public class CommonLibApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonLibApplication.class, args);
		System.out.println(UuidUtils.generateUuid());
	}

}
