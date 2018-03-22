package com.holy.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * jdk1.6以上支持pojo的xml视图
 * @author LY HO
 *
 */
//@XmlRootElement
public class User {
	private Integer id;
	private String name;
	private Date date;
	private Integer age;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + date + ", age=" + age + ", address=" + address + "]";
	}
}