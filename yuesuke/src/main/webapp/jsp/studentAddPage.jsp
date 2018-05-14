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
            <!-- 添加学生信息页面弹出层 -->
            <div id="student-add-pop-up-box" style="display: block">
                <div class="update-pop-up-head-box">
                    <div class="update-pop-up-head-word-box">
                        <span>添加信息</span>
                    </div>
                    <div class="update-pop-up-head-close-box">
                        <button type="button" class="update-pop-up-close-button" value="关闭" onclick="closeupdatecollege()" id="close_add_student">
                            <a href="${pageContext.request.contextPath}/action/student!stuShow.do">
                                <span>X</span>
                            </a>
                        </button>
                    </div>
                </div>
                <div class="stu-update-pop-up-body-box">
                    <div class="stu-pop-up-body-form-box">
                        <form method="post" action="${pageContext.request.contextPath}/action/student!stuAdd.do">
                            <label class="stu-account" for="L-stu_account_add">学号</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_account_add" value="" required="required" name="stuAccountAdd" autocomplete="off" placeholder="此项为必填项"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-name" for="L-stu_name_add">姓名</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_name_add" value="" required="required" name="stuNameAdd" autocomplete="off" placeholder="此项为必填项"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-sex" for="stu_sex_select_add">性别</label>
                            <div class="stu-pop-up-body-input-box">
                                <div class="stu-sex-input-block">
                                    <select name="stuSexAdd" lay-verify="required" id="stu_sex_select_add">
                                        <option></option>
                                        <optgroup label="性别">
                                            <option value="0">女</option>
                                            <option value="1">男</option>
                                        </optgroup>
                                    </select>
                                </div>
                            </div>
                            <span class="warning-span">**</span>
                            <br/>
                            <label class="stu-birth" for="L-stu_birth_add">出生年月</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_birth_add" value="" name="stuBirthAdd" autocomplete="off" placeholder="格式：yyyy-MM"/>
                            </div><br/>
                            <label class="stu-rigin" for="L-stu_origin_add">籍贯</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_origin_add" value="" required="required" name="stuOriginAdd" autocomplete="off" placeholder="此项为必填项"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-enthnic" for="stu_enthnic_select_add">民族</label>
                            <div class="stu-pop-up-body-input-box">
                                <div class="stu-enthnic-input-block">
                                    <select name="stuEnthnicAdd" lay-verify="required" id="stu_enthnic_select_add">
                                        <option></option>
                                        <optgroup label="民族">
                                            <option value="汉族">汉族</option>
                                            <option value="藏族">藏族</option>
                                            <option value="苗族">苗族</option>
                                            <option value="羌族">羌族</option>
                                            <option value="维吾尔族">维吾尔族</option>
                                        </optgroup>
                                    </select>
                                </div>
                            </div>
                            <span class="warning-span">**</span>
                            <br/>
                            <label class="stu-id_number" for="L-stu_id_number_add">身份证号</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_id_number_add" value="" required="required" name="stuIdNumAdd" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-university" for="L-stu_university_add">学校</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_university_add" value="" required="required" name="stuUniversityAdd" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-phone" for="L-stu_phone_add">手机号</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_phone_add" value="" name="stuPhoneAdd" autocomplete="off" placeholder="请输入正确的11位手机号码"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-family" for="L-stu_family_add">家庭人口</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_family_add" value="" name="stuFamilyAdd" autocomplete="off" placeholder="请输入阿拉伯数字"/>
                            </div><br/>
                            <label class="stu-father_name" for="L-stu_father_name_add">父亲</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_father_name_add" value="" name="stuFatherNameAdd" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-father_phone" for="L-stu_father_phone_add">父亲联系方式</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_father_phone_add" value="" name="stuFatherPhoneAdd" autocomplete="off" placeholder="请输入正确的11位手机号码"/>
                            </div><br/>
                            <label class="stu-father_address" for="L-stu_father_address_add">现居地</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_father_address_add" value="" name="stuFatherAddressAdd" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-mother_name" for="L-stu_mother_name_add">母亲</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_mother_name_add" value="" name="stuMotherNameAdd" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-mother_phone" for="L-stu_mother_phone_add">母亲联系方式</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_mother_phone_add" value="" name="stuMotherPhoneAdd" autocomplete="off" placeholder="请输入正确的11位手机号码"/>
                            </div><br/>
                            <label class="stu-mother_address" for="L-stu_mother_adress_add">现居地</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_mother_adress_add" value="" name="stuMotherAddressAdd" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-room" for="L-stu_room_id_add">宿舍信息</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_room_id_add" value="" name="stuRoomIdAdd" autocomplete="off" placeholder="格式：区域首字母大写-楼栋号-楼层号房间号 例：临江苑1号楼4层12（L-1-412）"/>
                            </div><br/>
                            <div class="stu-pop-up-body-button-box">
                                <button type="submit" class="add-button" id="student_add_button" value="添加">
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