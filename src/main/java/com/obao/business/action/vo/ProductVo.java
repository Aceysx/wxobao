package com.obao.business.action.vo;

import com.obao.entity.Business;
import com.obao.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Acey on 17-4-8.
 * description:
 */
public class ProductVo {
    private Business business;
    private Product product;
    private List<Map<String, String>> flavors = new ArrayList<>();
    private List<Map<String, String>> sizes = new ArrayList<>();
    private String sortMethod;


    public List<Map<String, String>> getFlavors() {
        return flavors;
    }

    public void setFlavors(List<Map<String, String>> flavors) {
        this.flavors = flavors;
    }

    public List<Map<String, String>> getSizes() {
        return sizes;
    }

    public void setSizes(List<Map<String, String>> sizes) {
        this.sizes = sizes;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSortMethod() {
        return sortMethod;
    }

    public void setSortMethod(String sortMethod) {
        this.sortMethod = sortMethod;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
