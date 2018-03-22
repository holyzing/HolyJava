package com.holy.mapper;

import java.util.List;

import com.holy.entity.OrdersExt;

public interface OrdersMapper {
	 List<OrdersExt> getOrdersForUser();
	 List<OrdersExt> findOrdersUserRstMap();
	 List<OrdersExt> findOrdersAndOrderdetailRstMap();
	 List<OrdersExt> findOrdersUserLazyLoading();
}

