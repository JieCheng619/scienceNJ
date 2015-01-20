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


    //����ӽڵ�
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
	//��Ӹ��ڵ�
	@Override
	public boolean addTopCategory(String text, String description) {
		Category c = new Category();
		c.setText(text);
		c.setDescription(description);
		c.setParent(0);//���ڵ����0
		c.setLeaf(true);//����ӵĸ��ڵ���Ҷ��
		return categoryDao.save(c);
	}
	private List<Category> findByParent(int pid) {
		return categoryDao.findByParent(pid);
	}
	 //�õݹ�ķ�ʽ
	@Override
	public boolean deleteById(int id, int pid) throws MyException {
		List<Category> list = this.findByParent(id);
		 if(list.size()>0){
        	for(Category c:list){
        		deleteById(c.getId(),c.getParent());
        	}
        }else{//ɾ���ӽڵ���ɣ����ø���ΪҶ��
       	 //��������ֵܾͲ��ı�
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
	/**�޸�ΪҶ�ӣ�ΪdeleteById���õ�*/
	private boolean setCategoryToLeaf(int id) throws MyException{
		return categoryDao.updateCategoryToLeaf(id);
	}
}
