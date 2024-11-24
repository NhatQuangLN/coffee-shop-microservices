package com.digital.service_user.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.service_user.entity.UserEntity;
import com.digital.service_user.logic.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository iUserRepository;

	@Override
	public UserEntity findByUsername(String username) {
		return iUserRepository.findByUsername(username);
	}

}
