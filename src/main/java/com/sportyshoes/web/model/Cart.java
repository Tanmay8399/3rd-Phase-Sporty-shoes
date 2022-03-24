package com.sportyshoes.web.model;

public class Cart {
	private int id;
	private int productid;
	private String loginid;
	private int price;
	private String brandname;
	private String gender;
	private int size;
	
	public Cart() {
	}
	
	public Cart(int id, int productid, String loginid, int price, String brandname, String gender, int size) {
		this.id = id;
		this.productid = productid;
		this.loginid = loginid;
		this.price = price;
		this.brandname = brandname;
		this.gender = gender;
		this.size = size;
	}

	public Cart(int productid, String loginid, int price, String brandname, String gender, int size) {
		this.productid = productid;
		this.loginid = loginid;
		this.price = price;
		this.brandname = brandname;
		this.gender = gender;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	@Override
	public String toString() {
		return "Cart [id=" + id + ", productid=" + productid + ", loginid=" + loginid + ", price=" + price
				+ ", brandname=" + brandname + ", gender=" + gender + ", size=" + size + "]";
	}

	
}
