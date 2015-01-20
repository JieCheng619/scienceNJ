package com.science.basics.dao;

import java.util.List;

import com.science.basics.domain.Category;
import com.science.basics.domain.User;
import com.science.hibernateUtil.MyException;
/**
 * ��Ʒ�����Dao�ӿ�
 * @author cheng
 *
 */
public interface CategoryDao {
	 /**�������*/
	 public boolean save(Category category);
	 /**ɾ������*/
	 public boolean delete(int id);
	 /**�޸ķ���*/
	 public boolean update(Category category);
	 /**��ѯ���з�����Ϣ*/
	 public List<Category> findAll();
	 /**�����ӽڵ�*/
	 public boolean saveChildCategory(int parent,Category category);
	 /**����pid����ѯ*/
	 public List<Category> findByParent(int pid);
	 /**���������Ϣ*/
	 public List<Category> findTopCategory();
		/**����id�޸�ΪҶ��
		 * @throws QshException */
		public boolean updateCategoryToLeaf(int id) throws MyException;
}
