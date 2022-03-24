package com.sportyshoes.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sportyshoes.web.model.Cart;

@Repository
public class CartDaoImpl extends JdbcDaoSupport implements CartDao {

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public List<Cart> getAllCartItems() {
		List<Cart> allcarts = new ArrayList<Cart>();
		String sql = "select * from usercart";
		List<Map<String, Object>> allcartsData = getJdbcTemplate().queryForList(sql);
		for(Map<String, Object> cart : allcartsData) {
			Cart cartitem = new Cart();
			cartitem.setId((Integer)cart.get("id"));
			cartitem.setProductid((Integer)cart.get("productid"));
			cartitem.setLoginid((String)cart.get("loginid"));
			cartitem.setPrice((Integer)cart.get("price"));
			cartitem.setBrandname((String)cart.get("brandname"));
			cartitem.setGender((String)cart.get("gender"));
			cartitem.setSize((Integer)cart.get("size"));
			allcarts.add(cartitem);
		}
		return allcarts;
	}

	@Override
	public boolean addItemToCart(int pid, String lid, int pr, String bn, String gd, int sz) {
		boolean flag = false;
		List<Cart> getallcartitems = getAllCartItems();
		int i = 1;
		for(Cart countcartitem : getallcartitems) {
			int cartid = countcartitem.getId();
			if(cartid>=i) {
				i=cartid;
				i++;
			}
		}
		String sql = "insert into usercart values(?,?,?,?,?,?,?)";
		int val =getJdbcTemplate().update(sql, new Object[] {i, pid, lid, pr, bn, gd, sz});
		if(val>0)
			flag = true;
		return flag;
	}

	@Override
	public List<Cart> getUserCartItems(String lid) {
		List<Cart> usercartitems = new ArrayList<Cart>();
		String sql = "select * from usercart where loginid = ?";
		List<Map<String, Object>> usercartData = getJdbcTemplate().queryForList(sql,lid);
		for(Map<String, Object> cart : usercartData) {
			//System.out.println(cart.get("id"));
			Cart cartitem = new Cart();
			cartitem.setId((Integer)cart.get("id"));
			cartitem.setProductid((Integer)cart.get("productid"));
			cartitem.setLoginid((String)cart.get("loginid"));
			cartitem.setBrandname((String)cart.get("brandname"));
			cartitem.setGender((String)cart.get("gender"));
			cartitem.setSize((Integer)cart.get("size"));
			cartitem.setPrice((Integer)cart.get("price"));
			usercartitems.add(cartitem);		
		}
		
		return usercartitems;
	}

	@Override
	public int getUserCartTotal(String lid) {
		String sql = "select * from usercart where loginid = ?";
		List<Map<String, Object>> usercartData = getJdbcTemplate().queryForList(sql,lid);
		int usercarttotal = 0;
		for(Map<String, Object> cart : usercartData) {
			usercarttotal = usercarttotal +(Integer)cart.get("price");  
		}
		return usercarttotal;
	}

}

