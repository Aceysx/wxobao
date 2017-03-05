package com.obao.user.action;

import com.obao.business.entity.Product;
import com.obao.user.entity.Collect;
import com.obao.user.entity.User;
import com.obao.user.service.ICollectService;
import com.obao.util.Constant;
import com.obao.util.InvokeResult;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.util.List;

/**
 * author 代江平
 * create Date 2016/11/28
 */
public class CollectAction extends ActionSupport {
    private ICollectService collectService;
    private InvokeResult resultData;
    private String userId;
    private Integer productId;

    /**
     * 添加收藏/取消收
     *
     * @return
     */
    public String add() {
        if (userId != null && productId != null) {
            Integer id = collectService.isExist(productId, userId);
            if (id != 0) {
                collectService.delete(id);
                resultData = resultData.success(Constant.CANCEL_COLLECT);
                return "resultData";
            } else {
                Collect collect = new Collect();

                collect.setUserId(userId);
                collect.setProductId(productId);
                collect.setAddDate(new Date());
                collectService.save(collect);
                resultData = resultData.success(Constant.ADD_COLLECT);
                return "resultData";
            }
        }
        resultData = resultData.failure(Constant.EXCEPTION_TIP);
        return "resultData";
    }

    /**
     * 查询全部收藏
     * @return
     */
    public String findUserAll(){
        List<Object> collects = collectService.findUserAllCollect(userId);
        resultData = resultData.success(collects);
        return "resultData";
    }


    public ICollectService getCollectService() {
        return collectService;
    }

    public void setCollectService(ICollectService collectService) {
        this.collectService = collectService;
    }


    public InvokeResult getResultData() {
        return resultData;
    }

    public void setResultData(InvokeResult resultData) {
        this.resultData = resultData;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}

