package com.sportyshoes.web.service;

import java.util.Date;
import java.util.List;

import com.sportyshoes.web.model.OrderDetails;

public interface OrderDetailsService {
	public List<OrderDetails> getUserOrderDetails(int ordid);
	public List<OrderDetails> getPurchaseReport(String rbrand, Date rdate);
}
