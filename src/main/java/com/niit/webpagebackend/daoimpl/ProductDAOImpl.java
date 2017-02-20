package com.niit.webpagebackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.webpagebackend.dao.ProductDAO;
import com.niit.webpagebackend.model.Category;
import com.niit.webpagebackend.model.Product;
import com.niit.webpagebackend.model.Supplier;


@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void save(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	@Transactional
	public void update(Product product) {
		sessionFactory.getCurrentSession().update(product);
		
	}

	@Transactional
	public void delete(int id) {
		Product ProductToDelete = new Product();
		ProductToDelete.setProductid(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
		
	}

	@Transactional
	public Product get(int productid) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productid);
	}

	
	@Transactional
	public List<Product> list() {
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	@Transactional
	public List<Category> listcatgname() {
		String hql = "Select category_name from Category";
		Query query = sessionFactory.openSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public List<Supplier> listsuplname() {
		String hql = "Select supplier_name from Supplier";
		Query query = sessionFactory.openSession().createQuery(hql);
		return query.list();
	}

}
