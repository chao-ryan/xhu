<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>西华大学</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet"/>
</head>
<body background="${pageContext.request.contextPath}/img/xhu_zhuoyue.jpg">
<h1>Hi，Dear！Welcom to XHU</h1>
<form id="form1" runat="server">
    <div id="time_div">

    </div>
</form>
<script type="text/javascript">
    //        设定倒计时秒数
    var t=2;
    //        显示倒计时秒数
    function showTime() {
        t -= 1;
        document.getElementById("time_div").innerHTML=t;
        if (t == 0){
            location.href="${pageContext.request.contextPath}/jsp/mainPage.jsp";
        }
//        每秒执行一次,showTime
        setTimeout("showTime()",1000);
    }
    //    执行showTime()
    showTime();
</script>
</body>
</html>
