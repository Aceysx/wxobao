package com.obao.user.service.impl;

import com.obao.business.dao.IBusinessDao;
import com.obao.business.dao.IProductDao;
import com.obao.business.entity.Business;
import com.obao.business.entity.Product;
import com.obao.business.entity.ProductFlavor;
import com.obao.business.entity.ProductSize;
import com.obao.user.dao.ICartDao;
import com.obao.user.entity.BusinessItem;
import com.obao.user.entity.Cart;
import com.obao.user.entity.ProductItem;
import com.obao.user.service.ICartService;

import java.util.ArrayList;
import java.util.Collections;
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
               cartDao.save(productItem);
               return true;
           }else{
               cartDao.save(item);
               return  true;
           }
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
//     try {
//         //1、判断购物车中是否有该产品所属的商家项
//         BusinessItem businessItem = cartDao.findBusinessItemsId(userId, item.getBusinessId());
//         if(businessItem != null){
//             //1.1、有该商家项，再判断该商家项中是否有该商品项
//             ProductItem productItem = cartDao.findProductItem(businessItem.getBusinessItemId(), item.getProductId(),item.getFlavorAndProductId(),item.getSizeAndProductId());
//             if(productItem != null){
//                 //1.1.1、有该商品就在原商品项中数量相加
//                 cartDao.updateProductItem(item.getProductNumber(),productItem.getProductItemId());
//                 return true;
//             }else{
//                 //1.1.2 没有就创建该商品项
//                 item.setBusinessItem(businessItem);
//                 cartDao.save(item);
//                 return true;
//             }
//         }else{
//             //1.2、没有该商家项，就创建该商家项和商品项
//             BusinessItem newBusinessItem = new BusinessItem();
//             Business business = new Business();
//             business.setBusinessId(item.getBusinessId());
//             Cart cart = cartDao.findCart(userId);
//             newBusinessItem.setBusiness(business);
//             newBusinessItem.getProductItems().add(item);
//             cart.getBusinessItems().add(newBusinessItem);
//             cartDao.save(cart);
//             return true;
//         }
//     }catch (Exception e){
//         e.printStackTrace();
//         return false;
//     }
    }

    /**
     * 包装商家项
     *
     * @return
     */
    public BusinessItem warpBusinessItem(Integer userId,Integer businessId,ProductItem productItem) {
        BusinessItem businessItem = new BusinessItem();
        Business business = new Business();
        business.setBusinessId(businessId);
        Cart cart = new Cart();
        cart.setCartId(userId);


        businessItem.setCart(cart);
        businessItem.setBusiness(business);
        businessItem.getProductItems().add(productItem);
        return businessItem;
    }

    @Override
    public List<Object> findCart(Integer userId) {
        return cartDao.findCart(userId);

    }

    @Override
    public void delete(ProductItem item) {
        cartDao.deleteProductItem(item);
    }

    @Override
    public List<BusinessItem> findBuyingBill(String businessItemIds, String productItemIds) {
        String[] businessItemIdsArr = businessItemIds.split("MD5");
        String[] productItemIdsArr = productItemIds.split("MD5");
        List<BusinessItem> bs = Collections.synchronizedList(new ArrayList<BusinessItem>());
        List<BusinessItem> returnBusinessItems = Collections.synchronizedList(new ArrayList<BusinessItem>());
        for (String item : businessItemIdsArr) {
            if (item != "") {
                bs.add(cartDao.findBusinessItemById(Integer.parseInt(item)));
            }
        }
       //遍历全部商家项
        for (BusinessItem btm : bs) {
            //遍历单个商家项下全部商品项
            BusinessItem br = new BusinessItem();
            br.setCart(btm.getCart());
            br.setBusiness(btm.getBusiness());
            for (ProductItem ptm : btm.getProductItems()) {
                    //筛选出产品项中含有选中的商品项
                for(String ptmId:productItemIdsArr){
                    //遍历所有选中的产品项ID   与每个商家项下的全部产品项ID对比
                    if(ptm.getProductItemId()==(Integer.parseInt(ptmId))){
                        br.getProductItems().add(ptm);
                    }
                }
            }
            if(br.getProductItems().size()>0){
                returnBusinessItems.add(br);
            }
        }
        return returnBusinessItems;
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
