package com.obao.user.dao;

import com.obao.user.entity.Cart;
import com.obao.user.entity.ProductItem;

import java.util.List;

/**
 * @author 代江平
 * @date:2016年11月5日
 */
public interface ICartDao {
	/**
	 * 添加购物车
	 * @param cart
	 */
	void save(Cart cart);

	/**
	 * 保存产品项
	 * @param productItem
     */
	void save(ProductItem productItem);

	/**
	 * 查找用户购物车
	 * @return
     */
	List<Object> findCart(String  userId);

	/**
	 * 删除产品项
     */
	void deleteProductItem(ProductItem item);

	/**
	 * 删除购物车
	 * @param cartId
     */
	void deleteCart(Integer cartId);

	/**查找商品的商品项
	 *
	 * @return
	 */
	ProductItem findProductItem(ProductItem item);

}
