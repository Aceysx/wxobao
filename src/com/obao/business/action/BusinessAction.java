package com.obao.business.action;

import com.obao.business.entity.Business;
import com.obao.business.service.IBusinessService;
import com.obao.util.InvokeResult;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;


/**
 * Created by Acey on 2016/11/21.
 */
public class BusinessAction extends ActionSupport {
    private IBusinessService businessService;


    private Integer id;
    private InvokeResult resultData;
    /**
     * 查找区域下全部商家列表
     */
    public String business(){
        List<Object> businessList =  businessService.findBusinessList(id);
        resultData = resultData.success(businessList);
        return "resultData";
    }
    /**
     * 查找商家下全部产品
     * @return
     */
    public String findBusinessById(){
        List<Object> business =  businessService.findBusinessById(id);
        resultData = resultData.success(business);
        return "resultData";
    }

    public void setBusinessService(IBusinessService businessService) {
        this.businessService = businessService;
    }

    public IBusinessService getBusinessService() {
        return businessService;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InvokeResult getResultData() {
        return resultData;
    }

    public void setResultData(InvokeResult resultData) {
        this.resultData = resultData;
    }
}
