package com.science.hibernateUtil;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.science.basics.domain.User;

public class HibernateUtil {
 private  SessionFactory sessionFactory;
 @Resource
 public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
 public SessionFactory getSessionFactory() {
	return sessionFactory;
}


 /**
  * �ؽ�sessionFactory
  */
 public  void rebuildSessionFactory(){
	 synchronized(sessionFactory){
		 sessionFactory = getSessionFactory();
	 }
 }
 /**
  * ��ȡsession����
  * @return
  */
 public  Session getSession(){
	 Session session = null;
	 try{
	 session = sessionFactory.openSession();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 return session;
 }
 
 public  void close(){
	 try{
		 sessionFactory.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
 }
 
 /**
  * �ر�session
  * @param session
  */
 public  void closeSession(Session session){
	 try{
		if(null!=session){
			session.close();
		}
	 }catch(Exception e){
		 e.printStackTrace();
	 }
 }
 /**
  * �ع�����
  */
 public  void rollbackTransaction(Transaction transaction){
	 try{
			if(null!=transaction){
				transaction.rollback();
			}
		 }catch(Exception e){
			 e.printStackTrace();
		 }
 }
 
 /**
  * ���õĲ�ѯ����
  */
 public  List exeQuery(String hql){
	 List list =null;
	 Transaction transaction = null;
	 Session session = null ;
	 try{
		 session = getSession();
		 transaction  = session.beginTransaction();
		 list = session.createQuery(hql).list();
		 transaction.commit();
	 }catch(HibernateException he){
		 he.printStackTrace();
		 rollbackTransaction(transaction);
	 }finally{
		 closeSession(session);
	 }
	 return list;
 }
 /**
  * ��ҳ
  */
 public  List exeQueryPage(String hql,int start,int end){
	 List list =null;
	 Transaction transaction = null;
	 Session session = null ;
	 try{
		 session = getSession();
		 transaction  = session.beginTransaction();
		 list = session.createQuery(hql).setFirstResult(start).setMaxResults(end).list();
		 transaction.commit();
	 }catch(HibernateException he){
		 he.printStackTrace();
		 rollbackTransaction(transaction);
	 }finally{
		 closeSession(session);
	 }
	 return list;
 }
 /**
  * ɾ��
  * @param hql
  * @return
  */
 public  boolean exeDelete(String hql){
	 boolean flag = false;
	 Transaction transaction = null;
	 Session session = null ;
	 try{
		 session = getSession();
		 transaction  = session.beginTransaction();
		session.createQuery(hql).executeUpdate();
		transaction.commit();
		flag = true;
	 }catch(HibernateException he){
		 he.printStackTrace();
		 rollbackTransaction(transaction);
		 flag= false;
	 }finally{
		 closeSession(session);
	 }
	 return flag;
 }
 /**
  * ����
  * @param hql
  * @return
  */
 public  User save(User user){
	 User u = null;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = getSession();
			transaction = session.beginTransaction();
			u=(User)session.load(User.class, session.save(user));
			transaction.commit();
		}catch(HibernateException he){
			he.printStackTrace();
			rollbackTransaction(transaction);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return u;
 }
 /**
  * ����
  */
 public  boolean update(User user){
	 boolean flag = false;
	 Transaction transaction = null;
	 Session session = null ;
	 try{
		 session = getSession();
		 transaction  = session.beginTransaction();
		User u =(User)session.load(User.class, user.getId());
		u.setUserName(user.getUserName());
		u.setPassword(user.getPassword());
		u.setEmail(user.getEmail());
		u.setPhone(user.getPhone());
		u.setSex(true);
		
		transaction.commit();
		flag = true;
	 }catch(HibernateException he){
		 he.printStackTrace();
		 rollbackTransaction(transaction);
		 flag= false;
	 }finally{
		closeSession(session);
	 }
	 return flag;
 }
}
