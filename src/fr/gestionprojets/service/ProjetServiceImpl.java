package fr.gestionprojets.service;

import java.util.List;

import fr.gestionprojets.dao.ProjetDAO;
import fr.gestionprojets.dao.ProjetDAOImpl;
import fr.gestionprojets.dao.entity.Projet;

public class ProjetServiceImpl implements ProjetService {

	private ProjetDAO dao = new ProjetDAOImpl();
	
	@Override
	public void add(Projet projet) {
		dao.add(projet);
	}

	@Override
	public Projet edit(Projet projet) {
		return dao.edit(projet);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public List<Projet> finAll() {
		return dao.finAll();
	}

	@Override
	public Projet findById(Long id) {
		return dao.findById(id);
	}

}
