package com.science.basics.service;

import java.util.List;

import com.science.basics.domain.SalesOrder;

public interface SalesOrderService {
	/**���涩��*/
	public boolean add(SalesOrder salesOrder);
	/**����*/
	public boolean remove(SalesOrder salesOrder);
	/**��ѯ����*/
	public List<SalesOrder> findAll();
	/**����id��ѯ*/
	public List<SalesOrder> findAll(String id);
	/**��ҳ��ѯ����*/
	public List<SalesOrder> findAll(int start,int end);
	/**���ݶ����������ѯ*/
	public List<SalesOrder> findByOderCode(String orderCode);
	/**��˶���*/
	public boolean verify(int id);
	/**�����û�����ѯ*/
	public List<SalesOrder> findByOderUser(String username)throws IndexOutOfBoundsException;
	

}
