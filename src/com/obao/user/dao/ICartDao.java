package com.obao.user.dao;

import com.obao.business.entity.Product;
import com.obao.user.entity.BusinessItem;
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
	 * 保存商家项
	 * @param businessItem
     */
	void save(BusinessItem businessItem);

	/**
	 * 保存产品项
	 * @param productItem
     */
	void save(ProductItem productItem);

	/**
	 * 修改产品项中产品数量
	 * @param number
     */
	void updateProductItem(Integer number, Integer productItemId);

	/**
	 * 查找用户购物车
	 * @return
     */
	List<Object> findCart(Integer userId);

	/**
	 * 删除产品项
     */
	void deleteProductItem(ProductItem item);

	/**
	 * 删除商家项
	 * @param businessItemId
     */
	void deleteBusinessItem(Integer businessItemId);

	/**
	 * 删除购物车
	 * @param cartId
     */
	void deleteCart(Integer cartId);

	/**
	 * 查找产品项
	 * @param productItemId
	 * @return
     */
	ProductItem findProductItem(Integer productItemId);

	/**
	 * 检查商家项下是否存在商品项
	 * @param businessItemId
	 * @return
     */
	boolean checkBusinessItemIsExistProductItem(Integer businessItemId);

	/**
	 * 检查购物车中是否有商家项目
	 * @param businessItemId
	 * @return
     */
	boolean checkCartIsExistBusinessItem(Integer businessItemId);

	/**
	 * 根据商家项ID查找商家项
	 * @param businessItemId
	 * @return
     */
	BusinessItem findBusinessItemById(Integer businessItemId);



//	************************************************
	/**
	 * 查找商品所属的商家项id
	 * @param userId 用户id = 购物车id
	 * @param businessId business id
	 * @return
	 */
	BusinessItem findBusinessItemsId(Integer userId, Integer businessId);

	/**查找商品的商品项
	 *
	 * @return
	 */
	ProductItem findProductItem(ProductItem item);

}
