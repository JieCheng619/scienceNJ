package com.science.basics.domain;
/**������*/
public class CartItem {
//��Ʒ��� 
private int productId;
//��Ʒ����
private String productName;
//��Ʒ����
private int count;
//��Ʒ�۸�
private double price;
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
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
//����һ����Ʒ�Ľ��
public double getTotalPrice(){
	return count*price;
}

}
