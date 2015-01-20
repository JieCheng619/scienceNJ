package com.science.basics.service;

import java.util.List;

import com.science.basics.domain.Category;
import com.science.basics.domain.Product;
import com.science.hibernateUtil.MyException;

/**
 * 商品的服务类
 * @author cheng
 *
 */
public interface ProductService {
	 /**新增商品*/
	 public Product add(Product product);
	 /**删除商品*/
	public boolean remove(int[] ids);
	 /**修改商品*/
	 public boolean modify(Product product);
	 /**查询所有商品*/
	 public List<Product> findAll();
	 /**查询关键字*/
	 public List<Product> findByKeyword(String keyword);
}
