package com.bit.helloSpring.vo;

public class RequestVo {
	private String name;
	private String password;
	private String email;
	private String address;
	
	// Bean 객체는 기본생성자 한 개 필요함
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//toString, equals 오버라이드 괜찮음
	@Override
	public String toString() {
		return "RequestVo [name=" + name + ", password=" + password + ", email=" + email + ", address=" + address + "]";
	}
	
	
	
}
