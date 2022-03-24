package com.sportyshoes.web.model;

public class Products {
	private int id;
	private String brandname;
	private String gender;
	private int size;
	private int price;
	
	public Products() {
		//System.out.println("products constructor");
	}

	public Products(int id, String brandname, String gender, int size, int price) {
		this.id = id;
		this.brandname = brandname;
		this.gender = gender;
		this.size = size;
		this.price = price;
	}

	public Products(String brandname, String gender, int size, int price) {
		this.brandname = brandname;
		this.gender = gender;
		this.size = size;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Products [id=" + id + ", brandname=" + brandname + ", gender=" + gender + ", size=" + size + ", price="
				+ price + "]";
	}
	
}

