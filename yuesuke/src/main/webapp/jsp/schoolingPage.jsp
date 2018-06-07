<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset=UTF-8>
    <title>本学期应缴学费</title>
    <link href="${pageContext.request.contextPath}/css/schooling.css" rel="stylesheet">
</head>
<body background="${pageContext.request.contextPath}/img/xhu_night3.jpg">
<div class="schooling-box">
    <div class="top-return-box">
        <a class="top-return" href="${pageContext.request.contextPath}/jsp/personSetting.jsp">
            点击这里可以返回哟
        </a>
    </div>
    <div class="content-table-box">
        <table>
            <thead class="table-thead">
            <th>缴费项目</th>
            <th>书本费</th>
            <th>学费</th>
            <th>住宿费</th>
            <th>其他费用</th>
            <th>总计</th>
            <th>是否已结清</th>
            <th>备注</th>
            </thead>
            <tbody>
            <tr>
                <td>${schooling.getId()}</td>
                <td>${schooling.getBookFee()}</td>
                <td>${schooling.getTuitionFee()}</td>
                <td>${schooling.getBoardingFee()}</td>
                <td>${schooling.getOtherFee()}</td>
                <td>${schooling.getTotalMoney()}</td>
                <td>${pay}</td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>