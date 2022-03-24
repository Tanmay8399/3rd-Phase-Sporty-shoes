package com.sportyshoes.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.sportyshoes.web.model.Products;

@Repository
public class ProductsDaoImpl extends JdbcDaoSupport implements ProductsDao{

	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public List<Products> getAllProducts() {
		List<Products> products = new ArrayList<Products>();
		String sql = "select * from products";
		List<Map<String, Object>> productsData = getJdbcTemplate().queryForList(sql);
		for(Map<String, Object> prod : productsData) {
			Products product = new Products();
			product.setId((Integer)prod.get("id"));
			product.setBrandname((String)prod.get("brandname"));
			product.setGender((String)prod.get("gender"));
			product.setSize((Integer)prod.get("size"));
			product.setPrice((Integer)prod.get("price"));
			products.add(product);
		}
		return products;
	}

	@Override
	public Products getProduct(int pid) {
		List<Products> product = getAllProducts();
		Products prodData = new Products();
		for(Products prod : product) {
			int epid = prod.getId();
			if(epid == pid) {
				prodData.setId(pid);
				prodData.setBrandname(prod.getBrandname());
				prodData.setGender(prod.getGender());
				prodData.setSize(prod.getSize());
				prodData.setPrice(prod.getPrice());
			}
		}
		return prodData;
	}

	@Override
	public boolean updateProduct(int pid, String bn, String gd, int sz, int pr) {
		boolean isProductUpdated = false;
		String sql = "update products set brandname = ?, gender = ?, size = ?, price = ? where id=?";
		int val = getJdbcTemplate().update(sql, bn, gd, sz, pr, pid);
		if(val>0)
			isProductUpdated=true;
		return isProductUpdated;
		
	}

	@Override
	public boolean addProduct(Products product) {
		boolean flag = false;
		List<Products> getprod = getAllProducts();
		int i = 1;
		for(Products gprod : getprod) {
			i++;
		}
		String sql = "insert into products values(?,?,?,?,?)";
		int val =  getJdbcTemplate().update(sql, new Object[] {i, product.getBrandname(), product.getGender(), product.getSize(), product.getPrice()});
		if(val>0)
			flag = true;
		return flag;
	}
}

