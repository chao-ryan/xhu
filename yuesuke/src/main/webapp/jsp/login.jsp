<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>欢迎登录</title>
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
</head>
<body background="${pageContext.request.contextPath}/img/xhu-library.jpg">
<div class="beg-login-box">
    <!-- 头部开始-->
    <div class="top-box">
        <div class="top-inner-box">
            <!--logo开始-->
            <div class="logo-window-box">
                <img class="site-logo" src="${pageContext.request.contextPath}/img/logo-site.png">
            </div>
        </div>
    </div>
    <!--<h1 class="header">请在这里登录</h1>-->
    <div class="main-agileits">
        <!--form-stars-here-->
        <div class="form-agile">
            <h2 class="sub-agileits-layouts">登录</h2>
            <div id="form-box">
                <form action="${pageContext.request.contextPath}/login!loginPage.do" method="post">
                    <label for="stuAccount">学生学号：</label>
                    <div class="username-box">
                        <input type="text" id="stuAccount" name="stuAccount" value="${stuAccount}" placeholder="用户名" required=""/>
                    </div>
                    <label for="stuIdNumber">身份证号：</label>
                    <div class="password-box">
                        <input type="password" id="stuIdNumber" name="stuIdNumber" value="${stuIdNumber}" placeholder="密码" required=""/>
                    </div>
                    <div class="login-button-box">
                        <button type="submit" name="login" value="">登 录</button>
                    </div>
                    <p class="siginup-button-box">
                        <a href="${pageContext.request.contextPath}/jsp/mainPage.jsp">点击这里</a>返回主页。
                    </p>
                </form>
            </div>

        </div>
    </div>
</div>

</body>
</html>