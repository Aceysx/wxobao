package com.obao.business.entity;


/**
 * Created by Acey on 2016/11/23.
 */
public class SizeAndProduct {
    private Integer id ;
    private Integer productId ;
    private Integer sizeId ;
    private Double price;


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
    public Integer getSizeId() {
        return sizeId;
    }
    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
