package com.obao.business.service;

import com.obao.business.entity.Business;
import com.obao.business.entity.BusinessDomain;
import com.obao.business.entity.Product;
import com.obao.business.entity.ProductSort;

import java.util.List;

/**
 * Created by Administrator on 2016/11/8.
 */
public interface IBusinessService {

    /**
     * 查找全部区域
     */
    List<BusinessDomain> findDomains();
    /**
     * 根据商家ID查找商家下全部商品
     * @param id
     * @return
     */
    List<Object> findBusinessById(Integer id);


    /**
     * 查找区域下全部商家列表
     * @param id 区域id
     * @return
     */
    List<Object> findBusinessList(Integer id);
}
