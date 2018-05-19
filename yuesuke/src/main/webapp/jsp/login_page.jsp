<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>欢迎登录</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_page_css.css">
</head>
<body>

<jsp:include page="head_page.jsp"></jsp:include>

<div class="ground">
    <div class="div">
        <span class="title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;YS跳蚤市场</span>

        <form id="login" name="Login" action="${pageContext.request.contextPath}/action/loginPage!doPost.do" method="post" class="form">
            <table border="0" class="table">
                <tr>
                    <td>账号：</td>
                    <td><input autofocus="autoFocus" type="text" name="username"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password">
                    </td>
                </tr>
            </table>
            <br>&nbsp;&nbsp;
            <input type="button" onclick='location.href=("${pageContext.request.contextPath}/jsp/registration_page.jsp")' value="注册"/>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <input type="button" name="login" value="登录" id="submit" onclick="submit()"/>
        </form>
        <%--<c:choose>--%>
        <%--<c:when test="${LoginMessage eq 'error'}">--%>
        <%--<span>用户名不存在或密码错误</span>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
        <%--<span>登录成功</span>--%>
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>
    </div>
</div>

<script type="text/javascript">
    <%--function toVaild() {--%>
    <%--var test = ${LoginMessage}--%>
    <%--if (test == "error") {--%>
    <%--alert("用户名不存在或密码错误!\n请重新输入或注册");--%>
    <%--} else {--%>
    <%--alert("成功登录");--%>
    <%--}--%>
    <%--}--%>

        $('#submit').live("click", function ()  {
            var username = $("input[name='username']").val();
            var password = $("input[name='password']").val();
            $.ajax({
                type: "post",
                dataType: "json",
                data: {
                    username: username, password: password
                },
                url: "${pageContext.request.contextPath}/action/loginPage!doPost.do",
                //                contentType:"text",
                success: function (x) {
                    alert("登陆成功！！！");
                    window.location.replace("${pageContext.request.contextPath}/action/mainAction!main.do");
                },
                error: function (XMLResponse) {
                    alert("登陆失败！用户名或者密码错误！或者该账户未注册！")
                }
            })
    })

</script>

</body>
</html>
