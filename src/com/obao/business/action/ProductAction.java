package com.obao.business.action;

import java.io.File;
import java.io.IOException;
import java.util.*;


import com.obao.business.entity.*;
import com.obao.user.entity.Banner;

import com.obao.business.service.IProductService;
import com.obao.user.entity.Collect;
import com.obao.util.InvokeResult;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Administrator on 2016/11/8.
 */
public class ProductAction extends ActionSupport {
    private IProductService productService;
    private String msg;
	private File userPic;
	private String userPicFileName;
	private String userPicContentType;
	private Integer start; //分页开始
	private Integer end;
	private Integer num = 10;//热门商品查询数量
	private Integer id;
	private Integer userId;
	private InvokeResult  resultData;


	/**
	 * 商品详情
	 */
	public String detail(){
        Object  productDetail =productService.findDetailById(id);
		List<Object> flavors =  productService.findFlavor(id);
		List<Object> sizes = productService.findSize(id);
		Integer collect= productService.isCollect(id,userId);
		//package data
		Map<String ,Object> data = new HashMap<String, Object>();
		data.put("isCollect",collect);
		data.put("sizes", sizes);
		data.put("flavors",flavors);
		data.put("detail", productDetail);
        resultData = resultData.success(data);
        return "resultData";
	}
	/**
	 * 模糊查询商品列表
	 * @return
	 */
	public String searchList(){
        List<Product> products = productService.searchProductList(msg);
		resultData = resultData.success(products);
        return "resultData";
	}

	/**
	 * 查找促销商品列表
	 */
	public String promotionProducts() {
        List<Object> products = productService.findProtions();
		resultData = resultData.success(products);
        return "resultData";
	}
	/**
	 * 热门商品查询列表
	 */
	public String hotProducts() {
        List<Product> products = productService.findHotProducts(num);
		resultData = resultData.success(products);
        return "resultData";
	}
	/**
	 * banner图查询列表
	 */
	public String banners() {
        List<Banner> banners = productService.findBanners();
        resultData = resultData.success(banners);
        return "resultData";
	}
	/**
	 * 区域列表
	 */
	public String domains() {
        List<BusinessDomain> domains = productService.findDomains();
        resultData = resultData.success(domains);
        return "resultData";
	}
    /**
     * 添加商品
     * @return
     */
    public String add(){
			for(int i = 0 ; i < 50; ++i) {
				Product product = new Product();
				product.setState(0);
				product.setProductName("哈哈"+i);
				product.setPromotion(1);
				product.setNewPrice(i*10);
				product.setAddTime(new Date());
				product.setSales(0);
				product.setRemark("free");
				productService.save(product);
			}
			msg = "添加成功";
//		}
		return "addSuccess";
	}




	/**
     * get and set...
     */
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }


    public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setUserPic(File userPic) {
		this.userPic = userPic;
	}

	public void setUserPicFileName(String userPicFileName) {
		this.userPicFileName = userPicFileName;
	}

	public void setUserPicContentType(String userPicContentType) {
		this.userPicContentType = userPicContentType;
	}

	public File getUserPic() {

		return userPic;
	}

	public String getUserPicFileName() {
		return userPicFileName;
	}

	public String getUserPicContentType() {
		return userPicContentType;
	}

	public IProductService getProductService() {
		return productService;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getEnd() {
		return end;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getNum() {
		return num;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {

		return id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public InvokeResult getResultData() {
		return resultData;
	}

	public void setResultData(InvokeResult resultData) {
		this.resultData = resultData;
	}
}
