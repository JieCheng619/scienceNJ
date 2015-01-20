package com.science.basics.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.science.basics.dao.CategoryDao;
import com.science.basics.domain.Category;
import com.science.basics.domain.User;
import com.science.hibernateUtil.HibernateUtil;
import com.science.hibernateUtil.MyException;

public class CategoryDaoImpl implements CategoryDao {
	 private HibernateUtil hibernateUtil;
		public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}
	@Resource
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	@Override
	public boolean save(Category category) {
		boolean flag = false;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(category);
			transaction.commit();
		}catch(HibernateException he){
			he.printStackTrace();
			hibernateUtil.rollbackTransaction(transaction);
			flag = false;
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}finally{
			hibernateUtil.closeSession(session);
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		String hql = "delete from Category where id="+id;
		return hibernateUtil.exeDelete(hql);
	}

	@Override
	public boolean update(Category category) {
		 boolean flag = false;
		 Transaction transaction = null;
		 Session session = null ;
		 try{
			 session = hibernateUtil.getSession();
			 transaction  = session.beginTransaction();
			 Category c =(Category)session.load(Category.class, category.getId());
			 c.setText(category.getText());
			 c.setDescription(category.getDescription());
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
	public List<Category> findAll() {
		 String hql = "from Category";
			return hibernateUtil.exeQuery(hql);
	}
//����ӽڵ�
	public boolean saveChildCategory(int parent,Category category) {
		boolean flag = false;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			//���ø��ڵ㣬���ӽڵ����ó�false
			Category pc = (Category)session.get(Category.class, parent);
			pc.setLeaf(false);
			//�洢�µ�category
			category.setParent(parent);
			flag = this.save(category);
			transaction.commit();
		}catch(HibernateException he){
			he.printStackTrace();
			hibernateUtil.rollbackTransaction(transaction);
			flag = false;
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}finally{
			hibernateUtil.closeSession(session);
		}
		return true;
	}
	@Override
	public List<Category> findByParent(int pid) {
		String hql = "from Category where parent ="+pid;
		return hibernateUtil.exeQuery(hql);
	}
	@Override
	public List<Category> findTopCategory() {
		String hql = "from Category where parent = 0";
		return hibernateUtil.exeQuery(hql);
	}
	public boolean updateCategoryToLeaf(int id) throws MyException{
		// TODO Auto-generated method stub
		boolean flag = false;
		Transaction transaction = null;
		Session session  = null;
		try{
			session = hibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			Category category = (Category)session.load(Category.class, id);
			category.setLeaf(true);
			session.saveOrUpdate(category);
			
			transaction.commit();
			flag = true;
		}catch(ObjectNotFoundException o){
			throw new MyException("���м�¼ȫ��ɾ�����");
		}catch(HibernateException he){
			he.printStackTrace();
			hibernateUtil.rollbackTransaction(transaction);
			flag = false;
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}finally{
			hibernateUtil.closeSession(session);
		}
		return flag;
	}

}
