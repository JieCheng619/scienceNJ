package com.science.basics.dao;

import java.util.List;

import com.science.basics.domain.User;

public interface UserDao {
	 /**用户注册*/
	 public User save(User user);
	 /**删除用户*/
	 public boolean delete(String id);
	 /**修改注册*/
	 public boolean update(User user);
	 /**查询所有注册*/
	 public List<User> findAll();
	 /**用户登陆*/
	 public User login(String username,String password);
	 /**检查是否重复*/
	 public boolean checkUserName(String username);
	 /**查询所有注册*/
	 public List<User> findAll(int start,int end);
}
