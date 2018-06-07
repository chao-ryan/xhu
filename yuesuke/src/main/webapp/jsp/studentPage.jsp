<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.util.FormatUtils" %>
<%@ page import="com.tools.SexEnum" %>
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
            <!-- 学生信息content -->
            <div class="content-student-box" id="d5" name="dv" style="display: block">
                    <div class="student-search-box">
                        <div class="student-account-box">
                            <input type="text" placeholder="学号" class="student-account" id="student_account">
                        </div>
                        <div class="student-search-button-box">
                            <button class="student-search-button" onclick="findStu()" type="button" value="查找">
                                <span>查找</span>
                            </button>
                        </div>
                    </div>
                <div class="student-add-box">
                    <button class="student-add-button" id="add_student">
                        <a href="${pageContext.request.contextPath}/jsp/studentAddPage.jsp">
                            <span>添加</span>
                        </a>
                    </button>
                </div>
                <div class="student-table-box">
                    <table class="student-table">
                        <thead>
                        <tr>
                            <th class="student-table-account">
                                学号
                            </th>
                            <th class="student-table-name">
                                姓名
                            </th>
                            <th class="student-table-sex">
                                性别
                            </th>
                            <th class="student-table-birth">
                                出生年月
                            </th>
                            <th class="student-table-origin">
                                籍贯
                            </th>
                            <th class="student-table-enthnic">
                                民族
                            </th>
                            <th class="student-table-idNumber">
                                身份证号
                            </th>
                            <th class="student-table-university">
                                学校
                            </th>
                            <th class="student-table-phone">
                                手机号
                            </th>
                            <th class="student-table-room">
                                宿舍信息
                            </th>
                            <th class="student-table-college">
                                所在学院
                            </th>
                            <th class="student-table-major">
                                专业
                            </th>
                            <th class="student-table-class">
                                班级
                            </th>
                            <th class="student-table-fname">
                                父亲
                            </th>
                            <th class="student-table-fphone">
                                父亲联系方式
                            </th>
                            <th class="student-table-mname">
                                母亲
                            </th>
                            <th class="student-table-mphone">
                                母亲联系方式
                            </th>
                            <th class="student-table-option">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <c:forEach items="${relationList}" var="relation">
                            <tbody>
                            <tr>
                                <td id="stuAccount">
                                    ${relation.getStudentsId().getAccountId().getAccountNumber()}
                                </td>
                                <td id="stuName">
                                        ${relation.getStudentsId().getName()}
                                </td>
                                <td id="stuSex">
                                        ${SexEnum.findSexByIndex(relation.getStudentsId().getGender())}
                                </td>
                                <td id="stuBirthDay">
                                        ${FormatUtils.dateFormat(relation.getStudentsId().getBirthday())}
                                </td>
                                <td id="stuOrigin">
                                        ${relation.getStudentsId().getOrigin()}
                                </td>
                                <td id="stuEnthnic">
                                        ${relation.getStudentsId().getEnthnic()}
                                </td>
                                <td id="stuIdNum">
                                        ${relation.getStudentsId().getIdNumber()}
                                </td>
                                <td id="stuUniversity">
                                        ${relation.getStudentsId().getUniversity()}
                                </td>
                                <td id="stuPhone">
                                        ${relation.getStudentsId().getPhone()}
                                </td>
                                <td id="stuRoom">
                                    <a id="stu_to_room" href="${pageContext.request.contextPath}/action/room!roomShow.do?stuToRoomId=${relation.getStudentsId().getRoomId().getId()}" title="点击查看宿舍信息">
                                        ${relation.getStudentsId().getRoomId().getArea()}-${relation.getStudentsId().getRoomId().getLoudong()}-${relation.getStudentsId().getRoomId().getFloorNumber()}-${relation.getStudentsId().getRoomId().getRoomNumber()}
                                    </a>
                                </td>
                                <td id="stuCollege">
                                        ${relation.getCollegeId().getName()}
                                </td>
                                <td id="stuMajor">
                                        ${relation.getClassInfoId().getMajor()}
                                </td>
                                <td id="stuClass">
                                    <a id="stu_to_class" href="${pageContext.request.contextPath}/action/classInfo!currentClass.do?method=current&class_currnt=${relation.getClassInfoId().getName()}" title="点击查看班级信息">
                                        ${relation.getClassInfoId().getName()}
                                    </a>
                                </td>
                                <td id="stuFatherName">
                                        ${relation.getStudentsId().getFatherName()}
                                </td>
                                <td id="stuFatherPhone">
                                        ${relation.getStudentsId().getFatherPhone()}
                                </td>
                                <td id="stuMotherName">
                                        ${relation.getStudentsId().getMotherName()}
                                </td>
                                <td id="stuMotherPhone">
                                        ${relation.getStudentsId().getMotherPhone()}
                                </td>
                                <td class="student-option">
                                    <a title="编辑" href="${pageContext.request.contextPath}/action/student!toStuUpdate.do?toUpStuAccount=${relation.getStudentsId().getAccountId().getAccountNumber()}" onclick="update_student()" id="update_student">
                                        <img src="${pageContext.request.contextPath}/img/look.png" class="option-img"/>
                                    </a>
                                    <!--&emsp;|&emsp;-->|
                                    <a title="删除" href="${pageContext.request.contextPath}/action/classInfo!delClass.do?method=del&delClassId=${relation.getStudentsId().getId()}" id="delete_student">
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
    //学生信息-查找
    function findStu(){
        alert("请确认！");
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/action/student!stuShow.do",
            data:{stuAccount:$("#student_account").val()},
            dataType:'json'
        });
    }
</script>
</body>
</html>