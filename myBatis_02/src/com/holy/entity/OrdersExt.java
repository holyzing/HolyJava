package com.holy.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作为parameterType传入的容器称为包装类 包装类通过OGNL实现参数的平面传入或者层次传入
 * 作为resultType输出的容器称为扩展类
 * 		1-在查询一个订单的时候查出订单所属用户的信息，可以在订单po类中加入用户将其
 * 		  扩展为扩展类来接收用户信息，但是这显然将两个po类耦合了！在实际生产中会使用
 * 		  Generator生成po类，在项目变更时会覆盖掉已存在的同名扩展类，此时就会出现丢失
 * 		  mybatis就是来应变多需求变化的，为了便于扩展，也是扩展的常用手段，为该需求
 *        特地创建一个扩展类。因为订单信息是主要信息，而用户信息为附属信息，所以对订单
 *        信息进行扩展，扩展时为了保持与订单信息的关联，采用继承实现扩展
 *        
 *        因为po类都提供了getXxx()和setXxx()方法，所以mybatis可以直接根据结果映射调用与字段名称相同的方法
 *        
 *     2-
 * @author hadoop
 */
public class OrdersExt extends Orders{
	/**
	 * resultType平铺映射：查询结果的字段映射到属性
	 */
	private String username;
	private String sex;
	/**
	 * resultMap中的嵌套映射：查询结果的部分字段映射到成成员变量的属性中
	 */
	private User user;
	/**
	 * resultMap中的嵌套映射：一对多中的多条结果映射到集合中
	 */
	private List<OrderdetailExt> ordersDetails;// = new ArrayList<OrderdetailExt>();
	
	public List<OrderdetailExt> getOrdersDetails() {
		return ordersDetails;
	}
	public void setOrdersDetails(List<OrderdetailExt> ordersDetails) {
		this.ordersDetails = ordersDetails;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
