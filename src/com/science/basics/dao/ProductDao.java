package com.science.basics.dao;

import java.util.List;

import com.science.basics.domain.Product;

public interface ProductDao {
	 /**新增商品*/
	 public Product save(Product product);
	 /**删除商品*/
	public boolean delete(int id);
	 /**修改商品*/
	 public boolean update(Product product);
	 /**查询所有商品*/
	 public List<Product> findAll();
	 /**查询关键字*/
	 public List<Product> findByKeyword(String keyword);
}
