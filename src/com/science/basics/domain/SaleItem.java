package com.science.basics.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ������ʵ����
 * @author cheng
 *
 */
@Entity
@Table(name="t_saleitem")
public class SaleItem {
	private int id;
	/**
	 * ��Ʒ���
	 */
	private int productId;
	/**
	 * ��Ʒ����
	 */
	private String productName;
	/**
	 * ��������
	 */
	private int number;
	/**
	 * ����۸�
	 */
	private double price;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
