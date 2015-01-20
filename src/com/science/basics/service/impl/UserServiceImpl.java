package com.science.basics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.science.basics.dao.UserDao;
import com.science.basics.dao.impl.UserDaoImpl;
import com.science.basics.domain.User;
import com.science.basics.service.UserService;
import com.science.hibernateUtil.MyException;

public class UserServiceImpl implements UserService {
    
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
    @Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User register(User user)throws MyException {
		User u = null;
		if(!checkUserName(user.getUserName())){
			u=userDao.save(user);
		}else{
			throw new MyException("用户名已经存在");
		}
		return u;
	}

	@Override
	public boolean remove(String[] ids) {
		boolean flag = false;
		for(int i=0;i<ids.length;i++){
			flag =  userDao.delete(ids[i]);
		}
		return flag;
	
	}

	@Override
	public boolean modify(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	@Override
	public List<User> getPersons() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User login(String username, String password) {
		return userDao.login(username, password);
	}
	@Override
	public boolean checkUserName(String username) {
		
		return userDao.checkUserName(username);
	}
	@Override
	public List<User> getPersons(int start, int end) {
		return userDao.findAll(start,end);
	}
	@Override
	public int getCount() {
		return this.getPersons().size();
	}

}
