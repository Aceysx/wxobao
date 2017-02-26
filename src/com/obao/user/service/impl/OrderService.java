package com.obao.user.service.impl;

import com.obao.user.dao.IOrderDao;
import com.obao.user.entity.Order;
import com.obao.user.service.ICartService;
import com.obao.user.service.IOrderService;

import java.util.List;
import java.util.Map;
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
            order.setCode(randomNum);

            orderDao.save(order);
        }
    }
}
