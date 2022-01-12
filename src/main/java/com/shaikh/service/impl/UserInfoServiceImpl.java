package com.shaikh.service.impl;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shaikh.constants.UserRole;
import com.shaikh.model.UserInfo;
import com.shaikh.repo.IUserInfoRepo;
import com.shaikh.service.IUserInfoService;

@Service
public class UserInfoServiceImpl implements IUserInfoService, UserDetailsService {

	@Autowired
	private IUserInfoRepo repo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> opt = findByUsername(username);
		if (opt.isPresent()) {
			UserInfo user = opt.get();
			return new User(username, user.getPassword(),
					Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
		} else {
			throw new UsernameNotFoundException("Invalid username or password");
		}

	}

	@Override
	public String createUserInfo(UserInfo userInfo) {

		String encodedPassword = passwordEncoder.encode(userInfo.getPassword());
		userInfo.setPassword(encodedPassword);
		Long genId = repo.save(userInfo).getId();

		return "User " + genId + " Created";
	}

	@Override
	public Optional<UserInfo> findByUsername(String username) {
		return repo.findByUsername(username);
	}

}
