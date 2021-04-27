package com.demo.merchantapp.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.demo.merchantapp.dao.Merchant;

@Repository
public class MerchantRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(MerchantRepository.class);

	private SessionFactory sessionFactory;

	public MerchantRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Merchant merchant) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.save(merchant);
			session.getTransaction().commit();
		}

	}

	public void update(Merchant merchant) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.update(merchant);
			session.getTransaction().commit();
		}
	}

	public Merchant findById(int id) {
		try (Session session = sessionFactory.openSession()) {
			@SuppressWarnings("unchecked")
			Query<Merchant> query = session.createQuery("from Merchant where id=:id");
			query.setParameter("id", id);
			return query.uniqueResult();
		}
	}

	public void delete(int id) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Merchant merchant = session.load(Merchant.class, id);
			session.delete(merchant);
			session.getTransaction().commit();
		}
	}
}
