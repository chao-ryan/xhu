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
                    </ul>
                </div>
            </div>
        </div>
        <!-- 内容显示 -->
        <div class="content-box" id="content_box">
            <!-- 添加班级信息页面弹出层 -->
            <div class="classinfo-add-pop-up-box" id="classinfo-add-pop-up-box" style="display: block">
                <div class="update-pop-up-head-box">
                    <div class="update-pop-up-head-word-box">
                        <span>添加信息</span>
                    </div>
                    <div class="update-pop-up-head-close-box">
                        <button type="button" class="update-pop-up-close-button" value="关闭" onclick="closeadd()" id="close_add_class">
                            <a href="${pageContext.request.contextPath}/action/classInfo!classInfoShow.do">
                                <span>X</span>
                            </a>
                        </button>
                    </div>
                </div>
                <div class="update-pop-up-body-box">
                    <div class="pop-up-body-form-box">
                        <form method="post" action="${pageContext.request.contextPath}/action/classInfo!classAdd.do">
                            <label class="class-number" for="L-title_number_add">班级编号</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_number_add" value="" required="required" name="classNumAdd" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-name" for="L-title_name_add">班级名称</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_name_add" value="" required="required" name="classNameAdd" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-college" for="L-title_college_add">所属学院</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_college_add" value="" required="required" name="classCollegeAdd" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-stunumber" for="L-title_stunumber_add">学生人数</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_stunumber_add" name="classStuNumAdd" autocomplete="off"/>
                            </div><br/>
                            <label class="class-teacher" for="L-title_teacher_add">辅导员</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_teacher_add" value="" required="required" name="classTeacherAdd" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-major" for="L-title_major_add">年级专业</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_major_add" value="" required="required" name="classMajorAdd" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-year" for="L-title_year_add">年级</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_year_add" value="" required="required" name="classYearAdd" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/><br/>
                            <div class="pop-up-body-button-box">
                                <button type="submit" class="add-button" value="添加" id="classinfo_add_button">
                                    <span>添加</span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    <!-- jqeury事件-->
    $(document).ready(function () {
//        个人信息content
        //    <!-- 打开编辑页面弹出层 -->
        $("#update_per").click(function () {
            $("#d1").hide();
            $("#fade").fadeIn();
            $("#per-update-pop-up-box").slideDown();
        });
        //        关闭编辑弹出层
        $("#close_update_per").click(function () {
            $("#per-update-pop-up-box").slideUp();
            $("#fade").fadeOut();
            $("#d1").slideDown();
        });
//    班级信息content
        //    <!-- 打开编辑页面弹出层 -->
        $("#update_class").click(function () {
            $("#d3").hide();
            $("#fade").fadeIn();
            $("#classinfo-update-pop-up-box").slideDown();
        });
        //        关闭编辑弹出层
        $("#close_update_class").click(function () {
            $("#classinfo-update-pop-up-box").slideUp();
            $("#fade").fadeOut();
            $("#d3").slideDown();
        });
        //        打开添加页面弹出层
        $("#add_class").click(function () {
            $("#d3").hide();
            $("#fade").fadeIn();
            $("#classinfo-add-pop-up-box").slideDown();
        });
        //        关闭添加页面弹出层
        $("#close_add_class").click(function () {
            $("#classinfo-add-pop-up-box").slideUp();
            $("#fade").fadeOut();
            $("#d3").slideDown();
        });
//    学院信息content
        //    <!-- 打开编辑页面弹出层 -->
        $("#update_college").click(function () {
            $('#d4').hide();
            $("#fade").fadeIn();
            $("#college-update-pop-up-box").slideDown();
        });
        //        关闭编辑弹出层
        $("#close_update_college").click(function () {
            $("#college-update-pop-up-box").slideUp();
            $("#fade").fadeOut();
            $("#d4").slideDown();
        });
        //        打开添加页面弹出层
        $("#add_college").click(function () {
            $("#d4").hide();
            $("#fade").fadeIn();
            $("#college-add-pop-up-box").slideDown();
        });
        //        关闭添加页面弹出层
        $("#close_add_college").click(function () {
            $("#college-add-pop-up-box").slideUp();
            $("#fade").fadeOut();
            $("#d4").slideDown();
        });
        //       学院-班级点击事件
        $("#college_link_class").click(function () {
            $("#d4").hide();
            $("#fade").fadeIn();
            $("#d3").slideDown();
        })
//        学生信息content
        //    <!-- 打开编辑页面弹出层 -->
        $("#update_student").click(function () {
            $('#d5').hide();
            $("#fade").fadeIn();
            $("#student-update-pop-up-box").slideDown();
        });
        //        关闭编辑弹出层
        $("#close_update_student").click(function () {
            $("#student-update-pop-up-box").slideUp();
            $("#fade").fadeOut();
            $("#d5").slideDown();
        });
        //        打开添加页面弹出层
        $("#add_student").click(function () {
            $("#d5").hide();
            $("#fade").fadeIn();
            $("#student-add-pop-up-box").slideDown();
        });
        //        关闭添加页面弹出层
        $("#close_add_student").click(function () {
            $("#student-add-pop-up-box").slideUp();
            $("#fade").fadeOut();
            $("#d5").slideDown();
        });
        //        学生-宿舍点击事件
        $("#stu_to_room").click(function () {
            $("#d5").hide();
            $("#fade").fadeIn();
            $("#d6").slideDown();
        });
        //       学生-班级点击事件
        $("#stu_to_class").click(function () {
            $("#d5").hide();
            $("#fade").fadeIn();
            $("#d3").slideDown();
        });
//        宿舍信息cotent
        //    <!-- 打开编辑页面弹出层 -->
        $("#update_room").click(function () {
            $('#d6').hide();
            $("#fade").fadeIn();
            $("#room-update-pop-up-box").slideDown();
        });
        //        关闭编辑弹出层
        $("#close_update_room").click(function () {
            $("#room-update-pop-up-box").slideUp();
            $("#fade").fadeOut();
            $("#d6").slideDown();
        });
        //        打开添加页面弹出层
        $("#add_room").click(function () {
            $("#d6").hide();
            $("#fade").fadeIn();
            $("#room-add-pop-up-box").slideDown();
        });
        //        关闭添加页面弹出层
        $("#close_add_room").click(function () {
            $("#room-add-pop-up-box").slideUp();
            $("#fade").fadeOut();
            $("#d6").slideDown();
        });
    });
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
</script>
</body>
</html>