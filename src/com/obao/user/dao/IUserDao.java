package com.obao.user.dao;


import com.obao.user.entity.Cart;
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
