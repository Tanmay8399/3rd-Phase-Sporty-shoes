package com.sportyshoes.web.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sportyshoes.web.model.OrderDetails;

@Repository
public class OrderDetailsDaoImpl extends JdbcDaoSupport implements OrderDetailsDao {

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public List<OrderDetails> getAllOrderDetails() {
		List<OrderDetails> allOrderDetails = new ArrayList<OrderDetails>();
		String sql = "SELECT * FROM orderdetails";
		List<Map<String, Object>> allOrderDetailsData = getJdbcTemplate().queryForList(sql);
		for(Map<String, Object> orderdetails : allOrderDetailsData) {
			OrderDetails ordDtl = new OrderDetails();
			ordDtl.setId((Integer)orderdetails.get("id"));
			ordDtl.setLoginid((String)orderdetails.get("loginid"));
			ordDtl.setCiid((Integer)orderdetails.get("ciid"));
			ordDtl.setOrderid((Integer)orderdetails.get("orderid"));
			ordDtl.setProductid((Integer)orderdetails.get("productid"));
			ordDtl.setBrandname((String)orderdetails.get("brandname"));
			ordDtl.setGender((String)orderdetails.get("gender"));
			ordDtl.setSize((Integer)orderdetails.get("size"));
			ordDtl.setPrice((Integer)orderdetails.get("price"));
			ordDtl.setOrderdate((Date)orderdetails.get("orderdate"));
			allOrderDetails.add(ordDtl);
		}
		return allOrderDetails;
	}

	@Override
	public List<OrderDetails> getUserOrderDetails(int ordid) {
		List<OrderDetails> userOrderDetails = new ArrayList<OrderDetails>();
		String sql = "SELECT * FROM orderdetails where orderid=?";
		List<Map<String, Object>> userOrderDetailsData = getJdbcTemplate().queryForList(sql,ordid);
		for(Map<String, Object> orderdetails : userOrderDetailsData) {
			OrderDetails ordDtl = new OrderDetails();
			ordDtl.setId((Integer)orderdetails.get("id"));
			ordDtl.setLoginid((String)orderdetails.get("loginid"));
			ordDtl.setCiid((Integer)orderdetails.get("ciid"));
			ordDtl.setOrderid((Integer)orderdetails.get("orderid"));
			ordDtl.setProductid((Integer)orderdetails.get("productid"));
			ordDtl.setBrandname((String)orderdetails.get("brandname"));
			ordDtl.setGender((String)orderdetails.get("gender"));
			ordDtl.setSize((Integer)orderdetails.get("size"));
			ordDtl.setPrice((Integer)orderdetails.get("price"));
			ordDtl.setOrderdate((Date)orderdetails.get("orderdate"));
			userOrderDetails.add(ordDtl);
		}
		return userOrderDetails;
	}

	@Override
	public List<OrderDetails> getPurchaseReport(String rbrand, Date rdate) {
		List<OrderDetails> userPurchaseDetails = new ArrayList<OrderDetails>();
		String sql = "SELECT * FROM orderdetails where brandname=? and orderdate=?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String, Object>> userPurchaseData = getJdbcTemplate().queryForList(sql,rbrand,rdate);
		for(Map<String, Object> purchasedetails : userPurchaseData) {
			OrderDetails purchaseDtl = new OrderDetails();
			purchaseDtl.setId((Integer)purchasedetails.get("id"));
			purchaseDtl.setLoginid((String)purchasedetails.get("loginid"));
			purchaseDtl.setCiid((Integer)purchasedetails.get("ciid"));
			purchaseDtl.setOrderid((Integer)purchasedetails.get("orderid"));
			purchaseDtl.setProductid((Integer)purchasedetails.get("productid"));
			purchaseDtl.setBrandname((String)purchasedetails.get("brandname"));
			purchaseDtl.setGender((String)purchasedetails.get("gender"));
			purchaseDtl.setSize((Integer)purchasedetails.get("size"));
			purchaseDtl.setPrice((Integer)purchasedetails.get("price"));
			purchaseDtl.setOrderdate((Date)purchasedetails.get("orderdate"));
			userPurchaseDetails.add(purchaseDtl);
		}
		return userPurchaseDetails;
	}
}

