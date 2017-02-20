package com.niit.webpagebackend.dao;



import java.util.List;

import com.niit.webpagebackend.model.Category;
import com.niit.webpagebackend.model.Product;
import com.niit.webpagebackend.model.Supplier;



public interface ProductDAO {

	public void save(Product product);

	public void update(Product product);

	public void delete(int id);

	public Product get(int productid);

	public List<Product> list();
	
	public List<Category>listcatgname();
	
	public List<Supplier>listsuplname();
}


