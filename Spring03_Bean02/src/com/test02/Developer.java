package com.test02;

public class Developer extends Emp{
	
	private String dept;
	
	public Developer() {
		super();
	}
	
	public Developer(String name, int salary) {
		super(name,salary);
		// 부모클래스의 생성자를 이용한다.
	}
	
	// dept는 setter로 처리해본다.
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t 부서 : " + dept;
		// 부모클래스의 toString 메소드 내용에 부서 : dept 값이 붙어서 출력된다.
	}
	
	
}
