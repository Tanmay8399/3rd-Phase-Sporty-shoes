package com.sportyshoes.web.dao;

import java.util.Date;
import java.util.List;

import com.sportyshoes.web.model.OrderDetails;

public interface OrderDetailsDao {
	public List<OrderDetails> getAllOrderDetails();
	public List<OrderDetails> getUserOrderDetails(int ordid);
	public List<OrderDetails> getPurchaseReport(String rbrand, Date rdate);

}

