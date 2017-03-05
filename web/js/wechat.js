/**
 *      当用户每次进入 client/index.html 页面时，判断 url 中的参数是否合法（避免用户
 *      跳过认证直接进入）
 * **/

//从 url 中判断参数是否合法  不合法直接跳转认证页面
function saveOpenid() {
    //从地址中截取openid
    var data = location.href.split("?");
    if(data.length != 5){
        turn_to_auto();
    }

    //将获取到的用户信息保存到 Cookie 中
    var openid = data[1];
    var nickname = data[2];
    var headimgurl = data[3];
    var userId = data[4];
    setCookie("openid",openid,365);
    setCookie("nickname",nickname,365);
    setCookie("headimgurl",headimgurl,365);
    setCookie("userId",userId,365);

    //设置全局 uid
    uid = userId;
}
//获取用户信息
function getUserInfo() {
    if(getCookie("openid") == null || getCookie("openid") ==""){
        turn_to_auto();
        return;
    }
    var userInfo = {
        "openid":getCookie("openid"),
        "nickname":getCookie("nickname"),
        "headimgurl":getCookie("headimgurl"),
        "userId":getCookie("userId")
    }
    return userInfo;
}
//获取用户id
function getUserId() {
    var userInfo = getUserInfo();
    return userInfo.userId;

}
//跳转授权
function turn_to_auto() {
    location.href = "http://obao.tunnel.2bdata.com/";
}

//cookie设置或获取
function setCookie(c_name,value,expiredays)
{
    var exdate=new Date()
    exdate.setDate(exdate.getDate()+expiredays)
    document.cookie=c_name+ "=" +escape(value)+
        ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
}

//取回cookie
function getCookie(c_name)
{
    if (document.cookie.length>0)
    {
        c_start=document.cookie.indexOf(c_name + "=")
        if (c_start!=-1)
        {
            c_start=c_start + c_name.length+1
            c_end=document.cookie.indexOf(";",c_start)
            if (c_end==-1) c_end=document.cookie.length
            return unescape(document.cookie.substring(c_start,c_end))
        }
    }
    return ""
}
