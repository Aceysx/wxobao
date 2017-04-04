package com.obao.service.impl;


import com.obao.dao.IBusinessDao;
import com.obao.dao.ICartDao;
import com.obao.dao.IProductDao;
import com.obao.entity.ProductItem;
import com.obao.service.ICartService;

import java.util.List;

public class CartService implements ICartService {
    private ICartDao cartDao;
    private IProductDao productDao;
    private IBusinessDao businessDao;

    /**
     * * 业务层
     * 添加购物车
     */
    @Override
    public boolean save(ProductItem item) {
       try {
           ProductItem productItem = cartDao.findProductItem(item);
           if(productItem != null){
               Integer number = productItem.getProductNumber() + item.getProductNumber();
               productItem.setProductNumber(number);
               cartDao.saveOrUpdate(productItem);
               return true;
           }else{
               cartDao.saveOrUpdate(item);
               return  true;
           }
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }

    @Override
    public List<Object> findCart(String userId) {
        return cartDao.findCart(userId);

    }

    @Override
    public void delete(ProductItem item) {
        cartDao.deleteProductItem(item);
    }



    public void setCartDao(ICartDao cartDao) {
        this.cartDao = cartDao;
    }

    public void setProductDao(IProductDao productDao) {
        this.productDao = productDao;
    }

    public void setBusinessDao(IBusinessDao businessDao) {
        this.businessDao = businessDao;
    }
}
