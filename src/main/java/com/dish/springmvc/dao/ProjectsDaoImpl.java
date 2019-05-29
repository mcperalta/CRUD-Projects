package com.dish.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dish.springmvc.model.Projects;



@Repository("projectsDao")
public class ProjectsDaoImpl extends AbstractDao<Integer, Projects> implements ProjectsDao {

	static final Logger logger = LoggerFactory.getLogger(ProjectsDaoImpl.class);
	
	public Projects findById(int id) {
		Projects project = getByKey(id);
		if(project!=null){
			Hibernate.initialize(project.getId());
		}
		return project;
	}

	public Projects findByName(String name) {
		logger.info("name : {}", name);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		Projects project = (Projects)crit.uniqueResult();
		if(project!=null){
			Hibernate.initialize(project.getName());
		}
		return project;
	}

	@SuppressWarnings("unchecked")
	public List<Projects> findAllProjects() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Projects> projects = (List<Projects>) criteria.list();
		
                
		/*
		for(Projects project : projects){
			Hibernate.initialize(project.getName());
		}*/
		return projects;
	}

	public void save(Projects project) {
		persist(project);
	}

	public void deleteByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		Projects project = (Projects)crit.uniqueResult();
		delete(project);
	}

}
