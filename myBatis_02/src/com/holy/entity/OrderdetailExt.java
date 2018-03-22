package com.holy.entity;
/**
 * 继承会继承父类的成员变量
 * @author hadoop
 *
 */
public class OrderdetailExt extends Orderdetail{
	private Items items;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	
}
