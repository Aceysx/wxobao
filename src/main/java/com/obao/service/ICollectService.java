package com.obao.service;


import com.obao.entity.Collect;

import java.util.List;

/**
 * author 代江平
 * create Date 2016/11/28
 */
public interface ICollectService {
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
    List<Object> findUserAllCollect(String userId);

    /**
     * 判断用户是否已经收藏过该商品
     * @param productId
     * @param userId
     * @return
     */
    Integer isExist(Integer productId, String userId);
    /**
     * 删除
     */
    void delete(Integer id);

}
