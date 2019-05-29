package com.dish.springmvc.service;

import java.util.List;

import com.dish.springmvc.model.UserProfile;


public interface UserProfileService {

	UserProfile findByUsername(String username);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
