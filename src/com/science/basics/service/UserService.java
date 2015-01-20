package com.science.basics.service;

import java.util.List;

import com.science.basics.domain.User;
import com.science.hibernateUtil.MyException;

public interface UserService {
 /**用户注册
 * @throws MyException */
 public User register(User user)throws MyException;
 /**删除用户*/
 public boolean remove(String[] ids);
 /**修改注册*/
 public boolean modify(User user);
 /**查询所有注册*/
 public List<User> getPersons();
 /**用户登陆*/
 public User login(String username,String password);	
 /**检查*/
 public boolean checkUserName(String username);
 /**分页显示所有用户*/
	public List<User> getPersons(int start, int end);
	/** 查询总数*/
	public int getCount();
}
