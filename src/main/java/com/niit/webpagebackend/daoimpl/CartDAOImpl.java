package com.niit.webpagebackend.daoimpl;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.webpagebackend.dao.CartDAO;
import com.niit.webpagebackend.dao.CustomerOrderDAO;
import com.niit.webpagebackend.model.Cart;


@Repository
@Transactional
public class CartDAOImpl implements CartDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CustomerOrderDAO customerOrderDAO;

	@Autowired
	private CartDAO cartDAO;

	public CartDAO getCartDAO() {
		return cartDAO;
	}

	public void setCartdao(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Cart getCartByCartId(int cartId) {
		Session session = sessionFactory.openSession();
		Cart cart = (Cart) session.get(Cart.class, cartId);
		session.close();
		return cart;
	}

	public Cart validate(int cartId) throws IOException {
		Cart cart = getCartByCartId(cartId);
		System.out.println("emptycart1");
		if (cart == null || cart.getCartItems().size() == 0) {
			throw new IOException(cartId + "");
		}
		System.out.println("emptycart2");
		update(cart);
		return cart;
	}

	public void update(Cart cart) {
		System.out.println("cart1");
		int cartId = cart.getCartId();
		System.out.println("carttot1");
		int grandTotal = customerOrderDAO.getCustomerOrderGrandTotal(cartId);
		cart.setTotalprice(grandTotal);

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
	}
}