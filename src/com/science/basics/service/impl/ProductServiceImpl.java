package com.science.basics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.science.basics.dao.ProductDao;
import com.science.basics.domain.Product;
import com.science.basics.service.ProductService;

public class ProductServiceImpl implements ProductService {
   private ProductDao productDao;
   
	public ProductDao getProductDao() {
	return productDao;
}
@Resource
public void setProductDao(ProductDao productDao) {
	this.productDao = productDao;
}

	@Override
	public Product add(Product product) {
		return productDao.save(product);
	}

	@Override
	public boolean remove(int[] ids) {
		boolean flag = false;
		for(int i=0;i<ids.length;i++){
			flag = productDao.delete(ids[i]);
		}
		return flag;
	}

	@Override
	public boolean modify(Product product) {
		return productDao.update(product);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public List<Product> findByKeyword(String keyword) {
		return productDao.findByKeyword(keyword);
	}

}
