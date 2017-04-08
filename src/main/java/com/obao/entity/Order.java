package com.obao.entity;

import java.util.Date;

/**
 * Created by Acey on 2016/11/25.
 */
public class Order {
    private Integer orderId;
    private Integer userId;
    private Integer productId;//商品id
    private Integer state;//状态 0 下单未处理 1下单已处理 2 取餐成功 3拒单
    private Integer number;//数量
    private Double totalPrice;
    private String orderNumber;//订单号
    private String mealCode;//取餐码
    private String classifys; // 商品类别
    private String customerRemark;//用户留言
    private String businessRemark;//商家拒单备注
    private Date orderTime;//下单时间
    private Date dealTime;//处理时间
    private Date noticeTime;//通知时间
    private Date receiveTime;//取餐时间

    public String getClassifys() {
        return classifys;
    }

    public void setClassifys(String classifys) {
        this.classifys = classifys;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getMealCode() {
        return mealCode;
    }

    public void setMealCode(String mealCode) {
        this.mealCode = mealCode;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark;
    }

    public String getBusinessRemark() {
        return businessRemark;
    }

    public void setBusinessRemark(String businessRemark) {
        this.businessRemark = businessRemark;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

