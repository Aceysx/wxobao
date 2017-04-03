package com.obao.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/8.
 */
public class Business {
    private Integer businessId;//商家id
    private String photo;//商家头像
    private String name;//商家名
    private String password;
    private String email;
    private String phone;
    private String address;
    private Integer state;//状态
    private Date registerTime;
    private String remark;//主营
    private Set<Product> products = new HashSet<Product>();//商家下所有产品
    private Integer domainId;

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public String getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Integer getState() {
        return state;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public String getRemark() {
        return remark;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId=" + businessId +
                ", photo='" + photo + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", registerTime=" + registerTime +
                ", remark='" + remark + '\'' +
                ", products=" + products +
                ", domainId=" + domainId +
                '}';
    }
}
