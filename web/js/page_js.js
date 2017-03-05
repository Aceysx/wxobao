$(function () {
    //轮播图设置
    $("#swiper-con").swiper({
        pagination:'.swiper-pagination',
        paginationClickable:true,
        slidesPerView:'auto',
        centeredSlides:true,
        effect:"coverflow",
        speed: 500,
        autoplay:2000,
    })
    //判断用户是否非法进入主页
    saveOpenid();
});

/**
 * 商品详情
 */
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
    $("#info_popup-about").removeClass("close-popup");
    $(".ok").removeClass("shopping").addClass("buying");
}
function add(){
    $("#info_popup-about").removeClass("close-popup");
    $(".ok").removeClass("buying").addClass("shopping");
}
function isBuy() {
    $(".buy_href").removeAttr("href");
    $("#info_popup-about").removeClass("close-popup");
    //添加购物车
    if ($(".ok").hasClass("shopping")) {
        var cart_data = {
            'item.userId': uid,
            'item.productId': product_info.product_id,
            'item.flavorAndProduct': flavor_index == -1 ? "" : flavors[flavor_index].name,
            'item.productNumber': number,
            'item.sizeAndProduct': size_index == -1 ? "" : sizes[size_index].size,
            'item.businessId': product_info.business_id,
            'item.price': size_index == -1 ? product_info.new_price : sizes[size_index].price
        }
        add_shopping_ajax(cart_data);
    }
    //直接购买
    if ($(".ok").hasClass("buying")) {
        $(".buy_href").attr({href: "placeorder.html?"+ new Date().getTime()});

        $("#info_popup-about").addClass("close-popup");
    }
}

/**
 * 购物车
 */
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
}

/**
 * 下单页面填充
 */
    // -- >商品详情页面跳转下单页面
function buy_to_order() {

    var productId = product_info.product_id;
    var businessId = product_info.business_id;
    var pimg = host_img + "product/"+product_info.product_img;
    var productName = product_info.product_name;
    var flavor = flavor_index == -1 ? "" : flavors[flavor_index].name;
    var size = size_index == -1 ? "" : sizes[size_index].size;
    var classifys = flavor +" "+ size ;
    var price = size_index == -1 ? product_info.new_price : sizes[size_index].price;
    var buyNumber = number;

    var _html = "";
    _html += "<div class='placeorder_product'> <div class='list-block media-list'><ul><li ><a href='#' class='item-link item-content'>";
    _html += "<div class='item-media'><img src='"+pimg+"' width='68rem' height='68rem'></div><div class='item-inner'>";
    _html += "<div class='item-title produt_name_style'><b>"+productName+"</b></div>";
    _html += "<div class='item-title placeorder_kinds'>"+classifys+"</div>";
    _html += "<div class='item-title number'>数量:<span class='place_order_number'>"+buyNumber+"</span></div><div class='item-title-row'>";
    _html += "<div class='item-title price_style placeorder_price'><b>￥<span class='place_order_price'>"+price+"</span>元</b></div>";
    _html += "</div></div></a></li></ul></div><div class='list-block choose_time'><ul><li>";
    _html += "<div class='item-content'><div class='item-inner'><div class='item-title label'>取餐时间：</div><div class='item-input'>";
    _html += "<input type='hidden' class='businessId'  value='"+businessId+"'/>";
    _html += "<input type='hidden' class='productId'  value='"+productId+"'/>";
    _html += "<input type='datetime-local' class='order_remark ' style='color: #21a1a1;font-size: .6rem;font-weight: bolder'  value=''/>";
    _html += "</div></div></div>";
    _html += "<div class='item-content'><div class='item-inner'><div class='item-title label'>买家留言：</div>";
    _html += "<div class='item-input'><input type='text' class='order_remark' style='font-size: .6rem' placeholder='给店家留言'/>";
    _html += "</div></div></div></li></ul></div></div>";

    $("#order_content").append(_html);
    place_order_allprice();
}
    // -- >购物车页面跳转下单页面
function shopping_to_order() {
}
    //计算价格
function place_order_allprice() {
    var place_order_allprice = 0;
    var product =  $(".placeorder_product");
    for(var i = 0;i < product.length; ++i){
        place_order_allprice += $(product[i]).find(".place_order_price").text() * $(product[i]).find(".place_order_number").text();
    }
    $(".placeorder_total_price").text(place_order_allprice);
}

/**
 * 个人中心
 */
    //个人中心页面
function person() {
    var info = getUserInfo();
    var name = info.userName;
    var img = info.userImg;
    $("#person_img").attr({src: img});
    $("#person_name").text(name);
}
    //个人信息页面
function person_info() {
    var info = getUserInfo();
    $("#personInfo_name").text(info.userName);
    $("#personInfo_img").attr({src:info.userImg});
    $("#personInfo_sex").text(info.sex);
    // $("#personInfo_address").text(info.address);
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
