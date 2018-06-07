<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset=UTF-8>
    <title>操作失误</title>
    <link href="${pageContext.request.contextPath}/css/failed.css" rel="stylesheet"/>
</head>
<body>
<h2>不好意思啦，由于服务器出去约会去啦，您的操作暂时无法处理，请稍候继续吧</h2>
<div class="return-button-box">
    <ul>
        <li>
            <a id="failed_return" href="${pageContext.request.contextPath}/jsp/personSetting.jsp">点击这里返回试试</a>
        </li>
    </ul>
</div>
</body>
</html>