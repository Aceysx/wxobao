package com.obao.business.action.product;


import com.obao.business.action.vo.ProductVo;
import com.obao.service.IProductService;
import com.obao.service.impl.ProductService;
import com.obao.util.InvokeResult;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Administrator on 2016/11/8.
 */
public class ProductAction extends ActionSupport {
    private ProductVo productVo;
    private IProductService productService;
    private InvokeResult resultData;


    /**
     * 显示商家下所有商品（默认按添加时间降序排列）
     */
    public String findBusinessProducts() {
        resultData = resultData.success(productService.findBusinessProducts(productVo));
        return "resultData";
    }








    public ProductVo getProductVo() {
        return productVo;
    }

    public void setProductVo(ProductVo productVo) {
        this.productVo = productVo;
    }

    public IProductService getProductService() {
        return productService;
    }

    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    public InvokeResult getResultData() {
        return resultData;
    }

    public void setResultData(InvokeResult resultData) {
        this.resultData = resultData;
    }
}
