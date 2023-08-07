package com.sr.mycart.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sr.mycart.dto.Product;

public class ProductDao {
	public Product saveProduct(Product product) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			if (product != null) {
				entityTransaction.begin();
				entityManager.merge(product);
				entityTransaction.commit();

				return product;
			}
			return product;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

	public List<Product> getAllProducts() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select h from Product h");
		List<Product> list = query.getResultList(); // converting query object into list form by using getResultList().

		return list;

	}

	public List<Product> getAllProductsById(int cid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select p from Product p where p.category.categoryId=:id");
		query.setParameter("id", cid);
		List<Product> list = query.getResultList(); // converting query object into list form by using getResultList().

		return list;
	}
	

}
