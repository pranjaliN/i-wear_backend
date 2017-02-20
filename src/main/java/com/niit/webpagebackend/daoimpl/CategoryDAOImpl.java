package com.niit.webpagebackend.daoimpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.webpagebackend.dao.CategoryDAO;
import com.niit.webpagebackend.model.Category;

@SuppressWarnings("deprecation")
@Transactional
@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Category> list() {

		String hql = "from Category";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

	@Transactional
	public Category get(int id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);

	}

	@Transactional
	public Category validate(String id, String password) {
		System.out.println("inside validate");
		String hql = "from Category where id ='" + id + "'  and password='" + password + "'";
		System.out.println("After hql");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("after query");
		return (Category) query.uniqueResult();

	}

	@Transactional
	public boolean save(Category category) {

	System.out.println("Save Category");
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return false;
	}
		
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	@Transactional
	public void delete(int category_id) {
		Category category = new Category();
		category.setCategory_id(category_id);
		sessionFactory.getCurrentSession().delete(category);

	}

	
	
	

}
