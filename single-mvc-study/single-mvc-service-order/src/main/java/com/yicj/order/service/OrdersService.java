package com.yicj.order.service;


import com.yicj.pojo.Orders;

public interface OrdersService {
	/**
	 * @Description: 根据订单id查询订单
	 */
	Orders getOrder(String orderId);
	/**
	 * @Description: 下订单
	 */
	boolean createOrder(String itemId);

}

