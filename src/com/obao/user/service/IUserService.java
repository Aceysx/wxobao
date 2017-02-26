package com.obao.user.service;


import com.obao.user.entity.User;

public interface IUserService {
    /**
     * 根据id查找用户
     * @param userId
     * @return
     */
    User findById(Integer userId);
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
    void updateFootprint(Integer userId, Integer productId);

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
}
