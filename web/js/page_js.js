$(function () {
    //轮播图设置
    $("#swiper-con").swiper({
        pagination:'.swiper-pagination',
        paginationClickable:true,
        slidesPerView:'auto',
        centeredSlides:true,
        effect:"cube",
        speed: 500,
        autoplay:2000,
        cube: {
            slideShadows: true,
            shadow: true,
            shadowOffset: 10,
            shadowScale: 0.6
        },
    })

});
//商品详情
    //collection图标状态改变
function change_collect(t){
    if($(t).hasClass("hasCollect")){
        $(t).removeClass("hasCollect");
        $("#collect").html("收藏");
        $.toast("取消收藏");
    }else{
        $(t).addClass("hasCollect");
        $("#collect").html("已收藏");
        $.toast("收藏成功")
    }
}
    //商品类别状态改变
function sizes_active(t,index) {
    size_index = index;//改变尺寸下标
    $(t).addClass("active").siblings().removeClass("active");//样式改变
    show_price();//不同的尺寸价钱不同
}
function flavors_active(t,index) {
    flavor_index = index;//改变口味下标
    $(t).addClass("active").siblings().removeClass("active");
}
    //数量加减
function product_reduce() {
    if(number == 1){
        return ;
    }
    --number;
    $(".number").val(number);
    show_price();
}
function product_add() {
    ++number;
    $(".number").val(number);
    show_price();
}
    //计算价钱
function show_price() {
    if(size_index != -1){//如果尺寸下标不为-1，则使用该尺寸的价钱
        var price = sizes[size_index].price * number;
    }else{//如果尺寸下标为-1或不存在，则使用默认价钱
        var price = product_info.new_price * number;
    }
    $(".change_price").text("￥" + price);
}
    //加入购物车 or 购买
function buy(){
    $(".ok").removeClass("shopping").addClass("buying");
}
function add(){
    $(".ok").removeClass("buying").addClass("shopping");
}
function isBuy(){
    if($(".ok").hasClass("shopping")){
        var cart_data = {'item.userId':uid,
            'item.productId':product_info.product_id,
            'item.flavorAndProduct':flavor_index == -1 ? "" : flavors[flavor_index].name,
            'item.productNumber':number,
            'item.sizeAndProduct':size_index == -1 ? "" : sizes[size_index].size,
            'item.businessId':product_info.business_id,
            'item.price':size_index == -1 ? product_info.new_price : sizes[size_index].price}
        add_shopping_ajax(cart_data);
    }
    if($(".ok").hasClass("buying")){
        $.toast("buy");
    }
}


//购物车
    //商家checkbox改变
function business_select(t) {
    if($(t).find(".business_select").is(":checked")){
        //当前商家chekbox选中时，选中该商家下所有商品
        $(t).siblings(".product").find("input[name='product']").prop("checked",true);
    }else{
        //当前商家chekbox反选中时，反选该商家下所有商品
        $(t).siblings(".product").find("input[name='product']").prop("checked",false);
    }
    //判断是否全选
    one_product_all();
    //计算总价
    show_all_price();
}
    //商品checkbox改变时
function product_select(t) {
    var business = $(t).siblings(".business")[0];//获取商品所属的商家
    var products = $(business).siblings(".product");//获取该商家下的所有商品
    var select_products = $(business).siblings(".product").find("input[name='product']:checked");//获取该商家下选中的所有商品
    if(products.length == select_products.length){ //
        //check when products.length == select_products.length
        $(business).find(".business_select").prop("checked",true);
    }else{
        //or remove
        $(business).find(".business_select").removeAttr("checked");
    }
    //判断是否全选
    one_product_all();
    //计算总价
    show_all_price();
}
    //全选checkbox改变时
function all_select(t) {
    if($(t).find(".all_select").is(":checked")){
        $(".business_product").find(".business_select").prop("checked",true);
        $(".product").find(".product_select").prop("checked",true);
    }else{
        $(".business_product").find(".business_select").prop("checked",false);
        $(".product").find(".product_select").prop("checked",false);
    }
    //计算总价
    show_all_price();
}
    //全选判断
function one_product_all() {
    var products = $(".product");//获取所有商品
    var select_products = $(".product").find("input[name='product']:checked");//获取选中的所有商品
    if(products.length == select_products.length){
        $(".all_select").prop("checked", true);
    }else{
        $(".all_select").prop("checked", false);
    }

}
    //计算总价
function show_all_price() {
    var price = 0;
    var products = $(".product");
    for(var i = 0; i < products.length; ++i){
        if($(products[i]).find(".product_select").is(":checked")){
            price += $(products[i]).find(".product_price").text() * $(products[i]).find(".product_number").text();
        }
    }
    $(".total_price").text(price);
}
    //删除商品
function delete_product(t) {
    var item_id = $(t).find(".item_id").val();//获取商品项id
    delete_product_item_ajax(item_id);
    //如果该商家不存在其他的商品项，那么删除该商家项信息
    var products = $(t).siblings(".product");
    if(products.length == 0){
        $(t).parents(".business_product").remove();
    }
    //计算总价
    show_all_price();
    // var curr_price = $(".total_price").text();
    // curr_price -= $(t).find(".product_price").text() * $(t).find(".product_number").text()
    // $(".total_price").text(curr_price);
}

//全局js
    //notifytion
function show_notification(title,text,img_url) {
    $.notification({
        title: title,
        text: text,
        media: "<img src="+img_url+">",
        data: "",
        onClick: function(data) {
            $.alert("Click" + data);
        },
        onClose: function(data) {
            $.alert("Click" + data);
        }
    });
}