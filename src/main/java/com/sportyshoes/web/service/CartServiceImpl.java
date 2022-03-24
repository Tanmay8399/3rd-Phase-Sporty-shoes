package com.sportyshoes.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.web.dao.CartDao;
import com.sportyshoes.web.model.Cart;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDao cartDao;

	@Override
	public List<Cart> getAllCartItems() {
		return cartDao.getAllCartItems();
	}

	@Override
	public boolean addItemToCart(int pid, String lid, int pr, String bn, String gd, int sz) {
		return cartDao.addItemToCart(pid,lid,pr,bn,gd,sz);
	}

	@Override
	public List<Cart> getUserCartItems(String lid) {
		return cartDao.getUserCartItems(lid);
	}

	@Override
	public int getUserCartTotal(String lid) {
		return cartDao.getUserCartTotal(lid);
	}

}
