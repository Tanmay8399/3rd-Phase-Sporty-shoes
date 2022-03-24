package com.sportyshoes.web.model;

import java.util.Date;

public class Orders {
	private int id;
	private String loginid;
	private Date orderdate;
	
	public Orders() {
		
	}
	
	public Orders(int id, String loginid, Date orderdate) {
		this.id = id;
		this.loginid = loginid;
		this.orderdate = orderdate;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", loginid=" + loginid + ", orderdate=" + orderdate + "]";
	}

}

