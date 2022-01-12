package com.shaikh.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaikh.model.UserInfo;

public interface IUserInfoRepo extends JpaRepository<UserInfo, Long>{
	
	public Optional<UserInfo> findByUsername(String username);

}
