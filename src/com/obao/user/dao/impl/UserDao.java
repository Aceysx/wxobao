package com.obao.user.dao.impl;

import com.obao.user.dao.IUserDao;
import com.obao.user.entity.Cart;
import com.obao.user.entity.Footprint;
import com.obao.user.entity.User;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author 代江平
 * @date:2016年11月5日
 */
public class UserDao implements IUserDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findById(String userId) {
        return (User) sessionFactory.getCurrentSession().get(User.class,userId);
    }

    @Override
    public void saveOrUpdate(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public List<Footprint> isExistFootprint(String userId, Integer productId) {
        return sessionFactory.getCurrentSession().createQuery("from Footprint where userId=? and productId = ?")
                .setParameter(0, userId)
                .setParameter(1, productId).list();
    }

    @Override
    public void saveOrUpdateFootprint(Footprint print) {
        sessionFactory.getCurrentSession().saveOrUpdate(print);
    }

    @Override
    public List<User> findByOpenid(String openid) {
        return  sessionFactory.getCurrentSession().createQuery("from User where openid=?")
                .setParameter(0, openid)
                .list();

    }

    @Override
    public void save(Cart cart) {
        sessionFactory.getCurrentSession().save(cart);
    }


}
