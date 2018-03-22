package com.holy.domain;

import java.util.Date;

public class User {
	
	private Integer id;
	private String name;
	private Integer age;
	private Date date;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", date=" + date + ", address=" + address + "]";
	}
}
