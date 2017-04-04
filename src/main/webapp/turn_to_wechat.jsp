<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="js/wechat.js"></script>

<script>
    window.onload = function() {
        var openid = "${requestScope.user.openid}";
        var nickname = "${requestScope.user.nickname}";
        var headimgurl = "${requestScope.user.headimgurl}";
        var userId = "${requestScope.user.userId}";
        var sex = "${requestScope.user.sex}";
        //如果 openid 为空重新跳转授权
        if(openid == null){
            turn_to_auto();
            return;
        }
        //设置个人信息到cookie
        setUserInfo(openid,nickname,headimgurl,userId,sex);
        //跳转主页
        location.href = "http://obao.tunnel.2bdata.com/client/index.html?"+new Date().getTime();
    }
</script>