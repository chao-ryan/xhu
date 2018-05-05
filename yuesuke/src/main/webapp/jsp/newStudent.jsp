<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>YS欢迎您</title>
    <link href="../css/main.css" rel="stylesheet">
</head>
<body>
<div class="beg-login-box">
    <!-- 头部开始-->
    <div class="top-box">
        <!--logo开始-->
        <div class="logo-window-box">
            <div class="logo-box">
                <a class="site-url" href="##">
                    <img class="site-logo" src="../image/logo-site.png">
                </a>
            </div>
            <div class="to-mainpage-box">
                <span class="to-mainpage-button">
                    <a href="mainPage.jsp">
                        首页<<
                    </a>
                </span>
            </div>
        </div>
        <!-- 列表-->
        <div class="selection-box">
            <ul>
                <li class="main-level-1">
                    <a class="xhu-info" href="mainPage.jsp" target="_self">学校简介</a>
                </li>
                <li class="main-level-1">
                    <a class="xhu-new-method" href="newStudent.jsp" target="_self">报道流程</a>
                </li>
                <li class="main-level-1">
                    <a class="xhu-login" href="login.jsp" target="_self">新生报道</a>
                </li>
                <li class="main-level-1">
                    <a class="xhu-setting" href="personSetting.jsp" target="_self">信息管理</a>
                </li>
            </ul>
        </div>
        <!-- 头部结束 -->
    </div>
    <!-- 水平线 -->
    <div class="line-level-box">
        <hr noshade="noshade" style="background-color: #88a3ff;height: 2px"/>
    </div>
    <!-- 显示区 -->
    <div class="show-message-box">
        <div class="show-img-box"></div>
        <div class="show-info-box" fra="面板1">
            <h3>报道流程</h3>
            <div class="show-column-box">
                <p class="show-article">
                    1、新生持录取通知书到新生报到处录入通知书编号，确认报名信息后领取新生报道单，交回录取通知书。
                </p>
                <p>
                    2、新生或新生家长认真填写新生报道单中相关信息。
                </p>
                <p>
                    3、新生填写完新生报道单后，到所属学院确认专业并签字，并确认自己班级、学号，然后到各行政班辅导员处领取相应资料并认真填写。
                </p>
                <p>
                    4、填写完班级资料后到行政处签字，并领取学费、住宿费、保险费的缴费凭单。
                </p>
                <p>
                    5、带上缴费凭单，到学校财务处缴纳本学年度应缴学费、住宿费、保险费。注：学费缴纳可接收中国工商银行、中国银行、中国农业银行、光大银行、招商银行、
                    农村信用卡以及微信和支付宝。现金支付需到财务处第9窗口，谢谢配合！
                </p>
                <p>
                    6、新生凭缴费收据到一卡通处（二教1楼）领取校园一卡通。
                </p>
                <p>
                    7、新生凭缴费收据到所在学院物资处根据分配的宿舍领取对应钥匙，确认宿舍楼号、房间号及床位号，录入门禁信息。
                </p>
                <p>
                    8、新生凭缴费收据到所在学院领取报到材料，签订“学生安全责任书”等，同时领取军训所需教材。
                </p>
                <p>
                    注：
                </p>
                <p>
                    新生在报道过程中遇到问题可拨打电话<span id="help-phone">028-35989</span>，或找到新生服务点，或到学校门卫室说明困难并寻求帮助。
                </p>
            </div>
        </div>
    </div>
</div>

</body>
</html>