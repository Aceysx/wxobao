package com.obao.entity;


import java.util.Date;

/**
 * Created by Administrator on 2016/11/8.
 */
public class Product {
    private Integer productId;//商品id
    private Integer businessId;
    private Integer sortId;
    private String productName;//商品名
    private String productImg;//商品图片
    private double newPrice;
    private Date addTime;//添加时间
    private Integer state;//状态 0 正常 1 删除
    private String remark;//商品详情
    private Integer promotion;//是否促销 0不是 1 是
    private Integer sales = 0;//销量

    public Integer getPromotion() {
        return promotion;
    }
    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }



    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
