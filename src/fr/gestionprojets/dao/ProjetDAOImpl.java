package fr.gestionprojets.dao;

import java.util.List;

import org.hibernate.Session;

import fr.gestionprojets.dao.entity.Projet;
import fr.gestionprojets.utils.HibernateUtil;

public class ProjetDAOImpl implements ProjetDAO {

	private Session session = HibernateUtil.openSession();
	
	@Override
	public void add(Projet projet) {
		session.beginTransaction();
		session.save(projet);
		session.getTransaction().commit();
	}
	
	@Override
	public Projet findById(Long id) {
		return (Projet) session.get(Projet.class, id);
	}

	@Override
	public Projet edit(Projet projet) {
		session.beginTransaction();
		Projet p = (Projet) session.merge(projet);
		session.getTransaction().commit();
		return p;
	}

	@Override
	public void delete(Long id) {
		session.beginTransaction();
		Projet p = findById(id);
		session.delete(p);
		session.getTransaction().commit();
	}

	@Override
	public List<Projet> finAll() {
		return session.createQuery("SELECT o FROM Projet o").list();
	}

}
