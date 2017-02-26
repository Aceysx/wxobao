var ids;

//主页下拉刷新
$(document).on('refresh', '.pull-to-refresh-content',function(e) {
    banners_ajax();
    range_ajax();
    promotion_products_ajax();
    hot_products_ajax();
    // done
    $.pullToRefreshDone('.pull-to-refresh-content');
    $.toast("refresh success");
});
//ajax页面跳转刷新
$(document).on("pageInit",function (e,pageId,$page) {
    //get ids arrary
    ids = getIds(location.href);

    //product_index page
    if( pageId == "page_index"){
        banners_ajax();
        range_ajax();
        promotion_products_ajax();
        hot_products_ajax();
    }

    //collection page
    if(pageId == "page_collection"){
        collection_ajax();
    }

    //shopping page
    if(pageId == "page_shopping"){
        shopping_ajax();
    }

    //person page
    if(pageId == "page_person"){

    }

    //business list page
    if(pageId == "page_business_list"){
        business_list_ajax(ids[1]);
    }

    //business info page
    if(pageId == "page_business_info"){
        business_info_ajax(ids[1]);
    }

    //product_detail page
    if(pageId == "page_product_info"){
        product_detail_ajax(ids[1]);
    }

    //orders page
    if(pageId == "page_orders"){
    }

})

//let location href split by "?"
// eg:product_info.html?1151 == return [product_info.html][1151]
function getIds(a_href) {
    return a_href.split("?");
}
