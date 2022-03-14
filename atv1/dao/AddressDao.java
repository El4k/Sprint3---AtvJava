package br.com.compass.pb.sprint3.atv1.dao;

import javax.persistence.EntityManager;

import br.com.compass.pb.sprint3.atv1.model.Address;
import br.com.compass.pb.sprint3.atv1.util.JPAUtil;

public class AddressDao {
	
	private EntityManager em = JPAUtil.getEntityManager();

	public void register(Address address) {
		em.getTransaction().begin();
		em.persist(address);
		em.getTransaction().commit();
		em.close();
	}

	public void update(Address address) {
		em.getTransaction().begin();
		em.merge(address);
		em.getTransaction().commit();
		em.close();
	}

	public void remove(Address address) {
		em.getTransaction().begin();
		address = em.merge(address);
		em.remove(address);
		em.getTransaction().commit();
		em.close();
	}
	
	public Address searchSingle() {
		em.getTransaction().begin();
		String jpql = "SELECT p FROM Address p";
		return em.createQuery(jpql, Address.class).getSingleResult();
	}
}
