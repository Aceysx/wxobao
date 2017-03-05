package com.obao.user.action;

import com.obao.business.service.IProductService;
import com.obao.user.entity.ProductItem;
import com.obao.user.service.ICartService;
import com.obao.user.service.IUserService;
import com.obao.util.Constant;
import com.obao.util.InvokeResult;
import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

public class CartAction extends ActionSupport {
    private ICartService cartService;
    private IUserService userService;
    private IProductService productService;
    private ProductItem item;//产品项
    private String userId;
    private InvokeResult resultData;
    /**
     * 查找我的购物车
     *
     * @return
     */
    public String findMyCart() {
        List<Object> userCart = cartService.findCart(userId);
        resultData = resultData.success(userCart);
        return "resultData";
    }

    /**
     * 添加购物车
     * @return
     */
    public String add() {
        boolean isSuccess = cartService.save(item);
        if(isSuccess){
            resultData = resultData.success(Constant.ADD_CART);
        }else {
            resultData = resultData.failure(Constant.EXCEPTION_TIP);
        }
        return "resultData";
    }
    /**
     * 删除购物车
     *
     * @return
     */
    public String delete(){
        try {
            cartService.delete(item);
            resultData = resultData.success(Constant.DELETE_CART);
        }catch (Exception e){
            e.printStackTrace();
            resultData = resultData.failure(Constant.EXCEPTION_TIP);
        }
        return "resultData";
    }



    /**
     * get and set....
     */

    public void setCartService(ICartService cartService) {
        this.cartService = cartService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }


    public void setProductService(IProductService productService) {

        this.productService = productService;
    }

    public ICartService getCartService() {
        return cartService;
    }

    public IUserService getUserService() {
        return userService;
    }

    public IProductService getProductService() {
        return productService;
    }

    public ProductItem getItem() {
        return item;
    }

    public void setItem(ProductItem item) {
        this.item = item;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public InvokeResult getResultData() {
        return resultData;
    }

    public void setResultData(InvokeResult resultData) {
        this.resultData = resultData;
    }

}
