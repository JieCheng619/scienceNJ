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
//id分类编号
private int id;
//分类名称
private String text;
//分类描述
private String description;
//父节点id
private int parent;
//是否为叶子
private boolean leaf = true;
//一个类中包含的商品
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
@Cascade(CascadeType.REMOVE)//级联删除
public Set<Product> getProducts() {
	return products;
}
public void setProducts(Set<Product> products) {
	this.products = products;
}

}
