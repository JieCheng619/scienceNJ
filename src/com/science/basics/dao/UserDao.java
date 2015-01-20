package com.science.basics.dao;

import java.util.List;

import com.science.basics.domain.User;

public interface UserDao {
	 /**�û�ע��*/
	 public User save(User user);
	 /**ɾ���û�*/
	 public boolean delete(String id);
	 /**�޸�ע��*/
	 public boolean update(User user);
	 /**��ѯ����ע��*/
	 public List<User> findAll();
	 /**�û���½*/
	 public User login(String username,String password);
	 /**����Ƿ��ظ�*/
	 public boolean checkUserName(String username);
	 /**��ѯ����ע��*/
	 public List<User> findAll(int start,int end);
}
