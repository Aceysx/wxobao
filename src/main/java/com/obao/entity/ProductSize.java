package com.obao.entity;

/**
 * Created by Acey on 2016/11/23.
 */
public class ProductSize {
    private Integer sizeId;
    private String size;
    private String remark;


    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getSize() {
        return size;
    }

    public String getRemark() {

        return remark;
    }
}
