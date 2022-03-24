package com.sportyshoes.web.model;

import java.util.Date;

public class OrderDetails {
	private int id;
	private String loginid;
	private int ciid;
	private int orderid;
	private int productid;
	private String brandname;
	private String gender;
	private int size;
	private int price;
	private Date orderdate;
	
	public OrderDetails() {
	}

	public OrderDetails(int id, String loginid, int ciid, int orderid, int productid, String brandname, String gender,
			int size, int price, Date orderdate) {
		this.id = id;
		this.loginid = loginid;
		this.ciid = ciid;
		this.orderid = orderid;
		this.productid = productid;
		this.brandname = brandname;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.orderdate = orderdate;
	}
	
	public OrderDetails(String loginid, int ciid, int orderid, int productid, String brandname, String gender,
			int size, int price, Date orderdate) {
		this.loginid = loginid;
		this.ciid = ciid;
		this.orderid = orderid;
		this.productid = productid;
		this.brandname = brandname;
		this.gender = gender;
		this.size = size;
		this.price = price;
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

	public int getCiid() {
		return ciid;
	}

	public void setCiid(int ciid) {
		this.ciid = ciid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", loginid=" + loginid + ", ciid=" + ciid + ", orderid=" + orderid
				+ ", productid=" + productid + ", brandname=" + brandname + ", gender=" + gender + ", size=" + size
				+ ", price=" + price + ", orderdate=" + orderdate + "]";
	}

}
