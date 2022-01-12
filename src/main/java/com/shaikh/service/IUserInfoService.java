package com.shaikh.service;

import java.util.Optional;

import com.shaikh.model.UserInfo;

public interface IUserInfoService {
	
	public String createUserInfo(UserInfo userInfo);
	
	public Optional<UserInfo> findByUsername(String username);

}
