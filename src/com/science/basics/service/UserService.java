package com.science.basics.service;

import java.util.List;

import com.science.basics.domain.User;
import com.science.hibernateUtil.MyException;

public interface UserService {
 /**�û�ע��
 * @throws MyException */
 public User register(User user)throws MyException;
 /**ɾ���û�*/
 public boolean remove(String[] ids);
 /**�޸�ע��*/
 public boolean modify(User user);
 /**��ѯ����ע��*/
 public List<User> getPersons();
 /**�û���½*/
 public User login(String username,String password);	
 /**���*/
 public boolean checkUserName(String username);
 /**��ҳ��ʾ�����û�*/
	public List<User> getPersons(int start, int end);
	/** ��ѯ����*/
	public int getCount();
}
