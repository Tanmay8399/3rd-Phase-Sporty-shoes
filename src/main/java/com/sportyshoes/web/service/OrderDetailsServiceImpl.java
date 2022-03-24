package com.sportyshoes.web.service;

public interface OrdersService {
	public int placeOrder(String lid);
	public int getUserOrderTotal(int ordid);
}

