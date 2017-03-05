package com.obao.user.service.impl;

import com.obao.user.dao.IUserDao;
import com.obao.user.entity.Cart;
import com.obao.user.entity.User;
import com.obao.user.service.IUserService;

import java.util.List;


public class UserService implements IUserService{
	private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(String userId) {
        return userDao.findById(userId);
    }

    @Override
    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }



    @Override
    public User findByOpenid(String openid) {
        List<User> users = userDao.findByOpenid(openid);
        if(users.size() > 0){
            return users.get(0);
        }else{
            return null;
        }
    }

    @Override
    public boolean openidIsExist(String openid) {
        List<User> users = userDao.findByOpenid(openid);
        if(users.size() > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void saveCart(Cart cart) {
        userDao.save(cart);
    }


}
