package com.dish.springmvc.dao;

import java.util.List;

import com.dish.springmvc.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findByUsername(String username);
}
