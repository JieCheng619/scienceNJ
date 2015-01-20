package com.science.basics.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import com.science.basics.dao.UserDao;
import com.science.basics.domain.User;
import com.science.hibernateUtil.HibernateUtil;

public class UserDaoImpl implements UserDao {
   private HibernateUtil hibernateUtil;
	public HibernateUtil getHibernateUtil() {
	return hibernateUtil;
}
@Resource
public void setHibernateUtil(HibernateUtil hibernateUtil) {
	this.hibernateUtil = hibernateUtil;
}

	@Override
	public User save(User user) {
		return hibernateUtil.save(user);
	}

	@Override
	public boolean delete(String id) {
		String hql = "delete from User where id="+id;
		return hibernateUtil.exeDelete(hql);
	}

	@Override
	public boolean update(User users) {
		return hibernateUtil.update(users);
	}

	@Override
	public List<User> findAll() {
	     String hql = "from User";
		return hibernateUtil.exeQuery(hql);
	}

	@Override
	public User login(String username, String password) {
	  User u = null;
      String hql ="from User where userName = '"+username+"' and password='" +password+"'";
	  u = (User)hibernateUtil.exeQuery(hql).get(0);
      return u;
	}
	@Override
	public boolean checkUserName(String username) {
		String hql = "from User u where u.userName='"+username+"'";
		if(hibernateUtil.exeQuery(hql).size() > 0){
			return true;
		}
		return false;
	}
	@Override
	public List<User> findAll(int start, int end) {
		 String hql = "from User";
		return hibernateUtil.exeQueryPage(hql, start, end);
	}

}
