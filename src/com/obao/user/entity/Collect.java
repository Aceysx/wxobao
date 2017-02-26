package com.obao.user.entity;

import com.obao.business.entity.Product;

import java.util.Date;

/**
 * author 代江平
 * create Date 2016/11/28
 */
public class Collect{
    private Integer id;//收藏ID
    private User user;//对应的用户
    private Product product;//收藏的商品
    private Date addDate;//收藏时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", addDate=" + addDate +
                '}';
    }
}
