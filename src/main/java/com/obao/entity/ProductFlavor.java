package com.obao.entity;

/**
 * Created by Acey on 2016/11/23.
 */
public class ProductFlavor {
    private Integer flavorId;
    private String name;
    private String remark;

    public void setFlavorId(Integer flavorId) {
        this.flavorId = flavorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getFlavorId() {

        return flavorId;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }
}
