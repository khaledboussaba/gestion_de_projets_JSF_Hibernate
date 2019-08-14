package fr.gestionprojets.dao;

import java.util.List;

import org.hibernate.Session;

import fr.gestionprojets.entity.Type;
import fr.gestionprojets.utils.HibernateUtil;

public class TypeDAOImpl implements TypeDao {

	private Session session = HibernateUtil.openSession();

	@Override
	public void add(Type type) {
		session.beginTransaction();
		session.save(type);
		session.getTransaction().commit();
	}
	
	@Override
	public Type findById(Long id) {
		return (Type) session.get(Type.class, id);
	}

	@Override
	public Type edit(Type type) {
		session.beginTransaction();
		Type t = (Type) session.merge(type);
		session.getTransaction().commit();
		return t;
	}

	@Override
	public void delete(Long id) {
		session.beginTransaction();
		Type t = findById(id);
		session.delete(t);
		session.getTransaction().commit();
	}

	@Override
	public List<Type> finAll() {
		return session.createQuery("SELECT t FROM Type t").list();
	}
}
