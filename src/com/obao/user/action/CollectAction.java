package com.obao.user.action;

import com.obao.business.entity.Product;
import com.obao.user.entity.Collect;
import com.obao.user.entity.User;
import com.obao.user.service.ICollectService;
import com.obao.util.InvokeResult;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.util.List;

/**
 * author 代江平
 * create Date 2016/11/28
 */
public class CollectAction extends ActionSupport {
    private User user = null;
    private Product product = null;
    private Collect collect = null;
    private ICollectService collectService;
    private InvokeResult resultData;


    /**
     * 添加收藏/取消收
     *
     * @return
     */
    public String add() {
        System.out.println(user.getUserId());
        if (user != null && product != null) {
            Integer id = collectService.isExist(product, user);
            System.out.println(id);
            if (id != 0) {
                collectService.delete(id);
                resultData = resultData.success("取消成功");
                return "resultData";
            } else {
                Collect collect = new Collect();
                collect.setUser(user);
                collect.setProduct(product);
                collect.setAddDate(new Date());
                collectService.save(collect);
                resultData = resultData.success("收藏成功");
                return "resultData";
            }
        }
        resultData = resultData.failure("操作失败，请稍后在试");
        return "resultData";
    }

    /**
     * 查询全部收藏
     * @return
     */
    public String findUserAll(){
        List<Object> collects = collectService.findUserAllCollect(user);
        resultData = resultData.success(collects);
        return "resultData";
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

    public ICollectService getCollectService() {
        return collectService;
    }

    public void setCollectService(ICollectService collectService) {
        this.collectService = collectService;
    }

    public Collect getCollect() {
        return collect;
    }

    public void setCollect(Collect collect) {
        this.collect = collect;
    }

    public InvokeResult getResultData() {
        return resultData;
    }

    public void setResultData(InvokeResult resultData) {
        this.resultData = resultData;
    }
}

