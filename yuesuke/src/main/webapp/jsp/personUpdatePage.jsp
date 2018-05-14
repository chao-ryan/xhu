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
            <!-- 修改个人信息页面弹出层 -->
            <div id="per-update-pop-up-box" style="display: block">
                <div class="update-pop-up-head-box">
                    <div class="update-pop-up-head-word-box">
                        <span>编辑信息</span>
                    </div>
                    <div class="update-pop-up-head-close-box">
                        <button type="button" class="update-pop-up-close-button" value="关闭" onclick="closeupdatecollege()" id="close_update_per">
                            <a href="${pageContext.request.contextPath}/action/personSetting!person.do?newStuIdNumber=${studentUpdate.getIdNumber()}">
                                <span>X</span>
                            </a>
                        </button>
                    </div>
                </div>
                <div class="stu-update-pop-up-body-box">
                    <div class="stu-pop-up-body-form-box" id="per_pop_up_body_form_box">
                        <form>
                            <label class="stu-name" for="L-per_name_update">姓名：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_name_update" value="${studentUpdate.getName()}" readonly="readonly" name="L-per_name_update" autocomplete="off" placeholder="此项为必填项"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-sex" for="L-per_sex_update">性 别：</label>
                            <div class="stu-pop-up-body-input-box">
                                <div class="stu-sex-input-block">
                                    <select name="stu_sex" lay-verify="required" id="L-per_sex_update">
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
                            <label class="stu-enthnic" for="L-per_enthnic_update">民 族：</label>
                            <div class="stu-pop-up-body-input-box">
                                <div class="stu-enthnic-input-block">
                                    <select name="stu_enthnic" lay-verify="required" id="L-per_enthnic_update">
                                        <option></option>
                                        <optgroup label="民族">
                                            <option value="0">汉族</option>
                                            <option value="1">藏族</option>
                                            <option value="2">苗族</option>
                                            <option value="3">羌族</option>
                                            <option value="4">维吾尔族</option>
                                        </optgroup>
                                    </select>
                                </div>
                            </div>
                            <span class="warning-span">**</span>
                            <br/>
                            <label class="stu-birth" for="L-per_age_update">出生年月：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_age_update" value="${birthDay}" name="L-per_age_update" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-rigin" for="L-per_origin_update">生源地：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_origin_update" value="${studentUpdate.getOrigin()}" name="L-per_origin_update" autocomplete="off" placeholder="此项为必填项"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-phone" for="L-per_phone_update">手机号：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_phone_update" value="${studentUpdate.getPhone()}" name="L-per_phone_update" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-id_number" for="L-per_id_number_update">身份证号：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_id_number_update" value="${studentUpdate.getIdNumber()}" readonly="readonly" name="L-per_id_number_update" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-university" for="L-per_grade_update">高考成绩：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_grade_update" value="${studentUpdate.getAchievement()}" readonly="readonly" name="L-per_grade_update" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-father_name" for="L-per_father_update">父亲姓名：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_father_update" value="${studentUpdate.getFatherName()}" name="L-per_father_update" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-father_phone" for="L-per_father_phone_update">父亲联系方式：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_father_phone_update" value="${studentUpdate.getFatherPhone()}" name="L-per_father_phone_update" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-mother_name" for="L-per_mother_update">母亲姓名：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_mother_update" value="${studentUpdate.getMotherName()}" name="L-per_mother_update" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-mother_phone" for="L-per_mother_phone_update">母亲联系方式：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_mother_phone_update" value="${studentUpdate.getMotherPhone()}" name="L-per_mother_phone_update" autocomplete="off"/>
                            </div><br/>
                            <div class="content-per-button-box">
                                <button type="submit" class="update-button" id="update_per_sure" onclick="updatePer()" value="确认修改">
                                    <a href="${pageContext.request.contextPath}/action/personSetting!personUpdate.do">
                                        <span>确认修改</span>
                                    </a>
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
    //    AJAX
    <%--//个人信息-修改--%>
    <%--function updatePer(){--%>
        <%--alert("确认进行此操作吗？");--%>
        <%--$.ajax({--%>
            <%--type:"POST",//发送请求的方式为GET/POST--%>
            <%--//请求的后台servlet地址,（注：pageContext.request.contextPath为当前页面请求路径，后面直接跟servlet地址，不要再加工程名）--%>
            <%--url:"${pageContext.request.contextPath}/action/personSetting!personUpdate.do",--%>
            //当前请求页面要传递的数据，如果要获取页面输入的值则使用$("#name".val())。username(password)为向后台传递的参数名
            <%--data:{birthday:$("#L-per_age_update").val(),sex:${"#L-per_sex_update"}.val(),enthnic:${"#L-per_enthnic_update"}.val(),L_per_originUpdate:${"#L-per_origin_update"},L_per_phone_update:${"#L-per_phone_update"}},--%>

                <%--L_per_father_update:${"#L-per_father_update"},L_per_father_phone_update:${"#L-per_father_phone_update"},--%>
                <%--L_per_mother_update:${"#L-per_mother_update"},L_per_mother_phone_update:${"#L-per_mother_phone_update"}},--%>
            <%--dataType:'json'//数据传输格式为json--%>
        <%--});--%>
    <%--};--%>
</script>
</body>
</html>