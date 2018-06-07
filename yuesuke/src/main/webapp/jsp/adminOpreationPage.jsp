<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset=UTF-8>
    <title>管理员设置</title>
    <link href="${pageContext.request.contextPath}/css/adminOpreation.css" rel="stylesheet"/>

</head>
<body background="${pageContext.request.contextPath}/img/adminUpdateBack.jpg">
<!-- 头部开始-->
<div class="top--logo-box">
    <div class="top-inner-box">
        <!--logo开始-->
        <div class="logo-window-box">
            <img class="site-logo" src="${pageContext.request.contextPath}/img/logo-site.png">
        </div>
    </div>
</div>
<div class="opreation-body-box">
    <div class="top-search-box">
        <form action="${pageContext.request.contextPath}/action/adminOpreation!stuSearch.do" method="post">
            <div class="top-search-input-box">
                <input type="text" placeholder="请输入学号" autocomplete="off" name="stuAccount" class="search-account" id="search_account">
            </div>
            <div class="top-search-button-box">
                <button class="top-search-button" lay-submit="" lay-filter="sreach" type="submit" id="search_button" onclick="findStu()">
                    <span>查 找</span>
                </button>
            </div>
        </form>
    </div>
    <div class="content-box">
        <form action="${pageContext.request.contextPath}/action/adminOpreation!update.do" method="post">
            <label for="account">学 号：</label>
            <div class="account-box">
                <input id="account" type="text" value="${students.getAccountId().getAccountNumber()}" readonly="readonly"/>
            </div>
            <label for="stuName">学生姓名：</label>
            <div class="stu-name-box">
                <input id="stuName" type="text" value="${students.getName()}" readonly="readonly"/>
            </div>
            <label for="current_authority">当前权限：</label>
            <div class="current-authority-box">
                <input id="current_authority" type="text" value="${students.getAuthority()}" readonly="readonly"/>
            </div>
            <label>要修改的权限等级：</label>
            <div class="update-authority-box">
                <label id="stu_radio_lable" for="stu_radio">学 生：</label>
                <input type="radio" id="stu_radio" checked="checked" name="authority" value="0"/>
                <label id="teacher_radio_lable" for="teacher_radio">老 师：</label>
                <input type="radio" id="teacher_radio" name="authority" value="1"/>
                <label id="admin_radio_lable" for="admin_radio">管理员：</label>
                <input type="radio" id="admin_radio" name="authority" value="2"/>
            </div>
            <div id="content-button-box">
                <button type="submit" id="submit" onclick="sureUpdate()">确 认</button>
            </div>
        </form>

    </div>
</div>
<script>
    function findStu(){
        alert("请确认");
        <%--$.ajax({--%>
            <%--type:'post',--%>
            <%--url:'${pageContext.request.contextPath}/action/adminOpreation!stuSearch.do',--%>
            <%--data:{stuAccount:$("#search_account").val()},--%>
            <%--dataType:'json'--%>
        <%--});--%>
    }
</script>
</body>
</html>