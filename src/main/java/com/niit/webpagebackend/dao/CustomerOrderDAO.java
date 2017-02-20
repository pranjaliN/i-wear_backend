package com.niit.webpagebackend.dao;

import com.niit.webpagebackend.model.CustomerOrder;

public interface CustomerOrderDAO {

	void addCustomerOrder(CustomerOrder customerOrder);

	int getCustomerOrderGrandTotal(int cartId);
}