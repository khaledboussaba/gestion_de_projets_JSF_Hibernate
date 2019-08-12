package fr.gestionprojets.service;

import java.util.List;

import fr.gestionprojets.dao.ProjectDAO;
import fr.gestionprojets.dao.ProjectDAOImpl;
import fr.gestionprojets.dao.entity.Project;

public class ProjectServiceImpl implements ProjectService {

	private ProjectDAO dao = new ProjectDAOImpl();
	
	@Override
	public void add(Project projet) {
		dao.add(projet);
	}

	@Override
	public Project edit(Project projet) {
		return dao.edit(projet);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public List<Project> finAll() {
		return dao.finAll();
	}

	@Override
	public Project findById(Long id) {
		return dao.findById(id);
	}

}
