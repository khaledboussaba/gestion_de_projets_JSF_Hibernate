package fr.gestionprojets.utils;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import fr.gestionprojets.dao.ProjetDAO;
import fr.gestionprojets.dao.ProjetDAOImpl;
import fr.gestionprojets.dao.entity.Projet;

public class Test {

	static private Session session = HibernateUtil.openSession();
	
	static private Logger log = Logger.getLogger(Test.class);
	
	public static void main(String[] args) {
		
//		session.createQuery("SELECT p FROM Projet p").list();
//		
//		session.createQuery("SELECT t FROM Type t").list();
		
		ProjetDAO dao = new ProjetDAOImpl();
		Projet p = new Projet();
		
		p.setTitle("titre de projet");
		dao.add(p);
		
		log.info("ooooo");
		
	}
	
}
