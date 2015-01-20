package com.science.basics.dao;

import java.util.List;

import com.science.basics.domain.Product;

public interface ProductDao {
	 /**������Ʒ*/
	 public Product save(Product product);
	 /**ɾ����Ʒ*/
	public boolean delete(int id);
	 /**�޸���Ʒ*/
	 public boolean update(Product product);
	 /**��ѯ������Ʒ*/
	 public List<Product> findAll();
	 /**��ѯ�ؼ���*/
	 public List<Product> findByKeyword(String keyword);
}
