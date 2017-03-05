package com.obao.user.entity;


public class ProductItem {
	private Integer productItemId;//产品项id
	private Integer productId;//产品项里对应的某个产品
	private Integer businessId;
	private String userId;
	private double price;//商品尺寸对应的价钱
	private Integer productNumber;//购买数量
	private String flavorAndProduct;//口味
	private String sizeAndProduct;//什么碗

	public Integer getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(Integer productItemId) {
		this.productItemId = productItemId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}

	public String getFlavorAndProduct() {
		return flavorAndProduct;
	}

	public void setFlavorAndProduct(String flavorAndProduct) {
		this.flavorAndProduct = flavorAndProduct;
	}

	public String getSizeAndProduct() {
		return sizeAndProduct;
	}

	public void setSizeAndProduct(String sizeAndProduct) {
		this.sizeAndProduct = sizeAndProduct;
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
