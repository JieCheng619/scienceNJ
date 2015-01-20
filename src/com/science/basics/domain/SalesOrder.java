package com.science.basics.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * ����ʵ����
 * @author cheng
 *
 */
@Entity
@Table(name="t_saleorder")
public class SalesOrder {
	private int id;
	/**
	 * �������
	 * ��ʽΪ201211230001,201211230002
	 */
	private String orderCode;
	/**
	 * �û�������λ�û��µĵ��ӣ�
	 */
	private String user;//userid int
	/**�û��ĵ绰����*/
	private String phone;//
	/**�û���QQ����*/
	private String QQ;
	/**
	 * �ͻ���ַ
	 */
	private String addr;
	/**
	 * ��������
	 */
	private java.sql.Timestamp odate;
	/**
	 * ����״̬����Ч\��Ч
	 */
	private boolean status;
	/**�Ƿ�Ϊ���ϵ��� true��ʾΪ��Ч��false��ʾΪ����*/
	private boolean nullify = true;
	/**
	 * ��ע
	 */
	private String remark;
	/**
	 * һ������������Щ��
	 * һ�Զ�Ĺ�ϵssss
	 */
	private Set<SaleItem> saleItems = new HashSet<SaleItem>();
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public java.sql.Timestamp getOdate() {
		return odate;
	}
	public void setOdate(java.sql.Timestamp odate) {
		this.odate = odate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isNullify() {
		return nullify;
	}
	public void setNullify(boolean nullify) {
		this.nullify = nullify;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="salesOrderId")
	public Set<SaleItem> getSaleItems() {
		return saleItems;
	}
	public void setSaleItems(Set<SaleItem> saleItems) {
		this.saleItems = saleItems;
	}
	
}
