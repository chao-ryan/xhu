<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp" %>
<link href="${pageContext.request.contextPath}/css/store_home_page_css.css" rel="stylesheet" />
<html>
<head>
    <title>开店页面</title>
</head>
<body>
<jsp:include page="head_page.jsp"></jsp:include>
<div class="people_open_store">
    <form name="openStore" action="${pageContext.request.contextPath}/action/openStore!doPost.do" method="post" align="center">
        <p>您还未开通店铺，如果需要开通店铺请输入店铺名，点击确认开通即可开通店铺</p>
        <input type="hidden" name="peopleId" value="${person.getId()}">
        <input type="text" name="storeName">
        <input type="submit" value="开通">
        <a href="${pageContext.request.contextPath}/action/storeHome!doPost.do"> <input type="button" value="返回"></a>
    </form>
</div>
</body>
</html>
