package com.obao.business.service;

import com.obao.business.entity.*;
import com.obao.user.entity.Banner;
import com.obao.user.entity.Collect;

import java.util.List;

/**
 * Created by Administrator on 2016/11/8.
 */
public interface IProductService {
    /**
     * 查找全部产品（正常状态）
     * @param state
     * @return
     */
    List<Product> findAll(Integer state);
    /**
     * 根据产品id查找产品信息
     * @param productId
     * @return
     */
    Product findById(Integer productId);
    /**
     * 添加产品
     * @param product
     */
    void save(Product product);
    /**
     * 查找全部产品分类
     * @return
     */
    List<ProductSort> findAllProductSort();
    /**
     * 查找全部商家
     * @return
     */
    List<Business> findAllBusinesss();

    /**
     * 模糊查询商品列表
     */
    List<Object> searchProductList(String content);

    /**
     * 查找促销商品
     * @return
     */
    List<Object> findProtions();

    /**
     * 查找热门商品
     * @param num
     * @return
     */
    List<Product> findHotProducts(Integer num);

    /**
     * 查找用户足迹
     * @param userId 用户id
     * @return
     */
    List<Product> findFootprints(String userId);

    /**
     * banner图查询
     * @return
     */
    List<Banner> findBanners();

    /**
     * 查询商品详情
     * @param id
     * @return
     */
    Object findDetailById(Integer id);

    /**
     * 查找商品对应的口味
     * @param id
     * @return
     */
    List<Object> findFlavor(Integer id);

    /**
     * 查找商品对应的大小
     * @param id
     * @return
     */
    List<Object> findSize(Integer id);

    /**
     * 查找全部区域
     * @return
     */
    List<BusinessDomain> findDomains();

    /**
     * 根据
     * @param id
     * @return
     */
    Business findBusinessId(Integer id);

    /**
     * 判断用户是否收藏该商品
     * @param id 商品id
     * @param userId 用户id
     * @return
     */
    Integer isCollect(Integer id, String userId);
}
