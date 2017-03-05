package com.obao.user.entity;

import java.util.HashSet;
import java.util.Set;
/**
 * @author 代江平
 * @date:2016年11月5日
 */
public class Cart {
	private String cartId;//购物车id
	private Set<BusinessItem> businessItems = new HashSet<BusinessItem>();//购物车下所有商家项

	public String getCartId() {

		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Set<BusinessItem> getBusinessItems() {
		return businessItems;
	}

	public void setBusinessItems(Set<BusinessItem> businessItems) {
		this.businessItems = businessItems;
	}

}
