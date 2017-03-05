<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:redirect url="http://obao.tunnel.2bdata.com/client/index.html?${requestScope.openid}?${requestScope.user.nickname}?${requestScope.user.headimgurl}?${requestScope.user.userId}"></c:redirect>