package com.hcl.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hcl.hibernate.model.Product;
import com.hcl.hibernate.util.HibernateUtil;


public class ProductDao {

	public void saveProduct(Product products) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.save(products);

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
