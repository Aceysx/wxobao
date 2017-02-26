package com.obao.user.entity;

import java.util.HashSet;
import java.util.Set;
/**
 * @author 代江平
 * @date:2016年11月5日
 */
public class Cart {
	private Integer cartId;//购物车id
	private User user;//购物车所属用户
	private Set<BusinessItem> businessItems = new HashSet<BusinessItem>();//购物车下所有商家项

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<BusinessItem> getBusinessItems() {
		return businessItems;
	}

	public void setBusinessItems(Set<BusinessItem> businessItems) {
		this.businessItems = businessItems;
	}

	public Cart(User user, Set<BusinessItem> businessItems) {
		super();
		this.user = user;
		this.businessItems = businessItems;
	}

	public Cart() {
	}

	@Override
	public String toString() {
		return "Cart{" +
				"cartId=" + cartId +
				", businessItems=" + businessItems +
				'}';
	}
}
