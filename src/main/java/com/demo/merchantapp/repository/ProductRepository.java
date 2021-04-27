package com.demo.merchantapp.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.demo.merchantapp.dao.Product;

@Repository
public class ProductRepository {

	private SessionFactory sessionFactory;

	public ProductRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Product product) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		}

	}

	public void update(Product product) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
		}
	}

	public Product findById(int id) {
		try (Session session = sessionFactory.openSession()) {
			@SuppressWarnings("unchecked")
			Query<Product> query = session.createQuery("from Product where id=:id");
			query.setParameter("id", id);
			return query.uniqueResult();
		}
	}

	public void delete(int id) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Product product = session.load(Product.class, id);
			session.delete(product);
			session.getTransaction().commit();
		}
	}
}
