package fr.gestionprojets.service;

import java.util.List;

import fr.gestionprojets.dao.entity.Type;

public interface TypeService {
	void add(Type type);
	
	Type edit(Type type);
	
	void delete(Long id);
	
	List<Type> finAll();
	
	Type findById(Long id);
}
