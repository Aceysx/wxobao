package com.obao.service.impl;


import com.obao.dao.ICollectDao;
import com.obao.entity.Collect;
import com.obao.service.ICollectService;

import java.util.List;

/**
 * author 代江平
 * create Date 2016/11/28
 */
public class CollectService implements ICollectService {
    private ICollectDao collectDao;

    public void setCollectDao(ICollectDao collectDao) {
        this.collectDao = collectDao;
    }

    @Override
    public void save(Collect collect) {
        collectDao.save(collect);
    }

    @Override
    public List<Object> findUserAllCollect(String userId) {
        return collectDao.findUserAllCollect(userId);
    }
    @Override
    public Integer isExist(Integer productId, String userId) {
        List<Collect> collects = collectDao.isExist(productId, userId);
        if(collects.size() == 0){
            return 0;
        }else{
            return collects.get(0).getId();
        }
    }

    @Override
    public void delete(Integer id) {
        collectDao.delete(id);
    }


}
