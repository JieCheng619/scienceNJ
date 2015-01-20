package com.science.basics.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
@Entity
@Table(name="t_category")
public class Category {
//id������
private int id;
//��������
private String text;
//��������
private String description;
//���ڵ�id
private int parent;
//�Ƿ�ΪҶ��
private boolean leaf = true;
//һ�����а�������Ʒ
private Set<Product> products = new HashSet<Product>();
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getParent() {
	return parent;
}
public void setParent(int parent) {
	this.parent = parent;
}
public boolean isLeaf() {
	return leaf;
}
public void setLeaf(boolean leaf) {
	this.leaf = leaf;
}
@OneToMany(mappedBy="category")
@Cascade(CascadeType.REMOVE)//����ɾ��
public Set<Product> getProducts() {
	return products;
}
public void setProducts(Set<Product> products) {
	this.products = products;
}

}
