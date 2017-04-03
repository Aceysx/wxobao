
//设置用户信息
function setUserInfo(openid,nickname,headimgurl,userId,sex) {
    sex = sex == 1 ? "男" : "女";
    setCookie("openid",openid,365);
    setCookie("nickname",nickname,365);
    setCookie("headimgurl",headimgurl,365);
    setCookie("userId",userId,365);
    setCookie("sex",sex,365);
    // setCookie("address",province,365);

}
//获取用户信息
function getUserInfo() {
    //如果本地 cookie 中没有用户信息，跳转授权
    if(getCookie("openid") == null || getCookie("openid") == "undefined" || getCookie("openid") == ""){
        turn_to_auto();
        return;
    }
    var userInfo = {
        "openid":getCookie("openid"),
        "userName":getCookie("nickname"),
        "userImg":getCookie("headimgurl"),
        "userId":getCookie("userId"),
        "sex":getCookie("sex"),
        // "address":getCookie("address")
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
    location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3ef4e6cc97e27e16&redirect_uri="+host+"/chat_auto.htm&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
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
