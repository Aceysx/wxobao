package com.obao.entity;


/**
 * Created by Acey on 2016/11/23.
 */
public class FlavorAndProduct {
    private Integer id ;
    private Integer productId ;
    private Integer flavorId ;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getId() {

        return id;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getFlavorId() {
        return flavorId;
    }

    public void setFlavorId(Integer flavorId) {
        this.flavorId = flavorId;
    }
}
