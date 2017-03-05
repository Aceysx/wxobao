package com.obao.user.service;


import com.obao.user.entity.Cart;
import com.obao.user.entity.User;

public interface IUserService {
    /**
     * 根据id查找用户
     * @param userId
     * @return
     */
    User findById(String userId);
    /**
     * 保存用户
     * @param user
     */
    void saveOrUpdate(User user);

    /**
     * 更新用户的足迹
     * @param userId
     * @param productId
     */
    void updateFootprint(String userId, Integer productId);

    /**
     * 根据用户openid查询用户信息
     * @param openid
     * @return
     */
    User findByOpenid(String openid);

    /**
     * 查看openid是否存在
     * @param openid
     * @return
     */
    boolean openidIsExist(String openid);

    /**
     * 创建购物车
     * @param cart
     */
    void saveCart(Cart cart);
}
