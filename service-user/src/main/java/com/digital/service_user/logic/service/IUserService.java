package com.digital.service_user.logic.service;

import org.springframework.stereotype.Service;

import com.digital.service_user.entity.UserEntity;

@Service
public interface IUserService {
	UserEntity findByUsername(String username);
}
