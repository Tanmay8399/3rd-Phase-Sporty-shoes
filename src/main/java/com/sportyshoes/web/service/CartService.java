package com.sportyshoes.web.service;

import java.util.List;

import com.sportyshoes.web.model.Cart;

public interface CartService {
	public List<Cart> getAllCartItems();
	public boolean addItemToCart(int pid, String lid, int pr, String bn, String gd, int sz);
	public List<Cart> getUserCartItems(String lid);
	public int getUserCartTotal(String lid);
}
