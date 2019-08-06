package fr.gestionprojets.service;

import java.util.List;

import fr.gestionprojets.dao.TypeDAOImpl;
import fr.gestionprojets.dao.TypeDao;
import fr.gestionprojets.dao.entity.Type;

public class TypeServiceImpl implements TypeService {

	private TypeDao dao = new TypeDAOImpl();

	@Override
	public void add(Type type) {
		dao.add(type);
	}

	@Override
	public Type edit(Type type) {
		return dao.edit(type);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public List<Type> finAll() {
		return dao.finAll();
	}

	@Override
	public Type findById(Long id) {
		return dao.findById(id);
	}
	
	

}
