package com.test03;

public class Enginner {
	
	// 상속은 is a 관계, 필드로 가지면 has a 관계
	private Emp emp;
	private String dept;
	
	public Enginner() {
		super();
	}
	
	public Enginner(Emp emp, String dept) {
		this.emp = emp;
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return emp + "\t 부서: " + dept;
		// return emp.toString() + "\t 부서: " + dept; 와 동일하다.
	}

}
