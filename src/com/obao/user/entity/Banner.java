package com.obao.user.entity;

import java.util.Date;

/**
 * Created by Acey on 2016/11/21.
 */
public class Banner {
    private Integer bannerId;
    private Integer productId;
    private Date addTime;
    private String url;
    private Integer show;//是否显示 0 不显示 1显示


    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public Integer getBannerId() {
        return bannerId;
    }


    public Date getAddTime() {
        return addTime;
    }

    public Integer getShow() {
        return show;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}

