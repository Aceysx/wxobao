package com.obao.business.action.product;


import com.obao.business.action.vo.ProductVo;
import com.obao.service.IProductService;
import com.obao.service.impl.ProductService;
import com.obao.util.Constant;
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
        try {
            resultData = resultData.success(productService.findBusinessProducts(productVo));
        } catch (Exception e) {
            e.printStackTrace();
            resultData.failure(Constant.EXCEPTION_TIP);
        }
        return "resultData";
    }

    /**
     * 显示商家下所有商品（按销量降序排列）
     * @return
     */
    public String findBusinessProductsSortBySales() {
        try{
            resultData = resultData.success(productService.findBusinessProductsSortBySales(productVo));
        }catch(Exception e){
            e.printStackTrace();
            resultData.failure(Constant.EXCEPTION_TIP);
        }
        return "resultData";
    }

    /**
     *根据商品id查询商品详情
     */
    public String findProductById()
    {
        try {
            resultData = resultData.success(productService.findProductById(productVo));
        } catch (Exception e) {
            e.printStackTrace();
            resultData.failure(Constant.EXCEPTION_TIP);
        }

        return "resultData";
    }

    /**
     *  编辑商品
     */
    public String editProduct()
    {
        try {
            resultData = resultData.success();
        } catch (Exception e) {
            e.printStackTrace();
            resultData.failure(Constant.EXCEPTION_TIP);
        }
        return "resultData";
    }

    /**
     *删除商品
     */
    public String deleteProduct()
    {
        try {
            productService.deleteProductById(productVo);
            resultData = resultData.success(Constant.DELETE_CART);
        } catch (Exception e) {
            e.printStackTrace();
            resultData.failure(Constant.EXCEPTION_TIP);
        }
        return "resultData";
    }

    /**
     * 查询分类（口味和尺寸）
     */
    public String findClassifys()
    {
        try {
            resultData = resultData.success(productService.findClassifys());
        } catch (Exception e) {
            e.printStackTrace();
            resultData.failure(Constant.EXCEPTION_TIP);
        }
        return "resultData";
    }
    /**
     * 查询所有上架/下架商品
     */
    public String findProductsByState()
    {
        try {
            resultData = resultData.success();
        } catch (Exception e) {
            e.printStackTrace();
            resultData.failure(Constant.EXCEPTION_TIP);
        }
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
