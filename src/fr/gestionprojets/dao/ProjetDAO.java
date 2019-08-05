package fr.gestionprojets.dao;

import java.util.List;

import fr.gestionprojets.dao.entity.Projet;

public interface ProjetDAO {
	
	void add(Projet projet);
	
	Projet edit(Projet projet);
	
	void delete(Long id);
	
	List<Projet> finAll();
	
	Projet findById(Long id);
	
}
