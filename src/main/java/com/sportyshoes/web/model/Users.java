package com.sportyshoes.web.model;

public class Users {
	private String loginid;
	private String password;
	private String email;
	private String phone;
	
	public Users() {
		//
	}

	public Users(String loginid, String password) {
		this.loginid = loginid;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Users [loginid=" + loginid + ", password=" + password + ", email=" + email + ", phone=" + phone + "]";
	}
}

