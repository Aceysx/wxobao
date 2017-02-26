package com.obao.user.service.impl;

import com.obao.user.dao.IUserDao;
import com.obao.user.entity.Footprint;
import com.obao.user.entity.User;
import com.obao.user.service.IUserService;

import java.util.Date;
import java.util.List;


public class UserService implements IUserService{
	private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(Integer userId) {
        return userDao.findById(userId);
    }

    @Override
    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }

    @Override
    public void updateFootprint(Integer userId, Integer productId) {
        List<Footprint> footprints = userDao.isExistFootprint(userId,productId);
        Footprint print = new Footprint();
        if(footprints.size() == 0 ){
            print.setAddTime(new Date());
            print.setUserId(userId);
            print.setProductId(productId);
        }else{
            print = footprints.get(0);
            print.setAddTime(new Date());
        }
        userDao.saveOrUpdateFootprint(print);
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


}
