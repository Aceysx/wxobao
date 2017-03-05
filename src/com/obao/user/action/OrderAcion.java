package com.obao.user.action;

import com.obao.user.entity.Order;
import com.obao.user.service.IOrderService;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acey on 2016/11/25.
 */
public class OrderAcion extends ActionSupport {
    private IOrderService orderService;
    private List<Object> data;
    private Integer state;
    private Integer id;
    private List<Order> orders = new ArrayList<>();
    private String orderString;

    /**
     * 根据订单状态查询订单
     */
    public String orders(){
        data = orderService.findOrderByState(state,id);
        return "data";
    }

    /**
     * 结算
     */
    public  String statement(){
        JSONArray json = JSONArray.fromObject(orderString);
        orders = (List<Order>)JSONArray.toCollection(json, Order.class);
        orderService.saveOrder(orders);
        return "orders";
    }



    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public IOrderService getOrderService() {
        return orderService;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getOrderString() {
        return orderString;
    }

    public void setOrderString(String orderString) {
        this.orderString = orderString;
    }
}
