package com.dish.springmvc.dao;

import java.util.List;

import com.dish.springmvc.model.Projects;


public interface ProjectsDao {

	Projects findById(int id);
        
        Projects findByName(String name);

	void save(Projects project);
	
	void deleteByName(String name);
	
	List<Projects> findAllProjects();

}

