package com.science.basics.service;

import java.util.List;

import com.science.basics.domain.Category;
import com.science.hibernateUtil.MyException;

public interface CategoryService {
	 /**��ӷ���*/
	 public boolean add(Category category);
	 /**��Ӹ�����*/
	 public boolean addTopCategory(String text,String description);
	 /**����ӷ���*/
	 public boolean addChileCategory(int parent,Category category);
	 /**ɾ������*/
	 /**ɾ������*/
	public boolean deleteById(int id,int pid) throws MyException;
	 /**�޸ķ���*/
	 public boolean update(Category category);
	 /**��ѯ���з�����Ϣ*/
	 public List<Category> findAll();
	 /**��ѯ���еĸ�������Ϣ*/
	 public List<Category> findTopAll();
}
