package com.obao.user.entity;


import java.util.Date;

/**
 * author 代江平
 * create Date 2016/11/28
 */
public class Collect{
    private Integer id;//收藏ID
    private String userId;//对应的用户id
    private Integer productId;//收藏的商品Id
    private Date addDate;//收藏时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }


}
