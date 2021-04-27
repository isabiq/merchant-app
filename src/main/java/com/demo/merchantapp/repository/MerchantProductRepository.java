package com.demo.merchantapp.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.demo.merchantapp.dao.MerchantProduct;

@Repository
public class MerchantProductRepository {

	private SessionFactory sessionFactory;

	public MerchantProductRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(MerchantProduct merchantProduct) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.save(merchantProduct);
			session.getTransaction().commit();
		}
	}

	public List<MerchantProduct> findByMerchantId(int id) {
		try (Session session = sessionFactory.openSession()) {
			@SuppressWarnings("unchecked")
			Query<MerchantProduct> query = session.createQuery("from MerchantProduct where merchant.id=:id");
			query.setParameter("id", id);
			return query.list();
		}
	}

	public List<MerchantProduct> findByProductId(int id) {
		try (Session session = sessionFactory.openSession()) {
			@SuppressWarnings("unchecked")
			Query<MerchantProduct> query = session.createQuery("from MerchantProduct where product.id=:id");
			query.setParameter("id", id);
			return query.list();
		}
	}
}
