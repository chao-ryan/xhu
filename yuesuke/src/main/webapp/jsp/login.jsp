<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>欢迎登录</title>
    <link href="../css/login.css" rel="stylesheet">
</head>
<body>
<div class="beg-login-box">
    <div class="snow-container">
        <div class="snow foreground"></div>
        <div class="snow foreground layered"></div>
        <div class="snow middleground"></div>
        <div class="snow middleground layered"></div>
        <div class="snow background"></div>
        <div class="snow background layered"></div>
    </div>
    <!-- 头部开始-->
    <div class="top-box">
        <div class="top-inner-box">
            <!--logo开始-->
            <div class="logo-window-box">
                <a class="site-url" href="##">
                    <img class="site-logo" src="../image/logo-site.png">
                </a>
            </div>
        </div>
    </div>
    <!--<h1 class="header">请在这里登录</h1>-->
    <div class="main-agileits">
        <!--form-stars-here-->
        <div class="form-agile">
            <h2 class="sub-agileits-layouts">登录</h2>
            <form action="/jsp/login.html" method="post">
                <div class="username-box">
                    <label>学生学号：</label><input type="text" name="username" placeholder="用户名" required=""/>
                </div>
                <div class="password-box">
                    <label>身份证号：</label><input type="password" name="password" placeholder="密码" required=""/>
                </div>
                <div class="login-button-box">
                    <button type="submit" name="logining" value="">登录</button>
                </div>
                <p class="siginup-button-box">
                    <a href="mainPage.jsp">点击这里</a>返回主页。
                </p>
            </form>
        </div>
    </div>
</div>

</body>
</html>