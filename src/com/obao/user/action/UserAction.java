package com.obao.user.action;

import com.obao.business.entity.Product;
import com.obao.business.service.IProductService;
import com.obao.user.entity.User;
import com.obao.user.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.util.List;


public class UserAction extends ActionSupport {
	private IUserService userService;
    private IProductService productService;
    private List<Product> productList;
    private User user;
    private String userId;
    private String openid;
    private Integer productId;

    /**
     * 根据用户openid查询用户信息
     * @return
     */
    public String findByOpenid() {
        user = userService.findByOpenid(openid);
        return "userInfo";
    }
    /**
     * id 查找用户
     * @return
     */
    public String findUserById(){
//     try {
//         user = userService.findById(user.getUserId());
//         return SUCCESS;
//     }catch (Exception e){
//         e.printStackTrace();
//         return SUCCESS;
//     }
        return SUCCESS;
    }


    /**
     * 查看用户足迹
     */
    public String footprints(){
        productList = productService.findFootprints(userId);
        return "productList";
    }

    /**
     * 更新足迹
     */
    public  String updateFootprint(){
        try {
            userService.updateFootprint(userId,productId);
            return "backJson";
        } catch (Exception e) {
            e.printStackTrace();
            return "backJson";
        }
    }
    /**
     * get and set......
     */
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public IProductService getProductService() {
        return productService;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
