package com.niit.webpagebackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.webpagebackend.dao.SupplierDAO;
import com.niit.webpagebackend.model.Supplier;

@SuppressWarnings("deprecation")
@Transactional
@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	

	@Transactional
	public Supplier get(int id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);

	}

	@Transactional
	public Supplier validate(int id, String password) {
		System.out.println("inside validate");
		String hql = "from Supplier where id ='" + id + "'  and password='" + password + "'";
		System.out.println("After hql");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("after query");
		return (Supplier) query.uniqueResult();

	}

	@Transactional
	public boolean save(Supplier supplier) {

	System.out.println("Save Supplier");
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return false;
	}
		
	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public List<Supplier> list() {
		String hql = "from Supplier";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

	
	@Transactional
	public void delete(int supplier_id) {
		
		Supplier supplier = new Supplier();
		supplier.setSupplier_id(supplier_id);
		sessionFactory.getCurrentSession().delete(supplier);
		
	}


	



}
