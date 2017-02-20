package com.niit.webpagebackend.dao;

import com.niit.webpagebackend.model.Cart;
import com.niit.webpagebackend.model.CartItem;

public interface CartItemDAO {

	void addCartItem(CartItem cartItem);
	void removeCartItem(int cartitemid);
	void removeAllCartItems(Cart cart);
}