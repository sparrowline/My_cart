package com.sr.mycart.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sr.mycart.dto.Category;

public class CategoryDao {
	public Category saveCategory(Category category) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(category);
		entityTransaction.commit();
		System.out.println("data commited");
		return category;
	}

	public List<Category> displayCategory() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select c from Category c");
		List<Category> list = query.getResultList();

		return list;
	}

	public Category getCategoryById(int cid) {
		Category category = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			category = entityManager.find(Category.class, cid);

			if (category != null) {
				return category;
			}
		//	entityManager.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;

	}

}
