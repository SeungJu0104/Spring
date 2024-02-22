package com.mapping.mvc.dto;

public class AddressDto {
	
	// 필드
	private String name;
	private String addr;
	private String phone;
	
	// 생성자
	public AddressDto() {
		super();
		System.out.println("constructor");
		// homecontroller.java의 postCommand 메소드를 실행할 때,
		// index.html에서 form태그에 파리미터와 value들이 넘어오면서 postCommand의 매개변수인 AddressDto dto에 담긴다.
		// 이때, 매개변수 생성자로 담는게 아니라 기본 생성자로 객체를 생성해서 set 뒷부분의 이름이 파라미터 이름과 일치하는 setter로 value들을 저장한다.
	}
	
	// getter setter
	public AddressDto(String name, String addr, String phone) {
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		System.out.println("dto constructor");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
