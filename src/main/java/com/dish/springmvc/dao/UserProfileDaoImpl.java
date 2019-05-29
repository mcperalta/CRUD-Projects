package com.dish.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dish.springmvc.model.UserProfile;



@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<String, UserProfile>implements UserProfileDao{

	public UserProfile findByUsername(String username) {
		return getByKey(username);
	}

	public UserProfile findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (UserProfile) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserProfile> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<UserProfile>)crit.list();
	}
	
}
