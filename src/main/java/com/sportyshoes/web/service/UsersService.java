package com.sportyshoes.web.service;

import java.util.List;

import com.sportyshoes.web.model.Users;

public interface UsersService {
	public List<Users> getAllUsers();
	public boolean validateUser(String u, String p);
	public Users getUser(String lid);public boolean updateUser(String lid, String upw, String uemail, String uphone);
	public boolean addUser(Users user);
}

