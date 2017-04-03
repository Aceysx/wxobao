package com.obao.dao;


import com.obao.entity.Order;

import java.util.List;

public interface IOrderDao {


	/**
	 * 根据状态查询订单
	 * @param state 状态
	 * @return
     */
	List<Object> findOrderByState(Integer state, Integer userId);

	/**
	 * 保存订单
	 * @param order
     */
	void save(Order order);
}
