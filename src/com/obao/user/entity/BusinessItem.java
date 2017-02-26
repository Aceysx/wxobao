package com.obao.user.entity;

import com.obao.business.entity.Business;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 代江平
 * @date:2016年11月5日
 */
public class BusinessItem {
	private Integer businessItemId;//商家项id
	private Cart cart;//商家项所在的购物车
	private Set<ProductItem> productItems = new HashSet<ProductItem>();//商家项下的所有产品项
	private Business business;//商家项里的商家信息

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Integer getBusinessItemId() {
		return businessItemId;
	}

	public void setBusinessItemId(Integer businessItemId) {
		this.businessItemId = businessItemId;
	}

	public Set<ProductItem> getProductItems() {
		return productItems;
	}

	public void setProductItems(Set<ProductItem> productItems) {
		this.productItems = productItems;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "BusinessItem{" +
				"businessItemId=" + businessItemId +
				", productItems=" + productItems +
				", business=" + business +
				'}';
	}
}
