package com.test02;

public class Enginner extends Emp {
	
	private String dept;
	
	public Enginner() {
		
	}
	
	public Enginner(String name, int salary) {
		super(name, salary);
	}
	
//	public Enginner(String name, int salary, String dept) {
//		super(name, salary);
//		this.dept = dept;
//	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t 부서 : " + dept;
	}
	
}
