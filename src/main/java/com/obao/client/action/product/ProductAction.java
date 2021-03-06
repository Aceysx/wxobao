package com.obao.client.action.product;


import com.obao.entity.Banner;
import com.obao.entity.BusinessDomain;
import com.obao.entity.Product;
import com.obao.service.IProductService;
import com.obao.util.Constant;
import com.obao.util.InvokeResult;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Integer id;
	private String userId;
	private InvokeResult resultData;


	/**
	 * 商品详情
	 */
	public String detail(){
		try {
			//商品基本信息
			Object productDetail = productService.findDetailById(id);
			//商品焦点图图片
			List<String> imgs = productService.findImgsByProductId(id);
			//商品口味
			List<Object> flavors = productService.findFlavor(id);
			//商品尺寸
			List<Object> sizes = productService.findSize(id);
			//用户是否收藏
			Integer collect = productService.isCollect(id, userId);

			//package data
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("isCollect", collect);
			data.put("sizes", sizes);
			data.put("flavors", flavors);
			data.put("detail", productDetail);
			data.put("imgs", imgs);
			resultData = resultData.success(data);
			return "resultData";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 模糊查询商品列表
	 * @return
	 */
	public String searchList(){
		List<Object> products = productService.searchProductList(msg);
		resultData = resultData.success(products);
		if(products.size() == 0){
			resultData.setMsg(Constant.NOT_SEARCH_TIP);
		}
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
        List<Product> products = productService.findHotProducts(Constant.HOT_NUMBER);
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


	public String showEvaluations() {
		List<Map<String, Object>> evaluations = productService.findEvaluationsByProductId(id);
		resultData = resultData.success(evaluations);

		return "resultData";
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {

		return id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public InvokeResult getResultData() {
		return resultData;
	}

	public void setResultData(InvokeResult resultData) {
		this.resultData = resultData;
	}

}
