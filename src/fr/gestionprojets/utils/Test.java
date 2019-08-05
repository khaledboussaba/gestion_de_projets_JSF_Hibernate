package fr.gestionprojets.utils;

import org.hibernate.Session;

public class Test {

	static private Session session = HibernateUtil.openSession();
	
	public static void main(String[] args) {
		
		session.createQuery("SELECT p FROM Projet p").list();
		
		session.createQuery("SELECT t FROM Type t").list();
		
	}
	
}
