package com.niit.webpagebackend.dao;



import java.util.List;

import com.niit.webpagebackend.model.Supplier;




public interface SupplierDAO {

	public List< Supplier> list();

	public  Supplier get(int supplier_id);

	public boolean save( Supplier supplier);

	public boolean update( Supplier supplier);
	
	public void delete(int  supplier_id);
}
