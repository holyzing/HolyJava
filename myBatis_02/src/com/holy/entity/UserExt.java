package com.holy.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 当业务需求是多变的，即查询主信息下需要嵌套映射的字段较多，可以扩展一个结果映射的pojo
 * 当业务需求简单且维持稳定，则完全可以在主信息的pojo添加结果的嵌套映射所需要的 pojo、或list
 * 
 * 但是我好像更喜欢扩展 
 * @author hadoop
 *
 */
public class UserExt extends User{
	/*
	 * 对于集合：
	 * 		1：需不需要提供get和set方法？ 需要
	 *      2：需不需进行实例化（即new）？ 不需要，默认返回ArrayList
	 *      3：private修饰时和public修饰时会怎么样？
	 */
	private List<OrdersExt> orders = new ArrayList<OrdersExt>();

	public List<OrdersExt> getOrders() {
		return orders;
	}

	public void setOrders(List<OrdersExt> orders) {
		this.orders = orders;
	}
	
}
