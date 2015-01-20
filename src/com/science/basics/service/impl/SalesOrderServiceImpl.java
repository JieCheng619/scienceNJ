package com.science.basics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.science.basics.dao.SalesOrderDao;
import com.science.basics.domain.SalesOrder;
import com.science.basics.service.SalesOrderService;

public class SalesOrderServiceImpl implements SalesOrderService {
	private SalesOrderDao salesOrderDao;

	public SalesOrderDao getSalesOrderDao() {
		return salesOrderDao;
	}
	@Resource
	public void setSalesOrderDao(SalesOrderDao salesOrderDao) {
		this.salesOrderDao = salesOrderDao;
	}

	@Override
	public boolean add(SalesOrder salesOrder) {
		return salesOrderDao.save(salesOrder);
	}

	@Override
	public boolean remove(SalesOrder salesOrder) {
		return salesOrderDao.delete(salesOrder);
	}

	@Override
	public List<SalesOrder> findAll() {
		return salesOrderDao.findAll();
	}

	@Override
	public boolean verify(int id) {
		return salesOrderDao.verify(id);
	}
	@Override
	public List<SalesOrder> findAll(String id) {
		return salesOrderDao.findALL(id);
	}
	@Override
	public List<SalesOrder> findAll(int start,int end) {
		return salesOrderDao.findALL(start, end);
	}
	@Override
	public List<SalesOrder> findByOderCode(String orderCode) {
		return salesOrderDao.findByOderCode(orderCode);
	}
	@Override
	public List<SalesOrder> findByOderUser(String username)
			throws IndexOutOfBoundsException {
		return  salesOrderDao.findByOderUser(username);
	}

}
