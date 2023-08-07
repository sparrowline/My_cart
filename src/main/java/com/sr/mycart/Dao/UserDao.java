package com.sr.mycart.Dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.sr.mycart.dto.User;

public class UserDao {

	public User saveUser(User user) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;

	}

	public User updateUser(User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();

		return user;

	}

	public User getUserByEmailAndPassword(String email, String password) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select p from User p where userEmail=?1 and userPassword=?2 ");

		query.setParameter(1, email);
		query.setParameter(2, password);

		List<User> list = query.getResultList();// converting query object into list form by using getResultList().
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);

	}
	
	

	
}
