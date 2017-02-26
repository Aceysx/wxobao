package com.obao.user.dao;

import com.obao.business.entity.Product;
import com.obao.user.entity.Collect;
import com.obao.user.entity.User;

import java.util.List;

/**
 * author 代江平
 * create Date 2016/11/28
 */
public interface ICollectDao {
    /**
     * 添加收藏
     * @param collect
     * @return
     */
    void save(Collect collect);

    /**
     * 查找用户所有收藏
     * @return
     */
    List<Object> findUserAllCollect(User user);

    /**
     * 判断用户是否已经收藏过该商品
     * @param product
     * @param user
     * @return
     */
    List<Collect> isExist(Product product, User user);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);
}
