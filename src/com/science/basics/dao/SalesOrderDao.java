package com.science.basics.dao;

import java.util.List;

import com.science.basics.domain.SalesOrder;

/**
 * 订单的dao
 * @author cheng
 *
 */
public interface SalesOrderDao {
	/**保存订单*/
	public boolean save(SalesOrder order);
	/**作废*/
	public boolean delete(SalesOrder order);
	/**查询所有*/
	public List<SalesOrder> findAll();
	/**根据id查询*/
	public List<SalesOrder> findALL(String id);
	/**分页查询所有*/
	public List<SalesOrder> findALL(int start, int end);
	/**根据定单编号来查询*/
	public List<SalesOrder> findByOderCode(String orderCode);
	/**审核订单*/
	public boolean verify(int id);
	/**根据用户来查询*/
	public List<SalesOrder> findByOderUser(String username)throws IndexOutOfBoundsException;

}
