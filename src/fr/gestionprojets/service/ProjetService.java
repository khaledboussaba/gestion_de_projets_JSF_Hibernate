package fr.gestionprojets.service;

import java.util.List;

import fr.gestionprojets.dao.entity.Projet;

public interface ProjetService {
	void add(Projet projet);
	
	Projet edit(Projet projet);
	
	void delete(Long id);
	
	List<Projet> finAll();
	
	Projet findById(Long id);
}
