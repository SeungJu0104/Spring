package com.test04;

public class Enginner {
	
	private Emp emp;
	private String dept;
	
	public Enginner () {
		super();
	}
	
	public Enginner(Emp emp, String dept) {
		this.emp = emp;
		this.dept = dept;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String toString() {
		return emp + "\t" + dept;
		// return emp.toString() + "\t" + dept; 와 동일하다.
	}

}
