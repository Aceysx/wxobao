package com.obao.user.dao;


import com.obao.user.entity.Cart;
import com.obao.user.entity.Footprint;
import com.obao.user.entity.User;

import java.util.List;

public interface IUserDao {
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
     * 对应用户的足迹
     * @param userId
     * @param productId
     * @return
     */
    List<Footprint> isExistFootprint(String userId, Integer productId);

    /**
     * 更新或保存足迹
     * @param print
     */
    void saveOrUpdateFootprint(Footprint print);

    /**
     * 根据用户openid查询用户信息
     * @param openid
     * @return
     */
    List<User> findByOpenid(String openid);


    /**
     * 创建用户购物车
     * @param cart
     */
    void save(Cart cart);
}
