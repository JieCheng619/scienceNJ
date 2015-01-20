package com.science.basics.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.science.basics.dao.ProductDao;
import com.science.basics.domain.Product;
import com.science.basics.domain.User;
import com.science.hibernateUtil.HibernateUtil;

public class ProductDaoImpl implements ProductDao {
	 private HibernateUtil hibernateUtil;
		public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}
	@Resource
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	@Override
	public Product save(Product product) {
		Product p = null;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			p=(Product)session.load(Product.class, session.save(product));
			transaction.commit();
		}catch(HibernateException he){
			he.printStackTrace();
			hibernateUtil.rollbackTransaction(transaction);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			hibernateUtil.closeSession(session);
		}
		return p;
	}

	@Override
	public boolean delete(int id) {
		String hql = "delete from Product where id="+id;
		return hibernateUtil.exeDelete(hql);
	}

	@Override
	public boolean update(Product product) {
		 boolean flag = false;
		 Transaction transaction = null;
		 Session session = null ;
		 try{
			 session = hibernateUtil.getSession();
			 transaction  = session.beginTransaction();
			 Product p=(Product)session.load(Product.class, product.getId());
				if(null != product.getName()){
					p.setName(product.getName());
				}
				if(null != product.getDescr()){
					p.setDescr(product.getDescr());
				}
				if(product.getNormaPrice() != 0){
					p.setNormaPrice(product.getNormaPrice());
				}
				if(product.getMemberPrice() != 0){
					p.setMemberPrice(product.getMemberPrice());
				}
				if(product.getCategory() != null){
					p.setCategory(product.getCategory());
				}
				if(product.getPhoto() != null){
					p.setPhoto(product.getPhoto());
				}
				
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
	public List<Product> findAll() {
		 String hql = "from Product";
		 return hibernateUtil.exeQuery(hql);
	}

	@Override
	public List<Product> findByKeyword(String keyword) {
		String hql ="";
		if(null!=keyword){
			hql ="from Product where name like '%"+keyword+"%' or descr like '%"+keyword+"%'";
		}
		return hibernateUtil.exeQuery(hql);
	}

}
