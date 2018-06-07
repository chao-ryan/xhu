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
            <!-- 个人信息content -->
            <div class="content-person-box" id="d1" name="dv" style="display: block">
                <div class="per-form-box">
                    <label class="per-name" for="L-per_name">姓 名：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_name" name="L-per_name" value="${personStudent.getName()}" readonly="readonly" type="text"/>
                    </div>
                    <br/>
                    <label class="per-sex" for="L-per_sex">性 别：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_sex" name="L-per_sex" value="${sex}" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-enthnic" for="L-per_enthnic">民 族：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_enthnic" name="L-per_enthnic" value="${personStudent.getEnthnic()}" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-age" for="L-per_age">出生年月：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_age" name="L-per_age" value="${birthDay}" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-origin" for="L-per_origin">生源地：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_origin" name="L-per_origin" value="${personStudent.getOrigin()}" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-phone" for="L-per_phone">手机号：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_phone" name="L-per_phone" value="${personStudent.getPhone()}" readonly="readonly" type="text"/>
                    </div>
                    <br/>
                    <label class="per-id_number" for="L-per_id_number">身份证号：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_id_number" name="L-per_id_number" value="${personStudent.getIdNumber()}" readonly="readonly" type="text"/>
                    </div>
                    <br/>
                    <label class="per-grade" for="L-per_grade">高考成绩：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_grade" name="L-per_grade" value="${personStudent.getAchievement()}" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-father" for="L-per_father">父亲姓名：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_father" name="L-per_father" value="${personStudent.getFatherName()}" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-father_phone" for="L-per_father_phone">父亲联系方式：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_father_phone" name="L-per_father_phone" value="${personStudent.getFatherPhone()}" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-mother" for="L-per_mother">母亲姓名：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_mother" name="L-per_mother" value="${personStudent.getMotherName()}" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-mother_phone" for="L-per_mother_phone">母亲联系方式：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_mother_phone" name="L-per_mother_phone" value="${personStudent.getMotherPhone()}" readonly="readonly" type="text"/>
                    </div><br/>
                    <div class="content-per-button-box">
                        <div class="content-per-box-update">
                            <button id="update_per" type="button" onclick="updatePer()" value="update-per">
                            <a href="${pageContext.request.contextPath}/action/personSetting!toPersonUpdate.do?toUpStuIdNumber=${personStudent.getIdNumber()}">
                                <span>修 改</span>
                            </a>
                            </button>
                        </div>
                    </div>
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
    //个人信息-修改
    <%--function updatePer(){--%>
        <%--alert("确认进行此操作吗？");--%>
        <%--$.ajax({--%>
            <%--type:"POST",//发送请求的方式为GET/POST--%>
            <%--//请求的后台servlet地址,（注：pageContext.request.contextPath为当前页面请求路径，后面直接跟servlet地址，不要再加工程名）--%>
            <%--url:"${pageContext.request.contextPath}/action/personSetting!toPersonUpdate.do",--%>
            <%--//当前请求页面要传递的数据，如果要获取页面输入的值则使用$("#name".val())。username(password)为向后台传递的参数名--%>
            <%--data:{toUpStuIdNumber:${personStudent.getIdNumber()}},--%>
            <%--dataType:'json'//数据传输格式为json--%>
        <%--});--%>
    <%--}--%>
</script>
</body>
</html>