package com.science.basics.service;

import java.util.List;

import com.science.basics.domain.Category;
import com.science.basics.domain.Product;
import com.science.hibernateUtil.MyException;

/**
 * ��Ʒ�ķ�����
 * @author cheng
 *
 */
public interface ProductService {
	 /**������Ʒ*/
	 public Product add(Product product);
	 /**ɾ����Ʒ*/
	public boolean remove(int[] ids);
	 /**�޸���Ʒ*/
	 public boolean modify(Product product);
	 /**��ѯ������Ʒ*/
	 public List<Product> findAll();
	 /**��ѯ�ؼ���*/
	 public List<Product> findByKeyword(String keyword);
}
