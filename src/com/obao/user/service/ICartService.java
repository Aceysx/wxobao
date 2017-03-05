package com.obao.user.service;

import com.obao.user.entity.ProductItem;

import java.util.List;


public interface ICartService {
	/**
	 * 添加到购物车业务接口
	 * @param item 产品项
	 */
	boolean save(ProductItem item);

	/**
	 * 查找用户购物车
	 * @param userId
	 * @return
	 */
	List<Object> findCart(String userId);

	/**
	 * 删除购物车
     */
	void delete(ProductItem item);
}
