package com.obao.user.dao;

import com.obao.user.entity.*;

import java.util.List;
import java.util.Map;


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
