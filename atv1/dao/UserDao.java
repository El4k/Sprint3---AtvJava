package br.com.compass.pb.sprint3.atv1.dao;

import javax.persistence.EntityManager;

import br.com.compass.pb.sprint3.atv1.model.User;
import br.com.compass.pb.sprint3.atv1.util.JPAUtil;

public class UserDao {

	private EntityManager em = JPAUtil.getEntityManager();

	public void register(User usuario) {
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}

	public void update(User usuario) {
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
	}

	public void remove(User usuario) {
		em.getTransaction().begin();
		usuario = em.merge(usuario);
		em.remove(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	public User searchSingle() {
		em.getTransaction().begin();
		String jpql = "SELECT p FROM Usuario p";
		return em.createQuery(jpql, User.class).getSingleResult();
	}
	
	public User searchUser(String login, String password) {
		em.getTransaction().begin();
		String jpql = "FROM User WHERE login = :login AND password = :password";
		return em.createQuery(jpql, User.class).setParameter("login", login).setParameter("password", password).getSingleResult();		
	}
}