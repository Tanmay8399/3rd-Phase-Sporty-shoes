package com.sportyshoes.web.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sportyshoes.web.model.Cart;
import com.sportyshoes.web.model.OrderDetails;
import com.sportyshoes.web.model.Orders;

@Repository
public class OrdersDaoImpl extends JdbcDaoSupport implements OrdersDao {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	OrderDetailsDao orderDetailsDao;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public List<Orders> getAllOrders() {
		List<Orders> allOrders = new ArrayList<Orders>();
		String sql = "SELECT * FROM orders";
		List<Map<String, Object>> allOrdersData = getJdbcTemplate().queryForList(sql);
		for(Map<String, Object> order : allOrdersData) {
			Orders ord = new Orders();
			ord.setId((Integer)order.get("id"));
			ord.setLoginid((String)order.get("loginid"));
			ord.setOrderdate((Date)order.get("orderdate"));
			allOrders.add(ord);
		}
		return allOrders;
	}

	@Override
	public int placeOrder(String lid) {
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentTime = calendar.getTime();

		List<Orders> allOrders = getAllOrders();
		int ordid = 1;
		for(Orders orditem : allOrders) {
			ordid++;
		}		
		String sql = "insert into orders values(?,?,?)";
		int val = getJdbcTemplate().update(sql, new Object[] {ordid, lid, currentTime});
		
		List<OrderDetails> allorderdetails = orderDetailsDao.getAllOrderDetails();
		int orddtlid = 1;
		for(OrderDetails orddtl : allorderdetails) {
			orddtlid++;
		}

		List<Cart> cartitems = cartDao.getUserCartItems(lid);
		for(Cart bycartitem : cartitems) {
			orddtlid++;

			String orsql = "insert into orderdetails values(?,?,?,?,?,?,?,?,?,?)";
			int oval = getJdbcTemplate().update(orsql, new Object[] {orddtlid, lid, bycartitem.getId(), ordid, bycartitem.getProductid(), bycartitem.getBrandname(), bycartitem.getGender(), bycartitem.getSize(), bycartitem.getPrice(), currentTime});
		}
		
		String delcartsql = "delete from usercart where loginid=?";
		int dval = getJdbcTemplate().update(delcartsql, new Object[] {lid});
		
		return ordid;
	}

	@Override
	public int getUserOrderTotal(int ordid) {
		String sql = "select * from orderdetails where orderid = ?";
		List<Map<String, Object>> userorderData = getJdbcTemplate().queryForList(sql,ordid);
		int userordertotal = 0;
		for(Map<String, Object> ord : userorderData) {
			userordertotal = userordertotal +(Integer)ord.get("price");  
		}
		return userordertotal;
	}
}

