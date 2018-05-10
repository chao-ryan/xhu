<%@ page import="com.domain.Store" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp" %>
<html>
<head>
    <title>store_home_page</title>
    <link href="${pageContext.request.contextPath}/css/store_home_page_css.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/head_page_css.css">
</head>
<body>
<jsp:include page="head_page.jsp"></jsp:include>
<div class="body">
    <div class="store_home">
        <div class="store_home_left">
            <div class="store_home_storeInfo">
                <h4>${stores[0].storeName} </h4>
                <br><br>

                <div class="storeInfo_font">
                    店主：${person.name}
                </div>
            </div>
            <div class="store_home_delivery">
                <a href="${pageContext.request.contextPath}/storeSetStockAction!selectStoreGoods.do?storeId=${stores[0].id}"><h4>我要进货</h4></a>
            </div>
            <div class="store_home_delivery">
                <a href="${pageContext.request.contextPath}/orderDetailAction!storeOrder.do?storeId=${stores[0].id}"><h4>我要发货</h4></a>
            </div>
            <div class="store_home_delivery">
                <a href="${pageContext.request.contextPath}/orderDetailAction!storeOrder.do?storeId=${stores[0].id}"><h4>历史订单</h4></a>
            </div>
            <div class="store_home_delivery">
                <a href="${pageContext.request.contextPath}/orderDetailAction!storeOrder.do?storeId=${stores[0].id}"><h4>最近订单</h4></a>
            </div>
        </div>
        <div class="store_home-right">
            <div class="store_home_goodsListHead">
                商品列表
            </div>
            <c:if test="${mainPages==null||fn:length(mainPages)==0}">
                <h2>你还没有商品上架！</h2>
            </c:if>
            <c:forEach items="${mainPages}" var="mainPages" varStatus="status">
                <div class="store_home_good">
                    <div class="store_home_goodImg">
                        <img src="${pageContext.request.contextPath}/img/1.jpg"></src>
                    </div>
                    <div class="store_home_goodInfo">
                        <div class="store_home_goodName">
                        <a href="${pageContext.request.contextPath}/storeAction!offLoading.do?peopleId=${person.id}&&inventoryId=${mainPages.inventoryId}">
                            <input type="button" value="商品下架" />
                            </a>
                            <a href="javascript:void(0)"
                               onclick="document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">
                                <input type="button" value="商品调价" /></a>
                        </div>
                        <div class="store_home_goodName">
                                ${mainPages.name}
                        </div>
                        <div class="store_home_goodPrice">
                                ${mainPages.price}
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="wit">
        <div class="limit">
            <form class="form" name="f1" method="POST" action="#">
                <table border="0" align="center" class="tb">
                    <tr>
                        <td><span class="page-size">当前第 ${present} 页       共 ${total} 页</span>></td>
                        <td><a href="#">首页</a></td>
                        <td><a href="#"> 上一页</a></td>
                        <td><a href="#"> 下一页</a></td>
                        <td><a href="#">最后一页</a></td>
                        <td>转到第:<input type="text" name="page" size="8"
                                       onkeypress="return event.keyCode>=48&&event.keyCode<=57"
                                       ng-pattern="/[^a-zA-Z]/"/>页
                            <input type="submit" value="GO" name="GO"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<%--分类悬浮框--%>
<div id="light" class="white_content">
    <form action="" name="form1" method="post">
        <input type="text">
    </form>
    <a href="javascript:void(0)"
       onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">点击关闭本窗口</a>
</div>
<div id="fade" class="black_overlay"></div>
</body>
</html>
