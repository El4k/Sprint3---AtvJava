package br.com.compass.pb.sprint3.atv1.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.compass.pb.sprint3.atv1.model.Product;
import br.com.compass.pb.sprint3.atv1.util.JPAUtil;

public class ProductDao {

	private EntityManager em = JPAUtil.getEntityManager();

	public void register(Product product) {
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
	}

	public void update(Product product) {
		em.getTransaction().begin();
		em.merge(product);
		em.getTransaction().commit();
		em.close();
	}

	public void remove(Product product) {
		em.getTransaction().begin();
		product = em.merge(product);
		em.remove(product);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Product> searchAll() {
		em.getTransaction().begin();
		String jpql = "SELECT p FROM Product p";
		return em.createQuery(jpql, Product.class).getResultList();
	}
	
	public Product searchSingle() {
		em.getTransaction().begin();
		String jpql = "SELECT p FROM Product p";
		return em.createQuery(jpql, Product.class).getSingleResult();
	}
}