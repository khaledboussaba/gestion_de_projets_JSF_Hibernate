package fr.gestionprojets.service;

import java.util.List;

import fr.gestionprojets.entity.Project;

public interface ProjectService {
	void add(Project projet);
	
	Project edit(Project projet);
	
	void delete(Long id);
	
	List<Project> finAll();
	
	Project findById(Long id);
}
