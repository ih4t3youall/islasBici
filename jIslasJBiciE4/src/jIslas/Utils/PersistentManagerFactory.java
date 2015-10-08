package jIslas.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistentManagerFactory {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jIslasJBiciE4");
	private static EntityManager em = emf.createEntityManager();
	static public EntityManager getEntityManager() {
		
		return (em);

	}	
}
