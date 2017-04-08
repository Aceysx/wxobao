package com.obao.service.impl;


import com.obao.dao.IOrderDao;
import com.obao.entity.Order;
import com.obao.service.ICartService;
import com.obao.service.IOrderService;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class OrderService implements IOrderService {
    private IOrderDao orderDao;
    private ICartService cartService;

    public void setCartService(ICartService cartService) {
        this.cartService = cartService;
    }

    public void setOrderDao(IOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Object> findOrderByState(Integer state, Integer userId) {
        return orderDao.findOrderByState(state,userId);
    }

    @Override
    public void saveOrder(List<Order> orders) {
        Random random = new Random();
        String randomNum;
        String uuid;
        for (Order order : orders) {
            uuid = UUID.randomUUID().toString().replace("-", "");
            randomNum = ""+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);

            order.setOrderNumber(uuid);
            order.setMealCode(randomNum);

            orderDao.save(order);
        }
    }
}
