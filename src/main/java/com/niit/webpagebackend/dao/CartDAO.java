package com.niit.webpagebackend.dao;

import java.io.IOException;

import com.niit.webpagebackend.model.Cart;

public interface CartDAO {

	Cart getCartByCartId(int cartId);
	Cart validate(int cartId) throws IOException;
	void update(Cart cart);
}