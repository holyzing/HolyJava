package com.holy.entity;

import java.util.List;

/**
 综合查询时，可能会根据用户信息、商品信息、订单信息等作为条件进行查询，
 用户信息中的查询条件由：用户的名称和性别进行查询
 
 因为mybatis的parameterType只匹配一个参数类型但是一个pojo类无法封装这些条件，
 需要提供一个包装pojo的类来对多个pojo进行包装，然后通过ojnl表达式进行取值，
 当然限定是名称层次必须一致
 
 当然parameterType也可以为一个HashMap 因为HashMap和Pojo可以无缝转换的
 
 parameterMap="" ：不会使用
 
 在好多框架中映射都是通过名称映射的，查询到的结果集都对应
 sql中的column，该column显然与容器中接收器名称一致
 */
public class UserQueryVO {

	//用户信息
	private User user;
	
	//商品ID集合
	private List<Integer> idList;
	
	//商品信息

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//订单信息
	
}
