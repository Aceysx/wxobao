package com.obao.user.entity;

import com.obao.business.entity.Product;

import java.util.Date;

/**
 * Created by Acey on 2016/11/21.
 */
public class Footprint {
    private Integer footId;
    private String userId;
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



    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }


    public Integer getFootId() {
        return footId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getAddTime() {
        return addTime;
    }

}
