package com.science.basics.domain;
/**购物项*/
public class CartItem {
//商品编号 
private int productId;
//商品名称
private String productName;
//商品数量
private int count;
//商品价格
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
//返回一种商品的金额
public double getTotalPrice(){
	return count*price;
}

}
