package com.test02;

public class Address {
	// 필드
	private String name;
	private String addr;
	private String phone;
	
	// 생성자
	public Address() {
		super();
	}
	
	public Address(String name, String addr, String phone) {
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}

	public void setNm(String name) {
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

	// 메소드
	@Override
	public String toString() {
		return "이름: " + name + "\t 주소: " + addr + "\t 전화번호: " + phone;
	}
}
