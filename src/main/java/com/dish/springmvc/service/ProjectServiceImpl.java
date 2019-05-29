package com.dish.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dish.springmvc.dao.ProjectsDao;
import com.dish.springmvc.model.Projects;


@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectsDao dao;

	
	public Projects findById(int id) {
		return dao.findById(id);
	}

	public Projects findByName(String name) {
		Projects project = dao.findByName(name);
		return project;
	}

	public void saveProjects(Projects project) {
		
		dao.save(project);
	}


	public void updateProject(Projects project) {
		Projects entity = dao.findById(project.getId());
		if(entity!=null){
			entity.setName(project.getName());
			entity.setDescription(project.getDescription());
			entity.setManager(project.getManager());			
		}
	}

	
	public void deleteProjectByName(String name) {
		dao.deleteByName(name);
	}

	public List<Projects> findAllProjects() {
		return dao.findAllProjects();
	}

	public boolean isProjectUnique(Integer id, String name) {
		Projects project = findByName(name);
		return ( project == null || ((id != null) && (project.getId() == id)));
	}
	
}
