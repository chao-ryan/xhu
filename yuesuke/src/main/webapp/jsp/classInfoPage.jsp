<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>信息管理</title>
    <link href="${pageContext.request.contextPath}/css/setting.css" rel="stylesheet">
    <!--<script type="text/javascript" src="../js/setting.js"></script>-->
    <script src="${pageContext.request.contextPath}/js/jquery.js" charset="utf-8"></script>
</head>
<body>
<div class="beg-login-box">
    <!-- 头部开始-->
    <div class="top-box">
        <!--logo开始-->
        <div class="logo-window-box">
            <div class="logo-box">
                <a class="site-url" href="##">
                    <img class="site-logo" src="${pageContext.request.contextPath}/img/logo-site.png">
                </a>
            </div>
            <div class="to-mainpage-box">
                <span class="to-mainpage-button"><a href="personSetting.jsp" class="step-button">信息管理</a>
                    <<
                    <a href="${pageContext.request.contextPath}/jsp/mainPage.jsp" class="step-button">返回首页</a></span>
            </div>
        </div>
    </div>
    <!-- 显示body -->
    <div class="column">
        <!-- 列栏显示区 -->
        <div class="show-message-box">
            <div class="show-img-box"></div>
            <!-- 列栏 -->
            <div class="column-menu-box">
                <!-- 列栏head -->
                <div class="column-head-box">
                    <h3 class="column-head">
                        <span class="column-anchor">信息管理</span>
                    </h3>
                </div>
                <!-- 列栏body -->
                <div class="column-list-box">
                    <ul class="column-list-item-person">
                        <li class="column-list-item-1">
                            <a href="${pageContext.request.contextPath}/action/personSetting!person.do" onclick="show(1)" name="by" id="b1">
                                <span class="column-name">个人信息</span>
                            </a>
                        </li>
                        <li class="column-list-item-2">
                            <a  href="${pageContext.request.contextPath}/jsp/passwordUpdatePage.jsp" title="密码修改" class="column-item-link" name="by" id="b2" onclick="show(2)">
                                <span class="column-name">密码修改</span>
                            </a>
                        </li>
                        <li class="column-list-item-3">
                            <a  href="${pageContext.request.contextPath}/action/classInfo!classInfoShow.do" title="班级信息" class="column-item-link" name="by" id="b3" onclick="show(3)">
                                <span class="column-name">班级信息</span>
                            </a>
                        </li>
                        <li class="column-list-item-4">
                            <a  href="${pageContext.request.contextPath}/action/college!collegeShow.do" title="学院信息" class="column-item-link" name="by" id="b4" onclick="show(4)">
                                <span class="column-name">学院信息</span>
                            </a>
                        </li>
                        <li class="column-list-item-5">
                            <a  href="${pageContext.request.contextPath}/action/student!stuShow.do" title="学生信息" class="column-item-link" name="by" id="b5" onclick="show(5)">
                                <span class="column-name">学生信息</span>
                            </a>
                        </li>
                        <li class="column-list-item-6">
                            <a href="${pageContext.request.contextPath}/action/room!roomShow.do" title="宿舍信息" class="column-item-link" name="by" id="b6" onclick="show(6)">
                                <span class="column-name">宿舍信息</span>
                            </a>
                        </li>
                        <li class="column-list-item-7">
                            <a href="${pageContext.request.contextPath}/action/schooling!show.do" title="学费详情" class="column-item-link" name="by" id="b7" onclick="show(7)">
                                <span class="column-name">学费详情</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 内容显示 -->
        <div class="content-box" id="content_box">
            <!-- 班级信息content -->
            <div class="content-classinfo-box" id="d3" name="dv" style="display: block">
                <form class="content-classinfo-form" action="">
                    <div class="classinfo-search-box">
                        <div class="classinfo-name-box">
                            <input type="text" placeholder="班级名字" name="className" autocomplete="off" class="classinfo-name" id="class_name">
                        </div>
                        <div class="classinfo-search-button-box">
                            <button class="classinfo-search-button" onclick="findClass()" lay-submit="" lay-filter="sreach" type="submit"><span>查找</span></button>
                        </div>
                    </div>
                </form>
                <div class="classinfo-add-box">
                    <button class="classinfo-add-button" onclick="add()" id="add_class">
                        <a href="${pageContext.request.contextPath}/jsp/classInfoAddPage.jsp">
                            <span>添加</span>
                        </a>
                    </button>
                </div>
                <div class="classinfo-table-box">
                    <table class="classinfo-table">
                        <thead>
                        <tr>
                            <th class="class-table-no">
                                班级编号
                            </th>
                            <th class="class-table-name">
                                班级名称
                            </th>
                            <th class="class-table-college">
                                所在学院
                            </th>
                            <th class="class-table-stu">
                                学生人数
                            </th>
                            <th class="class-table-teacher">
                                辅导员
                            </th>
                            <th class="class-table-major">
                                班级专业
                            </th>
                            <th class="class-table-year">
                                班级年级
                            </th>
                            <th class="class-table-more">
                                备注
                            </th>
                            <th class="class-table-option">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <c:forEach items="${relationList}" var="classRelation">
                            <tbody>
                            <tr>
                                <td id="classInfo_classNumber">
                                    <u onclick="unique()">
                                            ${classRelation.getClassInfoId().getNumber()}
                                    </u>
                                </td>
                                <td id="classInfo_className">
                                    <a id="class_name_show" href="${pageContext.request.contextPath}/action/classInfo!currentClass.do?method=current&class_currnt=${classRelation.getClassInfoId().getName()}">
                                            ${classRelation.getClassInfoId().getName()}
                                    </a>
                                </td>
                                <td id="classInfo_collegeName">
                                        ${classRelation.getCollegeId().getName()}
                                </td>
                                <td id="classInfo_stuNumber">
                                        ${classRelation.getClassInfoId().getStudentsNumber()}
                                </td>
                                <td id="classInfo_teacherName">
                                        ${classRelation.getClassInfoId().getTeachersId().getName()}
                                </td>
                                <td id="classInfo_major">
                                        ${classRelation.getClassInfoId().getMajor()}
                                </td>
                                <td id="classInfo_year">
                                        ${classRelation.getGrade()}
                                </td>
                                <td>

                                </td>
                                <td class="classinfo-option">
                                    <a title="编辑" href="${pageContext.request.contextPath}/action/classInfo!toClassUpdate.do?toUpClassName=${classRelation.getClassInfoId().getName()}" onclick="update()" id="update_class">
                                        <img src="${pageContext.request.contextPath}/img/look.png" class="option-img"/>
                                    </a>
                                    &emsp;|&emsp;
                                    <a title="删除" href="${pageContext.request.contextPath}/action/classInfo!delClass.do?method=del&delClassId=${classRelation.getClassInfoId().getId()}" id="delete_classinfo">
                                        <img src="${pageContext.request.contextPath}/img/delete.jpg" class="option-img"/>
                                    </a>
                                </td>
                            </tr>
                            </tbody>
                        </c:forEach>

                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    //    菜单栏点击事件
    function show(id) {
        var divs=document.getElementsByName("dv");
        var bodys=document.getElementsByName("by");
        //当点击菜单栏时，显示对应菜单内容
        for(var i=0;i<divs.length;i++){
            if (divs[i].id == "d"+id){
                divs[i].style.display="";
            }else {
                divs[i].style.display="none";
            }
        };
        //当点击菜单栏时，该菜单字体颜色变为橙色
        for(var k=0;k<bodys.length;k++){
            if (bodys[k].id == "b"+id){
                bodys[k].style.color="darkorange";
            }else {
                bodys[k].style.color="blue";
            }
        };
    }
    //    AJAX
    //班级信息-查找
    function findClass(){
        alert("请确认！");
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/action/classInfo!classInfoShow.do",
            data:{className:$("#class_name").val()},
            dataType:'json'
        });
    }
</script>
</body>
</html>