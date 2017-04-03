package com.obao.service.impl;


import com.obao.dao.IBusinessDao;
import com.obao.entity.BusinessDomain;
import com.obao.service.IBusinessService;

import java.util.List;

/**
 * Created by Administrator on 2016/11/8.
 */
public class BusinessService implements IBusinessService {
   private IBusinessDao businessDao;

    public void setBusinessDao(IBusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    @Override
    public List<BusinessDomain> findDomains() {
        return businessDao.findDomains();
    }

    @Override
    public List<Object> findBusinessById(Integer id) {
        return businessDao.findBusinessById(id);
    }

    @Override
    public List<Object> findBusinessList(Integer id) {
        return businessDao.findBusinessList(id);
    }
}
