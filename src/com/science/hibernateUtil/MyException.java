package com.science.hibernateUtil;

public class MyException extends Exception {
 private String resultMsg;
 public MyException(String resultMsg){
	 this.resultMsg = resultMsg;
 }
@Override
public String toString() {
	return resultMsg;
}
 
}
