package com.obao.business.action.vo;

import com.obao.entity.Business;
import com.obao.entity.Order;

/**
 * Created by Acey on 17-4-7.
 * description:
 */
public class OrderVo {
    private Order order;
    private Business business;
    private String codeValue;

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
