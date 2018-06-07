<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset=UTF-8>
    <title>管理员登录</title>
    <link href="${pageContext.request.contextPath}/css/adminLogin.css" rel="stylesheet"/>
</head>
<body background="${pageContext.request.contextPath}/img/adminBack.jpg">
<div class="adminLogin-body-box">
    <div class="top-return-box">
        <a href="${pageContext.request.contextPath}/jsp/mainPag.jsp">
            X
        </a>
    </div>
    <div class="content-box">
        <h2>管理员请登录</h2>
        <div class="form-box">
            <form action="${pageContext.request.contextPath}/action/adminLogin!login.do" method="post" name="adminLoginForm">
                <label for="username">姓 名：</label>
                <div class="username-box">
                    <input type="text" id="username" value="" name="teacherName" placeholder="请输入姓名" required=""/>
                </div>
                <label for="password" id="password_lable">密   码：</label>
                <div class="password-box">
                    <input type="password" id="password" value="" name="teacherIdNum" placeholder="请输入身份证号" required=""/>
                </div>
                <div class="login-button-box">
                    <button type="submit" name="login" value="">登 录</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>