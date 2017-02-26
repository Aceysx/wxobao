package com.obao.business.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Acey on 2016/11/21.
 */
public class BusinessDomain {
    private Integer domainId;
    private String name;
    private String img;
    private String remark;
//    private Set<Business> Businesses = new HashSet<>();


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDomainId() {
        return domainId;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }
}
