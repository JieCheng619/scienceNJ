package com.science.basics.service;

import java.util.List;

import com.science.basics.domain.SalesOrder;

public interface SalesOrderService {
	/**保存订单*/
	public boolean add(SalesOrder salesOrder);
	/**作废*/
	public boolean remove(SalesOrder salesOrder);
	/**查询所有*/
	public List<SalesOrder> findAll();
	/**根据id查询*/
	public List<SalesOrder> findAll(String id);
	/**分页查询所有*/
	public List<SalesOrder> findAll(int start,int end);
	/**根据定单编号来查询*/
	public List<SalesOrder> findByOderCode(String orderCode);
	/**审核订单*/
	public boolean verify(int id);
	/**根据用户来查询*/
	public List<SalesOrder> findByOderUser(String username)throws IndexOutOfBoundsException;
	

}
