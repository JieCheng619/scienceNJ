package com.science.basics.domain;

import java.util.LinkedList;
import java.util.List;

/**���ﳵ*/
public class Cart {
 private List<CartItem> list = new LinkedList<CartItem>();

public List<CartItem> getList() {
	return list;
}

public void setList(List<CartItem> list) {
	this.list = list;
}
 /**�����ﳵ����Ŷ���*/
public void add(CartItem cartItem){
	for(CartItem c:list){
		if(c.getProductId() ==cartItem.getProductId()){
			c.setCount(c.getCount()+1);
			return;
		}
	}
	
	list.add(cartItem);
}
/**ɾ�����ﳵ�������Ʒ*/
public boolean remove(CartItem cartItem){
	return list.remove(cartItem);
}

public double getTotalPrice(){
	double total = 0.0;
	for(CartItem c:list){
		total+=c.getTotalPrice();
	}
	return total;
}
}
