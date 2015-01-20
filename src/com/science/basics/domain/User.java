package com.science.basics.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 人员实体类
 * @author cheng
 *
 */
@Entity
@Table(name="t_user")
public class User {
@Id
@GeneratedValue
 private int id;
 private String userName;
 private String password;
 private boolean sex;
 private long phone;
 private String email;
 private String addr;
 private Date regDate;
 private String IP;
 private String QQ;
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public Date getRegDate() {
	return regDate;
}
public void setRegDate(Date regDate) {
	this.regDate = regDate;
}
public String getIP() {
	return IP;
}
public void setIP(String iP) {
	IP = iP;
}
public boolean isSex() {
	return sex;
}
public void setSex(boolean sex) {
	this.sex = sex;
}
public String getQQ() {
	return QQ;
}
public void setQQ(String qQ) {
	QQ = qQ;
}

 

}
