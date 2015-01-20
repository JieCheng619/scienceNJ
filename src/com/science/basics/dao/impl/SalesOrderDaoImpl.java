package com.science.basics.dao.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.science.basics.dao.SalesOrderDao;
import com.science.basics.domain.Product;
import com.science.basics.domain.SaleItem;
import com.science.basics.domain.SalesOrder;
import com.science.hibernateUtil.HibernateUtil;

public class SalesOrderDaoImpl implements SalesOrderDao {
	private HibernateUtil hibernateUtil;
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}
	@Resource
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	@Override
	public boolean save(SalesOrder order) {
		boolean flag = false;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(order);
			Set<SaleItem> sis = order.getSaleItems();
			for(SaleItem si:sis){
				session.save(si);
			}
			transaction.commit();
			flag = true;
		}catch(HibernateException he){
			flag = false;
			he.printStackTrace();
			hibernateUtil.rollbackTransaction(transaction);
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}finally{
			hibernateUtil.closeSession(session);
		}
		return flag;
	}


	@Override
	public List<SalesOrder> findAll() {
		String hql = "from SalesOrder";
		return hibernateUtil.exeQuery(hql);
	}

	@Override
	public boolean verify(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();

			SalesOrder o=(SalesOrder)session.load(SalesOrder.class, id);
			//true±Ì æ“—…Û∫À
			o.setStatus(true);

			transaction.commit();
			flag = true;
		}catch(HibernateException he){
			flag = false;
			he.printStackTrace();
			hibernateUtil.rollbackTransaction(transaction);
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}finally{
			hibernateUtil.closeSession(session);
		}
		return flag;
	}
	@Override
	public boolean delete(SalesOrder order) {
		boolean flag = false;
		Transaction transaction = null;
		Session session = null ;
		try{
			session = hibernateUtil.getSession();
			transaction  = session.beginTransaction();
			SalesOrder o=(SalesOrder)session.load(SalesOrder.class, order.getId());
			o.setNullify(false);
			transaction.commit();
			flag = true;
		}catch(HibernateException he){
			he.printStackTrace();
			hibernateUtil.rollbackTransaction(transaction);
			flag= false;
		}finally{
			hibernateUtil.closeSession(session);
		}
		return flag;
	}
	@Override
	public List<SalesOrder> findALL(String id) {
		String hql = "from SalesOrder where id="+id;
		return hibernateUtil.exeQuery(hql);
	}
	@Override
	public List<SalesOrder> findALL(int start, int end) {
		String hql = "from SalesOrder";
		return hibernateUtil.exeQueryPage(hql, start, end);
	}
	@Override
	public List<SalesOrder> findByOderCode(String orderCode) {
		String hql = "from SalesOrder where orderCode='"+orderCode+"'";
		return hibernateUtil.exeQuery(hql);
	}
	@Override
	public List<SalesOrder> findByOderUser(String username)
			throws IndexOutOfBoundsException {
		String hql = "from SalesOrder where user='"+username+"'";
		return hibernateUtil.exeQuery(hql);
	}

}
