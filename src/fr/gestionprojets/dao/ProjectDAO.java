package fr.gestionprojets.dao;

import java.util.List;

import fr.gestionprojets.entity.Project;

public interface ProjectDAO {
	
	void add(Project projet);
	
	Project edit(Project projet);
	
	void delete(Long id);
	
	List<Project> finAll();
	
	Project findById(Long id);
	
}
