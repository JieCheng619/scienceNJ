package com.science.basics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.science.basics.dao.CategoryDao;
import com.science.basics.domain.Category;
import com.science.basics.service.CategoryService;
import com.science.hibernateUtil.MyException;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;
    
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
    @Resource
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public boolean add(Category category) {
		return false;
	}


    //添加子节点
	@Override
	public boolean addChileCategory(int parent,Category category) {
		return categoryDao.saveChildCategory(parent, category);
	}
   

	@Override
	public boolean update(Category category) {
		return categoryDao.update(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public List<Category> findTopAll() {
		return categoryDao.findTopCategory();
	}
	//添加根节点
	@Override
	public boolean addTopCategory(String text, String description) {
		Category c = new Category();
		c.setText(text);
		c.setDescription(description);
		c.setParent(0);//父节点的是0
		c.setLeaf(true);//新添加的根节点事叶子
		return categoryDao.save(c);
	}
	private List<Category> findByParent(int pid) {
		return categoryDao.findByParent(pid);
	}
	 //用递归的方式
	@Override
	public boolean deleteById(int id, int pid) throws MyException {
		List<Category> list = this.findByParent(id);
		 if(list.size()>0){
        	for(Category c:list){
        		deleteById(c.getId(),c.getParent());
        	}
        }else{//删除子节点完成，设置父节为叶子
       	 //如果还有兄弟就不改变
       	// System.out.println("num:"+this.findByParent(pid).size());
       	 if(this.findByParent(pid).size()<=1){
       		 try{
       			 this.setCategoryToLeaf(pid);
       		 }catch(MyException qe){
       			 System.out.println(qe);
       		 }
       	 }
        }
		return categoryDao.delete(id);
	}
	/**修改为叶子，为deleteById作用的*/
	private boolean setCategoryToLeaf(int id) throws MyException{
		return categoryDao.updateCategoryToLeaf(id);
	}
}
