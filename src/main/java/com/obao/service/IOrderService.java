package com.obao.service;



import com.obao.entity.Order;

import java.util.List;

public interface IOrderService {

	/**
	 * 根据状态查询订单
	 * @param state 状态id 0 未处理 1 已处理 2 取餐成功
	 * @return
     */
	List<Object> findOrderByState(Integer state, Integer userId);

	/**
	 * 保存订单
	 * @param orders 购物车内订单
     */
	void saveOrder(List<Order> orders);
}
