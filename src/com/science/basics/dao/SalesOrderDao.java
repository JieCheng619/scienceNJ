package com.science.basics.dao;

import java.util.List;

import com.science.basics.domain.SalesOrder;

/**
 * ������dao
 * @author cheng
 *
 */
public interface SalesOrderDao {
	/**���涩��*/
	public boolean save(SalesOrder order);
	/**����*/
	public boolean delete(SalesOrder order);
	/**��ѯ����*/
	public List<SalesOrder> findAll();
	/**����id��ѯ*/
	public List<SalesOrder> findALL(String id);
	/**��ҳ��ѯ����*/
	public List<SalesOrder> findALL(int start, int end);
	/**���ݶ����������ѯ*/
	public List<SalesOrder> findByOderCode(String orderCode);
	/**��˶���*/
	public boolean verify(int id);
	/**�����û�����ѯ*/
	public List<SalesOrder> findByOderUser(String username)throws IndexOutOfBoundsException;

}
