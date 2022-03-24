package com.sportyshoes.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.sportyshoes.web.model.Users;

@Repository
public class UsersDaoImpl extends JdbcDaoSupport implements UsersDao {

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public List<Users> getAllUsers(){
		List<Users> users = new ArrayList<Users>(); 
		String sql = "select * from users";
		List<Map<String, Object>> usersData = getJdbcTemplate().queryForList(sql);
		for(Map<String, Object> uid : usersData) {
			Users user = new Users();
			user.setLoginid((String)uid.get("loginid"));
			user.setPassword((String)uid.get("password"));
			user.setEmail((String)uid.get("email"));
			user.setPhone((String)uid.get("phone"));
			users.add(user);
		}
		return users;
	}

	@Override
	public boolean validateUser(String u, String p) {
		List<Users> user = getAllUsers();
		Users userData = new Users();
		for(Users uid : user) {
			String un= uid.getLoginid();
			String up= uid.getPassword();
			if(un.equals(u)) {
				if(up.equals(p)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Users getUser(String lid) {
		List<Users> user = getAllUsers();
		Users userData = new Users();
		for(Users uData : user) {
			String elid = uData.getLoginid();
			if(lid.equals(elid)) {
				userData.setLoginid(uData.getLoginid());
				userData.setPassword(uData.getPassword());
				userData.setEmail(uData.getEmail());
				userData.setPhone(uData.getPhone());
			}
		}
		return userData;
	}

	@Override
	public boolean updateUser(String lid, String upw, String uemail, String uphone) {
		boolean isUserUpdated = false;
		String sql = "update users set password = ?, email = ?, phone = ? where loginid=?";
		int val = getJdbcTemplate().update(sql, upw, uemail, uphone, lid);
		if(val>0)
			isUserUpdated=true;
		return isUserUpdated;
	}

	@Override
	public boolean addUser(Users user) {
		boolean flag = false;
		String sql = "insert into users values(?,?,?,?)";
		int val =  getJdbcTemplate().update(sql, new Object[] {user.getLoginid(), user.getPassword(), user.getEmail(), user.getPhone()});
		if(val>0)
			flag = true;
		return flag;
	}
	
}

