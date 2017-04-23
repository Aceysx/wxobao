package com.obao.service.impl;


import com.obao.business.action.vo.ProductVo;
import com.obao.dao.IProductDao;
import com.obao.entity.*;
import com.obao.service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/8.
 */
public class ProductService implements IProductService {
   private IProductDao productDao;

    public void setProductDao(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAll(Integer state) {
        return productDao.findAll(state);
    }

    @Override
    public Product findById(Integer productId) {
        return productDao.findById(productId);
    }

	@Override
	public void save(Product product) {
		productDao.save(product);
	}

	@Override
	public List<ProductSort> findAllProductSort() {
		
		return productDao.findAllProductSort();
	}

	@Override
	public List<Business> findAllBusinesss() {
		return productDao.findAllBusinesss();
	}

    @Override
    public List<Object> searchProductList(String content) {
        return productDao.searchProductList(content);
    }

    @Override
    public List<Object> findProtions() {
        return productDao.findProtions();
    }

    @Override
    public List<Product> findHotProducts(Integer num) {
        return productDao.findHotProducts(num);
    }

    @Override
    public List<Product> findFootprints(String userId) {
        return productDao.findFootprints(userId);
    }

    @Override
    public List<Banner> findBanners() {
        return productDao.findBanners();
    }

    @Override
    public Object findDetailById(Integer id) {
        return productDao.findDetailById(id);
    }

    @Override
    public List<Object> findFlavor(Integer id) {
        return productDao.findFlavor(id);
    }

    @Override
    public List<Object> findSize(Integer id) {
        return productDao.findSize(id);
    }

    @Override
    public List<BusinessDomain> findDomains() {
        return productDao.findDomains();
    }

    @Override
    public Business findBusinessId(Integer id) {
        return productDao.findAllBusinesss(id);
    }

    @Override
    public Integer isCollect(Integer id, String userId) {
        List<Collect> collect = productDao.isCollect(id, userId);
        if(collect.size() == 0){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public List<String> findImgsByProductId(Integer id) {
        return productDao.findImgsByProductId(id);
    }

    @Override
    public List<Map<String,Object>> findBusinessProducts(ProductVo productVo) {
        Map<String, Object> data = new HashMap<>();
        List<Map<String,Object>> products = productDao.findProductsByBusinessId(productVo.getBusiness().getBusinessId());
        List<List<Object>> flavors = null;
        List<List<Object>> sizes = null;
        for (Map<String, Object> product : products) {
            flavors = new ArrayList<>();
            sizes = new ArrayList<>();
            List<Object> flavor = productDao.findFlavor((Integer) product.get("product_id"));
            flavors.add(flavor);
            List<Object> size = productDao.findSize((Integer) product.get("product_id"));
            sizes.add(size);
            product.put("flavors",flavors);
            product.put("sizes",sizes);
        }
        return products;
    }

}
