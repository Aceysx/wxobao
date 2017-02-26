package com.obao.user.action;

import com.obao.business.service.IProductService;
import com.obao.user.entity.BusinessItem;
import com.obao.user.entity.ProductItem;
import com.obao.user.service.ICartService;
import com.obao.user.service.IUserService;
import com.obao.util.InvokeResult;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.*;

public class CartAction extends ActionSupport {
    private ICartService cartService;
    private IUserService userService;
    private IProductService productService;
    private ProductItem item;//产品项
    private Integer userId;
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
            resultData = resultData.success("添加成功");
        }else {
            resultData = resultData.failure("添加出错，请稍后在试");
        }
        return "resultData";
    }
    /**
     * 删除购物车
     *
     * @return
     */
    public String delete(){
        System.out.println(item.getProductItemId());
        try {
            cartService.delete(item);
            resultData = resultData.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            resultData = resultData.failure("删除失败，请稍后在试");
        }
        return "resultData";
    }
    public String findBuyingBill(){
        try{
            String productItemIds = ServletActionContext.getRequest().getParameter("productItemIds");
            String businessItemIds = ServletActionContext.getRequest().getParameter("businessItemIds");
            List<BusinessItem> businessItems = cartService.findBuyingBill(businessItemIds,productItemIds);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "buyRS";
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public InvokeResult getResultData() {
        return resultData;
    }

    public void setResultData(InvokeResult resultData) {
        this.resultData = resultData;
    }

}
