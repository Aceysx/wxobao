package com.obao.entity;

import java.util.Date;

/**
 * Created by Acey on 2016/11/25.
 */
public class Order {
    private Integer orderId;
    private Integer userId;
    private Integer productId;//商品id
    private String orderNumber;//订单号
    private String code;//取餐码
    private Integer number;//数量
    private Date orderTime;//下单时间
    private Date dealTime;//处理时间
    private String finishTime;//取餐时间
    private Integer state;//状态 0 下单未处理 1下单已处理 2 取餐成功
    private String classifys; // 商品类别
    private String remark;//用户留言

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}

