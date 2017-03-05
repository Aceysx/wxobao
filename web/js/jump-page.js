var ids;

//主页下拉刷新
$(document).on('refresh', '.pull-to-refresh-content',function(e) {
    banners_ajax();
    range_ajax();
    promotion_products_ajax();
    hot_products_ajax();
    // done
    $.pullToRefreshDone('.pull-to-refresh-content');
    $.toast("刷新成功");
});

//ajax页面跳转刷新
$(document).on("pageInit",function (e,pageId,$page) {
    //获取 url 中的参数
    ids = getIds(location.href);
/**
 * 主页
 * **/
    //主页跳转
    if( pageId == "page_index"){
        banners_ajax();
        range_ajax();
        promotion_products_ajax();
        hot_products_ajax();
    }
    //区域下商家列表页面跳转
    if(pageId == "page_business_list"){
        business_list_ajax(ids[1]);
    }
    //商家内信息页面跳转
    if(pageId == "page_business_info"){
        business_info_ajax(ids[1]);
    }
    //商品详情页面跳转
    if(pageId == "page_product_info"){
        product_detail_ajax(ids[1]);
    }
    //product_search page //模糊搜索
    if(pageId == "product_search"){
        product_search();
    }
    //下单页面跳转
    if(pageId == "page_placeorder"){
        buy_to_order();
    }

/**
 * 收藏页面
 * **/
    //收藏页面跳转
    if(pageId == "page_collection"){
        collection_ajax();
    }
/**
 * 购物车页面
 * **/
    //购物车页面跳转
    if(pageId == "page_shopping"){
        shopping_ajax();
    }
/**
 * 个人中心页面
 * **/
    //个人中心页面跳转
    if(pageId == "page_person"){
        person();
    }
    //个人信息页面
    if(pageId == "page_personInfo"){
        person_info();
    }
    //orders page
    if(pageId == "page_orders"){
    }

})

//let location href split by "?" 将 url 按 '?' 分割
// eg:product_info.html?1151 == return [product_info.html][1151]
function getIds(a_href) {
    return a_href.split("?");
}
