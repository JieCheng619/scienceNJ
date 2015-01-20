package com.science.basics.dao;

import java.util.List;

import com.science.basics.domain.Category;
import com.science.basics.domain.User;
import com.science.hibernateUtil.MyException;
/**
 * 产品分类的Dao接口
 * @author cheng
 *
 */
public interface CategoryDao {
	 /**保存分类*/
	 public boolean save(Category category);
	 /**删除分类*/
	 public boolean delete(int id);
	 /**修改分类*/
	 public boolean update(Category category);
	 /**查询所有分类信息*/
	 public List<Category> findAll();
	 /**保存子节点*/
	 public boolean saveChildCategory(int parent,Category category);
	 /**根据pid来查询*/
	 public List<Category> findByParent(int pid);
	 /**根分类的信息*/
	 public List<Category> findTopCategory();
		/**根据id修改为叶子
		 * @throws QshException */
		public boolean updateCategoryToLeaf(int id) throws MyException;
}
