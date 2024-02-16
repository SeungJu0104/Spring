package com.test01;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class BeanTest {
	
	private MyClass myClass;
	
	public BeanTest() {
		System.out.println("기본 생성자(no-args)");
	}
	
	public BeanTest(Date date) {
		System.out.println("날짜 생성자(date : " + date + ")");
	}
	
	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
		System.out.println("setMyClass() 호출 : " + myClass);
	}
	
	public void setDate(Date date) {
		System.out.println("setDate() 호출 : " + date);
	}
	
	public void setNumber(int num) {
		System.out.println("setNumber() 호출 : " + num);
	}
	
	public void setArray(String [] arr) {
		System.out.println("setArray () 호출 : \n");
		
		for(String str:arr) {
			System.out.println(str);
		}
		
	}
	
	public void setList(List <String> list) {
		System.out.println("setList () 호출 : \n");
		
		for(String str : list) {
			System.out.println(str);
		}
	}
	
	public void setMap(Map <String, String> map) {
		System.out.println("setMap () 호출 : \n");
		System.out.println(map);
	}
	
	public void setScore(List <Score> list) {
		System.out.println("setScore () 호출 : \n");
		System.out.println(list);
	}

}
