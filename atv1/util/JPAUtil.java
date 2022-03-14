package br.com.compass.pb.sprint3.atv1.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("sprint3");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}