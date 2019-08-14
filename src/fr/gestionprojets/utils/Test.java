package fr.gestionprojets.utils;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import fr.gestionprojets.dao.ProjectDAO;
import fr.gestionprojets.dao.ProjectDAOImpl;
import fr.gestionprojets.entity.Project;

public class Test {

	static private Session session = HibernateUtil.openSession();
	
	static private Logger log = Logger.getLogger(Test.class);
	
	public static void main(String[] args) {
		
//		session.createQuery("SELECT p FROM Projet p").list();
//		
//		session.createQuery("SELECT t FROM Type t").list();
		
//		ProjectDAO dao = new ProjectDAOImpl();
//		Project p = new Project();
//		
//		p.setTitle("titre de projet");
//		dao.add(p);
//		
//		log.info("ooooo");
		
	}
	
}
