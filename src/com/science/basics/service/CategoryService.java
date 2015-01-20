package com.science.basics.service;

import java.util.List;

import com.science.basics.domain.Category;
import com.science.hibernateUtil.MyException;

public interface CategoryService {
	 /**添加分类*/
	 public boolean add(Category category);
	 /**添加根分类*/
	 public boolean addTopCategory(String text,String description);
	 /**添加子分类*/
	 public boolean addChileCategory(int parent,Category category);
	 /**删除分类*/
	 /**删除分类*/
	public boolean deleteById(int id,int pid) throws MyException;
	 /**修改分类*/
	 public boolean update(Category category);
	 /**查询所有分类信息*/
	 public List<Category> findAll();
	 /**查询所有的根分类信息*/
	 public List<Category> findTopAll();
}
