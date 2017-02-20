package com.niit.webpagebackend.dao;



import java.util.List;

import com.niit.webpagebackend.model.Category;




public interface CategoryDAO {

	public List<Category> list();

	public Category get(int category_id);

	public boolean save(Category category);

	public boolean update(Category category);
	
	public void delete(int category_id);
}
