package fr.gestionprojets.dao;

import java.util.List;

import org.hibernate.Session;

import fr.gestionprojets.dao.entity.Project;
import fr.gestionprojets.utils.HibernateUtil;

public class ProjectDAOImpl implements ProjectDAO {

	private Session session = HibernateUtil.openSession();
	
	@Override
	public void add(Project projet) {
		session.beginTransaction();
		session.save(projet);
		session.getTransaction().commit();
	}
	
	@Override
	public Project findById(Long id) {
		return (Project) session.get(Project.class, id);
	}

	@Override
	public Project edit(Project projet) {
		session.beginTransaction();
		Project p = (Project) session.merge(projet);
		session.getTransaction().commit();
		return p;
	}

	@Override
	public void delete(Long id) {
		session.beginTransaction();
		Project p = findById(id);
		session.delete(p);
		session.getTransaction().commit();
	}

	@Override
	public List<Project> finAll() {
		return session.createQuery("SELECT o FROM Project o").list();
	}

}
