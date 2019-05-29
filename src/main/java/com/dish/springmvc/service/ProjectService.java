package com.dish.springmvc.service;

import java.util.List;

import com.dish.springmvc.model.Projects;


public interface ProjectService {
	
	Projects findById(int id);
	
	Projects findByName(String name);
	
	void saveProjects(Projects project);
	
	void updateProject(Projects project);
	
	void deleteProjectByName(String name);

	List<Projects> findAllProjects(); 
	
	boolean isProjectUnique(Integer id, String name);

}