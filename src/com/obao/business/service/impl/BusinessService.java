package com.obao.business.service.impl;

import com.obao.business.dao.IBusinessDao;
import com.obao.business.dao.IProductDao;
import com.obao.business.entity.Business;
import com.obao.business.entity.BusinessDomain;
import com.obao.business.entity.Product;
import com.obao.business.entity.ProductSort;
import com.obao.business.service.IBusinessService;
import com.obao.business.service.IProductService;

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
