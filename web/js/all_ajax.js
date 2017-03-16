// var host = "http://192.168.1.109:8080/";
var host = "http://localhost:8080/";
// var host = "http://obao.tunnel.2bdata.com/";
var host_img = host+"/upload/";
var uid = 'b6078046a4424c0992dfbe9229dc2850'; // 测试用b6078046a4424c0992dfbe9229dc2850
//商品详情
var flavors;//商品口味
var sizes;//商品尺寸
var size_index = -1;//尺寸下标
var flavor_index = -1;//口味下标
var isCollect;//是否收藏 1收藏 0未收藏
var product_info;//商品详情信息
var number = 1;//购买数量 默认为1

//轮播图
function banners_ajax() {
    $.ajax({
        url:host+"product_banners.htm",
        type:"post",
        data:"",
        success:function (data) {
            if(data.result == true){
                data = data.data;
                for(var i = 1; i < data.length+1; ++i) {
                  $("#banner_id_"+i).find("img").attr({src:host_img+"/banner/"+data[i-1].url});
                  $("#banner_id_"+i).find("a").attr({href:"product_info.html?"+data[i-1].productId+"?"+new Date().getTime()});
                }
            }
        }
    })
}
//模糊搜索
function product_search() {
    var msg = $("#search").val().trim();
    $.ajax({
        url:host+"product_searchList.htm",
        type:"post",
        data:{msg:msg},
        success:function (data) {
            if(data.result){
                $("#products_search").html("");
                var _html = "";
                if(data.msg != ""){
                    _html = "<p style='text-align: center;' >"+data.msg+"</p>"
                    $("#products_search").append(_html);
                    return true;
                }
                data = data.data;
                for(var i = 0; i < data.length; ++i){
                    new_price = data[i].new_price;
                    pname = data[i].product_name;
                    bname = data[i].name;
                    id = data[i].product_id;
                    pimg_url = host_img+"product/"+data[i].product_img;
                    sales = data[i].sales;

                    _html += "<li><a href='product_info.html?"+id+"' class='item-link item-content'>";
                    _html += "<div class='item-media'><img src='"+pimg_url+"'></div>";
                    _html += "<div class='item-inner'><div class='item-title produt_name_style'><b style='product_name_style'>"+pname+"</b></div>";
                    _html += "<div class='item-title'><i>"+bname+"</i></div>";
                    _html += "<div class='item-title-row'><div class='item-title'><font color='red'><b>价格: $ "+new_price+"</b></font></div>";
                    _html += "<div class='item-after'>销量:"+sales+"</div></div></div></a></li>";
                }
                $("#products_search").append(_html);
            }
        }
    })
}
//区域范围信息
function range_ajax() {
    $.ajax({
        url:host+"product_domains.htm",
        type:"post",
        data:"",
        success:function (data) {
            if(data.result == true){
                $("#range").html("");
                data = data.data;
                var _html = "";
                for(var i = 0; i < data.length; ++i) {
                    _html += "<a href='business_list.html?"+data[i].domainId+"'>"
                    _html += "<li class='item-content'>";
                    _html += "<div class='item-media'>";
                    _html += "<img src="+host_img+"/domain/"+data[i].img+" width='44'>";
                    _html += "<br><span class='range_name'>"+data[i].name+"</span>";
                    _html += "</div>";
                    _html += "</li>";
                    _html += "</a>";
                }
                $("#range").append(_html);
            }
        }
    })
}
//促销商品
function promotion_products_ajax() {
    $.ajax({
            url: host + "product_promotionProducts.htm",
            type: "post",
            data: "",
            success: function (data) {
                if(data.result == true){
                    $("#promotion").html("");
                    data = data.data;
                    var _html = "";
                    var id,img_url,name,sales,price;
                    for(var i = 0; i < data.length; ++i) {
                         id = data[i].product_id;
                         img_url = host_img+"product/"+data[i].product_img;
                         sales = data[i].sales;
                         price = data[i].new_price;
                         name = data[i].product_name;

                        _html += "<li><a href='product_info.html?"+id+"?"+new Date().getTime()+"' class='item-link item-content'>";
                        _html += "<div class='item-media'><img src='"+img_url+"' ></div>";
                        _html += "<div class='item-inner'><div class='item-title '><b style='product_name_style'>"+name+"</b></div>";
                        _html += "<div class='item-title'>  </div><div class='item-title price_style'>$ <b>"+price+"</b></div>";
                        _html += "<div class='item-title-row'><div class='item-title '>销量："+sales+" </div>";
                        _html += "</div></div></a></li>";
                    }
                    $("#promotion").append(_html);
                }
            }
        });
}
//热门商品
function hot_products_ajax() {

    $.ajax({
        url: host + "product_hotProducts.htm",
        type: "post",
        data: "",
        success: function (data) {
            if(data.result == true){
                $("#hot").html("");
                data = data.data;
                var _html = "";
                var id,img_url,name,sales,price;
                for(var i = 0; i < data.length; ++i) {
                    id = data[i].product_id;
                    img_url = host_img+"product/"+data[i].product_img;
                    sales = data[i].sales;
                    price = data[i].new_price;
                    name = data[i].product_name;

                    _html += "<li><a href='product_info.html?"+id+"' class='item-link item-content'>";
                    _html += "<div class='item-media'><img src='"+img_url+"' ></div>";
                    _html += "<div class='item-inner'><div class='item-title '><b style='product_name_style'>"+name+"</b></div>";
                    _html += "<div class='item-title'>  </div><div class='item-title price_style'>$ <b>"+price+"</b></div>";
                    _html += "<div class='item-title-row'><div class='item-title '>销量："+sales+" </div>";
                    _html += "</div></div></a></li>";
                }
                $("#hot").append(_html);
            }
        }
    });
}
//区域商家列表
function business_list_ajax(bid) {
    $.ajax({
        url: host + "business_business.htm",
        type: "post",
        data: {id:bid},
        success: function (data) {
            if(data.result == true){
                $("#business_list").html("");
                data = data.data;
                var _html = "";
                var id,img_url,name,sales,remark;
                for(var i = 0; i < data.length; ++i) {
                    id = data[i].business_id;
                    img_url = host_img+"business/"+data[i].photo;
                    sales = data[i].sales;
                    remark = data[i].remark;
                    name = data[i].name;

                    _html += "<li><a href='business_info.html?"+id+"' class='item-link item-content'>";
                    _html += "<div class='item-media'><img src='"+img_url+"'></div><div class='item-inner'>";
                    _html += "<div class='item-title produt_name_style'><b style='product_name_style'>"+name+"</b></div>";
                    _html += "<div class='item-title'>"+remark+"</div>";
                    _html += "<div class='item-title-row'>";
                    _html += "<div class='item-title'><font color='#21a1a1'><b>总销量："+sales+"</b></font></div>";
                    _html += "</div></div></a></li>";
                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        $("#business_list").append(_html);
            }
        }
    });
}
//店铺
function business_info_ajax(bid) {
    $.ajax({
        url: host + "business_findBusinessById.htm",
        type: "post",
        data: {id:bid},
        success: function (data) {
            if(data.result == true){
                $("#business_info").html("");
                $("#business_products").html("");
                data = data.data;
                var business_html = "";
                var product_html = "";
                var id,pimg_url,bimg_url,phone,pname,bname,sales,remark,address,new_price,old_price;
                for(var i = 0; i < data.length; ++i) {
                    address = data[i].address;
                    bname = data[i].name;
                    new_price = data[i].new_price;
                    old_price = data[i].old_price;
                    phone = data[i].phone;
                    pname = data[i].product_name;
                    id = data[i].product_id;
                    pimg_url = host_img+"product/"+data[i].product_img;
                    bimg_url = host_img+"business/"+data[i].photo;
                    sales = data[i].sales;
                    remark = data[i].remark;
                    if(i == 0){
                        $("#business_name").text(bname);
                        business_html += "<li> <a href='#' class='item-link item-content'>";
                        business_html += "<div class='item-media'><img src='"+bimg_url+"' ></div>";
                        business_html += "<div class='item-inner'><div class='item-title produt_name_style'>主营："+remark+"</div>";
                        business_html += "<div class='item-title'>地址："+address+"</div><div class='item-title'>联系方式："+phone+"</div>";
                        business_html += "</div></a></li>";
                    }
                    product_html += "<li><a href='product_info.html?"+id+"' class='item-link item-content'>";
                    product_html += "<div class='item-media'><img src='"+pimg_url+"'></div>";
                    product_html += "<div class='item-inner'><div class='item-title produt_name_style'><b style='product_name_style'>"+pname+"</b></div>";
                    product_html += "<div class='item-title'><s>原价:$ "+old_price+"</s></div>";
                    product_html += "<div class='item-title-row'><div class='item-title'><font color='red'><b>促销价: $ "+new_price+"</b></font></div>";
                    product_html += "<div class='item-after'>销量:"+sales+"</div></div></div></a></li>";
                }
                $("#business_info").append(business_html);
                $("#business_products").append(product_html);
            }
        }
    });
}
//商品详情
function product_detail_ajax(pid) {
    //图片自适应
    $("#page_product_info .swiper-slide img").css({height:screen.width});
    //每次进入商品详情页面重置类别的下标及购买数量
    size_index = -1;
    flavor_index = -1;
    number = 1;
    $.ajax({
        url:host+"product_detail.htm",
        type:"post",
        data:{"id":pid,"userId":uid},
        success:function (data) {
            if(data.result){
                data = data.data;
                flavors = data.flavors;
                sizes = data.sizes;
                isCollect = data.isCollect;
                product_info = data.detail;
                imgs = data.imgs;
                //商品基本信息          picture need to update
                $("#imgs").attr({src: host_img + "product/" + imgs[0].img});
                $("#imgs1").attr({src: host_img + "product/" + imgs[1].img});
                $("#imgs2").attr({src: host_img + "product/" + imgs[2].img});

                $("#product_name").text(product_info.product_name);
                $("#bargain_price").text("促销价：￥" + product_info.new_price);
                $("#old_price").text("价格：￥" + product_info.old_price);
                $("#sales").text("销量：" + product_info.sales);
                $("#business_name").text(product_info.name);
                $("#remark").text(product_info.remark);
                $("#to_business").attr({href: "business_info.html?" + product_info.business_id});
                $("#click_collect").attr({onclick: "add_collection_ajax(this,"+product_info.product_id+")"});
                if(isCollect == 1){
                    $("#click_collect").addClass("hasCollect");
                    $("#collect").text("已收藏");
                }

                //弹出框图片和价格
                $(".img").attr({src: host_img + "product/" + product_info.product_img});

                var tprice = sizes.length > 0 ? sizes[0].price : product_info.new_price;
                $(".change_price").text("￥" + tprice);

                //弹出框商品类别
                if(sizes.length == 0){
                    $(".sizes").append("<span style='color: #21a1a1;font-weight: bold'>无</span>");
                }else{
                    size_index = 0;
                    for(var i = 0; i < sizes.length; ++i){//尺寸
                        if(i == 0){
                            $(".sizes").append("<a href='#' onclick='sizes_active(this,"+i+")' class='button active'>"+sizes[i].size+"</a>");
                        }else{
                            $(".sizes").append("<a href='#' onclick='sizes_active(this,"+i+")' class='button '>"+sizes[i].size+"</a>");
                        }
                    }
                }
                if(flavors.length == 0){
                    $(".flavors").append("<span style='color: #21a1a1;font-weight: bold'>无</span>");
                }else{
                    flavor_index = 0;
                    for(var i = 0; i < flavors.length; ++i){//口味
                        if(i == 0){
                            $(".flavors").append("<a href='#' onclick='flavors_active(this,"+i+")' class='button active'>"+flavors[i].name+"</a>");
                        }else{
                            $(".flavors").append("<a href='#' onclick='flavors_active(this,"+i+")' class='button '>"+flavors[i].name+"</a>");
                        }

                    }
                }

            }
        }
    })
}
//收藏页面
function collection_ajax() {
    $.ajax({
        url:host+"collect_findUserAll.htm",
        type:"post",
        data:{"userId":uid},
        success:function (data) {
            if(data.result == true){
                data = data.data;
                var _html = "",pid,img_url,pname,sales,price;
                $("#collection").html("");
                for(var i = 0; i < data.length; ++i) {
                    pid = data[i].product_id;
                    img_url = host_img + "product/" + data[i].product_img;
                    pname = data[i].product_name;
                    sales = data[i].sales;
                    price = data[i].new_price;

                    _html += "<li><a href='product_info.html?"+pid+"' class='item-link item-content'>";
                    _html += "<div class='item-media'><img src='"+img_url+"' ></div>";
                    _html += "<div class='item-inner'><div class='item-title '><b style='product_name_style'>"+pname+"</b></div>";
                    _html += "<div class='item-title'>销量："+sales+"</div><div class='item-title-row'>";
                    _html += "<div class='item-title price_style'>$ <b>"+price+"</b></div>";
                    _html += "<div class='item-after remove_btn' onclick='return remove_collecton_ajax(this,event,"+pid+")'><font color='white'>移除</font></div>";
                    _html += "</div></div></a></li>";
                }
                $("#collection").html(_html);
            }
        }
    })

}
//取消收藏
function remove_collecton_ajax(t,e,pid) {
    $.showPreloader();
    $.ajax({
        url:host+"collect_add.htm",
        type:"post",
        data:{"productId":pid,"userId":uid},
        success:function (data) {
            $.hidePreloader();
            if(data.result){
                $(t).parents(".item-link").remove();
            }
            $.toast(data.data);
        }
    })
    e.stopPropagation();
    return false;
}
//添加收藏
function add_collection_ajax(t,pid) {
    $.showPreloader();
    $.ajax({
        url:host+"collect_add.htm",
        type:"post",
        data:{"productId":pid,"userId":uid},
        success:function (data) {
            $.hidePreloader();
            if(data.result){
                change_collect(t);
            }
            $.toast(data.data);
        }
    })
}
//加入购物车
function add_shopping_ajax(cart_data) {
    $.showPreloader();
    $.ajax({
        url:host+"cart_add.htm",
        type:"post",
        data:cart_data,
        success:function (data) {
            $.hidePreloader();
            $.toast(data.data);
        }
    })
}
//显示购物车页面
function shopping_ajax() {
    $.ajax({
        url:host+"cart_findMyCart.htm",
        type:"post",
        data:{userId:uid},
        success:function (data) {
            if(data.result){
                data = data.data;
                var business_id;
                var _html = "";
                for(var i = 0; i <data.length; ++i){
                    var product_item_id = data[i].product_item_id;
                    var business_name = data[i].name;
                    var business_img = host_img + "business/" + data[i].photo;
                    var product_id = data[i].product_id;
                    var product_name = data[i].product_name;
                    var product_img = host_img + "product/" + data[i].product_img;
                    var product_number = data[i].product_number;
                    var product_price = data[i].price;
                    var flavor = data[i].flavor_and_product == null ? "" : data[i].flavor_and_product;
                    var size = data[i].size_and_product == null ? "" : data[i].size_and_product;
                    if(i == 0){
                        business_id = data[i].business_id;
                        _html += "<ul style='margin-bottom: 1.5rem' class='business_product'>";
                        _html += "<label class='label-checkbox item-content shop_title business' onclick='business_select(this)'>";
                        _html += "<input type='checkbox' name='business' class='business_select'>";
                        _html += "<div class='item-media store_name_checkbox'>";
                        _html += "<i class='icon icon-form-checkbox' style='margin-left: -10px;margin-top: -2px;width: 15px;height: 15px'></i>";
                        _html += "<img src='"+business_img+"' alt='loading'></div><div class='item-inner store_name' style='border: 0;'>";
                        _html += "<div class='item-text'>"+business_name+"</div></div></label>";
                    }else{
                        //当前商品所属的商家和上一个商品的商家id不一致时，那么重新创建一个商家项.并重置当前商家id
                        if(business_id != data[i].business_id){
                            business_id = data[i].business_id;
                            //每结束一个商家先闭合ul标签再创建一个商家
                            _html += "</ul>";
                            _html += "<ul style='margin-bottom: 1.5rem' class='business_product'>";

                            _html += "<label class='label-checkbox item-content shop_title business' onclick='business_select(this)'>";
                            _html += "<input type='checkbox' name='business' class='business_select'>";
                            _html += "<div class='item-media store_name_checkbox'>";
                            _html += "<i class='icon icon-form-checkbox' style='margin-left: -10px;margin-top: -2px;width: 15px;height: 15px'></i>";
                            _html += "<img src='"+business_img+"' alt='loading'></div><div class='item-inner store_name' style='border: 0;'>";
                            _html += "<div class='item-text'>"+business_name+"</div></div></label>";
                        }
                    }
                    //添加商品项
                    _html += "<li class='swipeout product' onclick='product_select(this)'>";
                    _html += "<input type='hidden' class='item_id' value='"+product_item_id+"'><div class='swipeout-content'>";
                    _html += "<input type='hidden' class='product_id' value='"+product_id+"'>";
                    _html += "<label class='label-checkbox item-content'><input type='checkbox' name='product' class='product_select'>";
                    _html += "<div class='item-media'>";
                    _html += "<i class='icon icon-form-checkbox' style='margin-left: -10px;width: 15px;height: 15px'></i>";
                    _html += "<img src='"+product_img+"' alt='loading'></div><div class='item-inner'>";
                    _html += "<div class='item-text'><b>"+product_name+"</b></div><div class='item-text'>";
                    _html += "<span class='kind'>"+flavor+" "+size+"</span>";
                    _html += "<span class='price'>￥<span class='product_price'>"+product_price+"</span>元</span>";
                    _html += "<span class='number'>x<span class='product_number'>"+product_number+"</span></span></div></div></label></div>";
                    _html += "<div class='swipeout-actions-right'>";
                    _html += "<a class='bg-danger swipeout-delete ' href='#' data-confirm='确定要删除该商品吗？' data-confirm-title='提示'>删除</a>";
                    _html += "<a class='swipeout-close' href='#'>取消</a></div></li>";
                }
                _html += "</ul>";

                //商品删除事件
                _html += "<script>";
                _html += "$(function () {";
                _html += "$('.swipeout').on('deleted', function () {";
                _html += "delete_product(this);});})</script>";

                $("#shopping_content").html(_html);
            }
        }
    })

}
//删除购物车的商品项
function delete_product_item_ajax(item_id) {
    $.ajax({
        url:host+"cart_delete.htm",
        type:"post",
        data:{"item.productItemId":item_id},
        success:function (data) {
            $.toast(data.data);
        }
    })
}
