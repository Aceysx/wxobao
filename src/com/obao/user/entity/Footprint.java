package com.obao.user.entity;

import com.obao.business.entity.Product;

import java.util.Date;

/**
 * Created by Acey on 2016/11/21.
 */
public class Footprint {
    private Integer footId;
    private Integer userId;
    private Date addTime;
    private Integer productId;

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {

        return productId;
    }

    public void setFootId(Integer footId) {
        this.footId = footId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }


    public Integer getFootId() {
        return footId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Date getAddTime() {
        return addTime;
    }

}
