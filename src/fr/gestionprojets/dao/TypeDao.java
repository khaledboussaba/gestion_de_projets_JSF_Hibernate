package fr.gestionprojets.dao;

import java.util.List;

import fr.gestionprojets.entity.Type;

public interface TypeDao {
	void add(Type type);
	
	Type edit(Type type);
	
	void delete(Long id);
	
	List<Type> finAll();
	
	Type findById(Long id);
}
