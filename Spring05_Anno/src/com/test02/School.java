package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {
	
	@Autowired
	@Qualifier("kim")
	// 기본적으로 @Autowired는 타입 기반으로 비교하기 때문에 동일 타입의 bean이 여러개면 여기선 에러 발생한다.
	// 그래서 @Qualifier("bean id명") 를 사용하면 내가 원하는 bean을 갖고올 수 있다. 
	// (import 필요 org.springframework.beans.factory.annotation.Qualifier)
	// (단, @Qualifier를 여러개 쓸 수는 없다.)
	private Student person;
	private int grade;
	
	public School() {
		super();
	}

	public School(Student person, int grade) {
		super();
		this.person = person;
		this.grade = grade;
	}

	public void setPerson(Student person) {
		this.person = person;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}
	
}
