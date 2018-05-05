<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>信息管理</title>
    <link href="../css/setting.css" rel="stylesheet">
    <!--<script type="text/javascript" src="../js/setting.js"></script>-->
    <script src="../js/jquery.js" charset="utf-8"></script>
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
                <span class="to-mainpage-button"><a href="personSetting.jsp" class="step-button">信息管理</a>
                    <<
                    <a href="mainPage.jsp" class="step-button">返回首页</a></span>
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
                            <a href="#" onclick="show(1)" name="by" id="b1">
                                <span class="column-name">个人信息</span>
                            </a>
                        </li>
                        <li class="column-list-item-2">
                            <a  href="##" title="密码修改" class="column-item-link" name="by" id="b2" onclick="show(2)">
                                <span class="column-name">密码修改</span>
                            </a>
                        </li>
                        <li class="column-list-item-3">
                            <a  href="###" title="班级信息" class="column-item-link" name="by" id="b3" onclick="show(3)">
                                <span class="column-name">班级信息</span>
                            </a>
                        </li>
                        <li class="column-list-item-4">
                            <a  href="####" title="学院信息" class="column-item-link" name="by" id="b4" onclick="show(4)">
                                <span class="column-name">学院信息</span>
                            </a>
                        </li>
                        <li class="column-list-item-5">
                            <a  href="#####" title="学生信息" class="column-item-link" name="by" id="b5" onclick="show(5)">
                                <span class="column-name">学生信息</span>
                            </a>
                        </li>
                        <li class="column-list-item-6">
                            <a href="######" title="宿舍信息" class="column-item-link" name="by" id="b6" onclick="show(6)">
                                <span class="column-name">宿舍信息</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 内容显示 -->
        <div class="content-box" id="content_box">
            <!-- 欢迎信息 -->
            <div class="content-wecome-box" id="d0" name="dv" style="display: none">
                <h2>欢迎<span> </span><span id="student-name">邓超</span><span> </span>童鞋来到西华大学！</h2>
            </div>
            <!-- 个人信息content -->
            <div class="content-person-box" id="d1" name="dv" style="display: none">
                <div class="per-form-box">
                    <label class="per-name" for="L-per_name">姓 名：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_name" value="张三" readonly="readonly" type="text"/>
                    </div>
                    <br/>
                    <label class="per-sex" for="L-per_sex">性 别：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_sex" value="男" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-enthnic" for="L-per_enthnic">民 族：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_enthnic" value="汉族" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-age" for="L-per_age">年 龄：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_age" value="22" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-origin" for="L-per_origin">生源地：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_origin" value="四川南充" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-phone" for="L-per_phone">手机号：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_phone" value="13568921658" readonly="readonly" type="text"/>
                    </div>
                    <br/>
                    <label class="per-id_number" for="L-per_id_number">身份证号：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_id_number" value="514648199505258672" readonly="readonly" type="text"/>
                    </div>
                    <br/>
                    <label class="per-grade" for="L-per_grade">高考成绩：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_grade" value="560" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-father" for="L-per_father">父亲姓名：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_father" value="张鼎" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-father_phone" for="L-per_father_phone">父亲联系方式：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_father_phone" value="13789652288" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-mother" for="L-per_mother">母亲姓名：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_mother" value="李秀颖" readonly="readonly" type="text"/>
                    </div><br/>
                    <label class="per-mother_phone" for="L-per_mother_phone">母亲联系方式：</label>
                    <div class="content-per-input-box">
                        <input id="L-per_mother_phone" value="15526855354" readonly="readonly" type="text"/>
                    </div><br/>
                    <div class="content-per-button-box">
                        <div class="content-per-box-update">
                            <button id="update_per" type="button" onclick="updatePer()" value="update-per">修 改</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 修改个人信息页面弹出层 -->
            <div id="per-update-pop-up-box" style="display: none">
                <div class="update-pop-up-head-box">
                    <div class="update-pop-up-head-word-box">
                        <span>编辑信息</span>
                    </div>
                    <div class="update-pop-up-head-close-box">
                        <button type="button" class="update-pop-up-close-button" value="关闭" onclick="closeupdatecollege()" id="close_update_per">
                            <span>X</span>
                        </button>
                    </div>
                </div>
                <div class="stu-update-pop-up-body-box">
                    <div class="stu-pop-up-body-form-box" id="per_pop_up_body_form_box">
                        <form>
                            <label class="stu-name" for="L-per_name_update">姓名：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_name_update" value="张三" readonly="readonly" name="title" autocomplete="off" placeholder="此项为必填项"/>
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
                            <label class="stu-birth" for="L-per_age_update">年 龄：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_age_update" value="22" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-rigin" for="L-per_origin_update">生源地：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_origin_update" value="四川南充" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-phone" for="L-per_phone_update">手机号：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_phone_update" value="13568921658" name="title" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-id_number" for="L-per_id_number_update">身份证号：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_id_number_update" value="514648199505258672" readonly="readonly" name="title" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-university" for="L-per_grade_update">高考成绩：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_grade_update" value="560" readonly="readonly" name="title" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-father_name" for="L-per_father_update">父亲姓名：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_father_update" value="张鼎" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-father_phone" for="L-per_father_phone_update">父亲联系方式：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_father_phone_update" value="13789652288" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-mother_name" for="L-per_mother_update">母亲姓名：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_mother_update" value="李秀颖" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-mother_phone" for="L-per_mother_phone_update">母亲联系方式：</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-per_mother_phone_update" value="15526855354" name="title" autocomplete="off"/>
                            </div><br/>
                            <div class="content-per-button-box">
                                <button type="submit" class="update-button" id="update_per_sure" value="确认修改">
                                    <span>确认修改</span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 密码修改content -->
            <div class="content-update-box" id="d2" name="dv" style="display: none">
                <div class="content-update-password-box">
                    <form method="post" class="content-update-password-form">
                        <div class="content-update-box-1">
                            <label>用户名：</label><input type="text" id="update-username" value="" placeholder="必填" required="required"/><span class="char">*</span><span>请输入正确的用户名(不超过18个字符)</span><br/>
                        </div>
                        <div class="content-update-box-1">
                            <label>原密码：</label><input type="text" id="update-oldpassword" value="" placeholder="******" required="required"/><span class="char">*</span><span>请输入原密码</span><br/>
                        </div>
                        <div class="content-update-box-1">
                            <label>新密码：</label><input type="text" id="update-newpassword" value="" placeholder="******" required="required"/><span class="char">*</span><span>请输入新密码(6~12位)</span><br/>
                        </div>
                        <div class="content-update-button-box">
                            <div class="content-update-submit-button-box">
                                <button type="submit" value="">确认</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- 班级信息content -->
            <div class="content-classinfo-box" id="d3" name="dv" style="display: none">
                <form class="content-classinfo-form" action="">
                    <div class="classinfo-search-box">
                        <div class="classinfo-name-box">
                            <input type="text" name="classname" placeholder="班级名字" autocomplete="off" class="classinfo-name" id="class_name">
                        </div>
                        <div class="classinfo-search-button-box">
                            <button class="classinfo-search-button" lay-submit="" lay-filter="sreach" type="submit"><span>查找</span></button>
                        </div>
                    </div>
                </form>
                <div class="classinfo-add-box">
                    <button class="classinfo-add-button" onclick="add()" id="add_class">
                        <span>添加</span>
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
                        <tbody>
                        <tr>
                            <td>
                                <u onclick="unique()">
                                    002
                                </u>
                            </td>
                            <td>
                                信息14-2
                            </td>
                            <td>
                                电气与电子信息学院
                            </td>
                            <td>
                                30
                            </td>
                            <td>
                                杨成柳
                            </td>
                            <td>
                                信息工程
                            </td>
                            <td>
                                2014
                            </td>
                            <td>

                            </td>
                            <td class="classinfo-option">
                                <a title="编辑" href="javascript:void(0);" onclick="update()" id="update_class">
                                    <img src="../image/look.png" class="option-img"/>
                                </a>
                                &emsp;|&emsp;
                                <a title="删除" href="javascript:void(0);" id="delete_classinfo">
                                    <img src="../image/delete.jpg" class="option-img"/>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- 修改班级信息页面弹出层 -->
            <div id="classinfo-update-pop-up-box" style="display: none">
                <div class="update-pop-up-head-box">
                    <div class="update-pop-up-head-word-box">
                        <span>编辑信息</span>
                    </div>
                    <div class="update-pop-up-head-close-box">
                        <button type="button" class="update-pop-up-close-button" value="关闭" onclick="closeupdate()" id="close_update_class">
                            <span>X</span>
                        </button>
                    </div>
                </div>
                <div class="update-pop-up-body-box">
                    <div class="pop-up-body-form-box">
                        <form>
                            <label class="class-number" for="L-title_number">班级编号</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_number" value="002" readonly="readonly" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-name" for="L-title_name">班级名称</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_name" value="信息14-2" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-college" for="L-title_college">所属学院</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_college" value="电气与电子信息学院" readonly="readonly" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-stunumber" for="L-title_stunumber">学生人数</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_stunumber" value="30" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="class-teacher" for="L-title_teacher">辅导员</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_teacher" value="杨成柳" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-major" for="L-title_major">年级专业</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_major" value="信息工程" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-year" for="L-title_year">年级</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_year" value="2014" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/><br/>
                            <div class="pop-up-body-button-box">
                                <button type="submit" class="add-button" value="确认修改" id="classinfo_update_sure_button">
                                    <span>确认修改</span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 用于页面弹出时阻挡原页面的空白div -->
            <div id="fade"></div>
            <!-- 添加班级信息页面弹出层 -->
            <div class="classinfo-add-pop-up-box" id="classinfo-add-pop-up-box" style="display: none">
                <div class="update-pop-up-head-box">
                    <div class="update-pop-up-head-word-box">
                        <span>添加信息</span>
                    </div>
                    <div class="update-pop-up-head-close-box">
                        <button type="button" class="update-pop-up-close-button" value="关闭" onclick="closeadd()" id="close_add_class">
                            <span>X</span>
                        </button>
                    </div>
                </div>
                <div class="update-pop-up-body-box">
                    <div class="pop-up-body-form-box">
                        <form>
                            <label class="class-number" for="L-title_number">班级编号</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_number_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-name" for="L-title_name">班级名称</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_name_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-college" for="L-title_college">所属学院</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_college_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-stunumber" for="L-title_stunumber">学生人数</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_stunumber_add" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="class-teacher" for="L-title_teacher">辅导员</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_teacher_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-major" for="L-title_major">年级专业</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_major_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-year" for="L-title_year">年级</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-title_year_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
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
            <!-- 学院信息content -->
            <div class="content-classinfo-box" id="d4" name="dv" style="display: none">
                <form class="content-classinfo-form" action="">
                    <div class="classinfo-search-box">
                        <div class="classinfo-name-box">
                            <input type="text" name="classname" placeholder="学院名称" autocomplete="off" class="classinfo-name" id="college_name">
                        </div>
                        <div class="classinfo-search-button-box">
                            <button class="classinfo-search-button" lay-submit="" lay-filter="sreach" type="submit"><span>查找</span></button>
                        </div>
                    </div>
                </form>
                <div class="classinfo-add-box">
                    <button class="classinfo-add-button" onclick="addcollege()" id="add_college">
                        <span>添加</span>
                    </button>
                </div>
                <div class="classinfo-table-box">
                    <table class="classinfo-table">
                        <thead>
                        <tr>
                            <th class="class-table-no">
                                学院编号
                            </th>
                            <th class="class-table-name">
                                学院名称
                            </th>
                            <th class="class-table-college">
                                班级信息
                            </th>
                            <th class="class-table-stu">
                                学生人数
                            </th>
                            <th class="class-table-teacher">
                                师资队伍
                            </th>
                            <th class="class-table-more">
                                备注
                            </th>
                            <th class="class-table-option">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <u onclick="unique()">
                                    080
                                </u>
                            </td>
                            <td>
                                电气与电子信息学院
                            </td>
                            <td>
                                <a href="##" title="班级信息" id="college_link_class">班级</a>
                            </td>
                            <td>
                                1200
                            </td>
                            <td>
                                500
                            </td>
                            <td>

                            </td>
                            <td class="classinfo-option">
                                <a title="编辑" href="javascript:void(0);" onclick="updatecollege()" id="update_college">
                                    <img src="../image/look.png" class="option-img"/>
                                </a>
                                &emsp;|&emsp;
                                <a title="删除" href="javascript:void(0);" id="delete_college">
                                    <img src="../image/delete.jpg" class="option-img"/>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- 修改学院信息页面弹出层 -->
            <div id="college-update-pop-up-box" style="display: none">
                <div class="update-pop-up-head-box">
                    <div class="update-pop-up-head-word-box">
                        <span>编辑信息</span>
                    </div>
                    <div class="update-pop-up-head-close-box">
                        <button type="button" class="update-pop-up-close-button" value="关闭" onclick="closeupdatecollege()" id="close_update_college">
                            <span>X</span>
                        </button>
                    </div>
                </div>
                <div class="update-pop-up-body-box">
                    <div class="pop-up-body-form-box">
                        <form>
                            <label class="class-number" for="L-college_number">学院编号</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-college_number" value="080" readonly="readonly" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-name" for="L-college_name">学院名称</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-college_name" value="电气与电子信息学院" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-college" for="L-college_class">班级信息</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-college_class" value="" name="title" autocomplete="off" placeholder="可不填写"/>
                            </div><br/>
                            <label class="class-stunumber" for="L-college_stunumber">学生人数</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-college_stunumber" value="1200" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="class-teacher" for="L-college_teacher">师资队伍</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-college_teacher" value="500" name="title" autocomplete="off"/>
                            </div><br/>
                            <div class="pop-up-body-button-box">
                                <button type="submit" class="add-button" id="college_update_sure_button" value="确认修改">
                                    <span>确认修改</span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 添加学院信息页面弹出层 -->
            <div class="college-add-pop-up-box" id="college-add-pop-up-box" style="display: none">
                <div class="update-pop-up-head-box">
                    <div class="update-pop-up-head-word-box">
                        <span>添加信息</span>
                    </div>
                    <div class="update-pop-up-head-close-box">
                        <button type="button" class="update-pop-up-close-button" value="关闭" onclick="closeaddcollege()" id="close_add_college">
                            <span>X</span>
                        </button>
                    </div>
                </div>
                <div class="update-pop-up-body-box">
                    <div class="pop-up-body-form-box">
                        <form>
                            <label class="class-number" for="L-college_number">学院编号</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-college_number_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-name" for="L-college_name">学院名称</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-college_name_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-college" for="L-college_class">班级信息</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-college_class_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="class-stunumber" for="L-college_stunumber">学生人数</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-college_stunumber_add" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="class-teacher" for="L-college_teacher">师资队伍</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-college_teacher_add" name="title" autocomplete="off"/>
                            </div><br/>
                            <div class="pop-up-body-button-box">
                                <button type="submit" class="add-button" id="college_add_button" value="添加">
                                    <span>添加</span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 学生信息content -->
            <div class="content-student-box" id="d5" name="dv" style="display: none">
                <form class="content-student-form" action="">
                    <div class="student-search-box">
                        <div class="student-account-box">
                            <input type="text" name="student_account" placeholder="学号" autocomplete="off" class="student-account" id="student_account">
                        </div>
                        <div class="student-search-button-box">
                            <button class="student-search-button" lay-submit="" lay-filter="sreach" type="submit"><span>查找</span></button>
                        </div>
                    </div>
                </form>
                <div class="student-add-box">
                    <button class="student-add-button" onclick="addcollege()" id="add_student">
                        <span>添加</span>
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
                        <tbody>
                        <tr>
                            <td>
                                31201804301
                            </td>
                            <td>
                                张三
                            </td>
                            <td>
                                男
                            </td>
                            <td>
                                1995-05
                            </td>
                            <td>
                                四川南充
                            </td>
                            <td>
                                汉
                            </td>
                            <td>
                                514648199505258672
                            </td>
                            <td>
                                西华大学
                            </td>
                            <td>
                                13568921658
                            </td>
                            <td>
                                <a id="stu_to_room" href="javascript:void (0);" title="点击查看宿舍信息">L-1601</a>
                            </td>
                            <td>
                                电气与电子信息学院
                            </td>
                            <td>
                                电气自动化
                            </td>
                            <td>
                                <a id="stu_to_class" href="javascript:void (0);" title="点击查看班级信息">电气18-3</a>
                            </td>
                            <td>
                                张鼎
                            </td>
                            <td>
                                13789652288
                            </td>
                            <td>
                                李秀颖
                            </td>
                            <td>
                                15526855354
                            </td>
                            <td class="student-option">
                                <a title="编辑" href="javascript:void(0);" onclick="update_student()" id="update_student">
                                    <img src="../image/look.png" class="option-img"/>
                                </a>
                                <!--&emsp;|&emsp;-->|
                                <a title="删除" href="javascript:void(0);" id="delete_student">
                                    <img src="../image/delete.jpg" class="option-img"/>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- 修改学生信息页面弹出层 -->
            <div id="student-update-pop-up-box" style="display: none">
                <div class="update-pop-up-head-box">
                    <div class="update-pop-up-head-word-box">
                        <span>编辑信息</span>
                    </div>
                    <div class="update-pop-up-head-close-box">
                        <button type="button" class="update-pop-up-close-button" value="关闭" onclick="closeupdatecollege()" id="close_update_student">
                            <span>X</span>
                        </button>
                    </div>
                </div>
                <div class="stu-update-pop-up-body-box">
                    <div class="stu-pop-up-body-form-box">
                        <form>
                            <label class="stu-account" for="L-stu_account">学号</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_account" readonly="readonly" value="31201804301" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-name" for="L-stu_name">姓名</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_name" value="张三" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-sex" for="stu_sex_select_update">性别</label>
                            <div class="stu-pop-up-body-input-box">
                                <div class="stu-sex-input-block">
                                    <select name="stu_sex" lay-verify="required" id="stu_sex_select_update">
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
                            <label class="stu-birth" for="L-stu_birth">出生年月</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_birth" value="1995-05" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-rigin" for="L-stu_origin">籍贯</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_origin" value="四川南充" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-enthnic" for="stu_enthnic_select_update">民族</label>
                            <div class="stu-pop-up-body-input-box">
                                <div class="stu-enthnic-input-block">
                                    <select name="stu_enthnic" lay-verify="required" id="stu_enthnic_select_update">
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
                            <label class="stu-id_number" for="L-stu_id_number">身份证号</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_id_number" value="514648199505258672" readonly="readonly" name="title" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-university" for="L-stu_university">学校</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_university" value="西华大学" readonly="readonly" name="title" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-phone" for="L-stu_phone">手机号</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_phone" value="13568921658" name="title" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-family" for="L-stu_family">家庭人口</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_family" value="3" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-father_name" for="L-stu_father_name">父亲</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_father_name" value="张鼎" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-father_phone" for="L-stu_father_phone">父亲联系方式</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_father_phone" value="13789652288" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-father_address" for="L-stu_father_address">现居地</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_father_address" value="四川南充" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-mother_name" for="L-stu_mother_name">母亲</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_mother_name" value="李秀颖" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-mother_phone" for="L-stu_mother_phone">母亲联系方式</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_mother_phone" value="15526855354" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-mother_address" for="L-stu_mother_adress">现居地</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_mother_adress" value="四川南充" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-room" for="L-stu_room">宿舍信息</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_room" value="L-1601" name="title" autocomplete="off" placeholder="格式：区域首字母大写-楼栋号-楼层号房间号 例：临江苑1号楼4层12（L-1-412）"/>
                            </div><br/>
                            <div class="stu-pop-up-body-button-box">
                                <button type="submit" class="update-button" id="student_update_sure_button" value="确认修改">
                                    <span>确认修改</span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 添加学生信息页面弹出层 -->
            <div id="student-add-pop-up-box" style="display: none">
                <div class="update-pop-up-head-box">
                    <div class="update-pop-up-head-word-box">
                        <span>添加信息</span>
                    </div>
                    <div class="update-pop-up-head-close-box">
                        <button type="button" class="update-pop-up-close-button" value="关闭" onclick="closeupdatecollege()" id="close_add_student">
                            <span>X</span>
                        </button>
                    </div>
                </div>
                <div class="stu-update-pop-up-body-box">
                    <div class="stu-pop-up-body-form-box">
                        <form>
                            <label class="stu-account" for="L-stu_account">学号</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_account_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-name" for="L-stu_name">姓名</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_name_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-sex" for="stu_sex_select_add">性别</label>
                            <div class="stu-pop-up-body-input-box">
                                <div class="stu-sex-input-block">
                                    <select name="stu_sex" lay-verify="required" id="stu_sex_select_add">
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
                            <label class="stu-birth" for="L-stu_birth">出生年月</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_birth_add" value="" name="title" autocomplete="off" placeholder="格式：yyyy-MM"/>
                            </div><br/>
                            <label class="stu-rigin" for="L-stu_origin">籍贯</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_origin_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-enthnic" for="stu_enthnic_select_add">民族</label>
                            <div class="stu-pop-up-body-input-box">
                                <div class="stu-enthnic-input-block">
                                    <select name="stu_enthnic" lay-verify="required" id="stu_enthnic_select_add">
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
                            <label class="stu-id_number" for="L-stu_id_number">身份证号</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_id_number_add" value="" required="required" name="title" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-university" for="L-stu_university">学校</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_university_add" value="" required="required" name="title" autocomplete="off" placeholder="必填"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-phone" for="L-stu_phone">手机号</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_phone_add" value="" name="title" autocomplete="off" placeholder="请输入正确的11位手机号码"/>
                            </div><span class="warning-span">**</span><br/>
                            <label class="stu-family" for="L-stu_family">家庭人口</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_family_add" value="" name="title" autocomplete="off" placeholder="请输入阿拉伯数字"/>
                            </div><br/>
                            <label class="stu-father_name" for="L-stu_father_name">父亲</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_father_name_add" value="" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-father_phone" for="L-stu_father_phone">父亲联系方式</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_father_phone_add" value="" name="title" autocomplete="off" placeholder="请输入正确的11位手机号码"/>
                            </div><br/>
                            <label class="stu-father_address" for="L-stu_father_address">现居地</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_father_address_add" value="" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-mother_name" for="L-stu_mother_name">母亲</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_mother_name_add" value="" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-mother_phone" for="L-stu_mother_phone">母亲联系方式</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_mother_phone_add" value="" name="title" autocomplete="off" placeholder="请输入正确的11位手机号码"/>
                            </div><br/>
                            <label class="stu-mother_address" for="L-stu_mother_adress">现居地</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_mother_adress_add" value="" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="stu-room" for="L-stu_room">宿舍信息</label>
                            <div class="stu-pop-up-body-input-box">
                                <input type="text" id="L-stu_room_add" value="" name="title" autocomplete="off" placeholder="格式：区域首字母大写-楼栋号-楼层号房间号 例：临江苑1号楼4层12（L-1-412）"/>
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
            <!-- 宿舍信息content -->
            <div class="content-room-box" id="d6" name="dv" style="display: none">
                <form class="content-room-form" action="">
                    <div class="room-search-box">
                        <div class="room-name-box">
                            <input type="text" name="roomarea" placeholder="宿舍区域" autocomplete="off" class="room-area" id="room_area">
                        </div>
                        <div class="room-search-button-box">
                            <button class="room-search-button" lay-submit="" lay-filter="sreach" type="submit"><span>查找</span></button>
                        </div>
                    </div>
                </form>
                <div class="room-add-box">
                    <button class="room-add-button" onclick="addroom()" id="add_room">
                        <span>添加</span>
                    </button>
                </div>
                <div class="room-table-box">
                    <table class="room-table">
                        <thead>
                        <tr>
                            <th class="room-table-area">
                                宿舍区域
                            </th>
                            <th class="room-table-loudong">
                                楼栋号
                            </th>
                            <th class="room-table-floor-number">
                                楼层号
                            </th>
                            <th class="room-table-room-number">
                                房间号
                            </th>
                            <th class="room-table-auntie-name">
                                宿管阿姨
                            </th>
                            <th class="room-table-students-number">
                                学生人数
                            </th>
                            <th class="room-table-empty-room">
                                空房间数
                            </th>
                            <th class="room-table-more">
                                备注
                            </th>
                            <th class="room-table-option">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <u onclick="unique()">
                                    临江苑
                                </u>
                            </td>
                            <td>
                                1
                            </td>
                            <td>
                                6
                            </td>
                            <td>
                                03
                            </td>
                            <td>
                                张阿姨
                            </td>
                            <td>
                                1000
                            </td>
                            <td>
                                0
                            </td>
                            <td>

                            </td>
                            <td class="room-option">
                                <a title="编辑" href="javascript:void(0);" onclick="updateroom()" id="update_room">
                                    <img src="../image/look.png" class="option-img"/>
                                </a>
                                &emsp;|&emsp;
                                <a title="删除" href="javascript:void(0);" id="delete_room">
                                    <img src="../image/delete.jpg" class="option-img"/>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- 添加宿舍信息页面弹出层 -->
            <div class="room-add-pop-up-box" id="room-add-pop-up-box" style="display: none">
                <div class="update-pop-up-head-box">
                    <div class="update-pop-up-head-word-box">
                        <span>添加信息</span>
                    </div>
                    <div class="update-pop-up-head-close-box">
                        <button type="button" class="update-pop-up-close-button" value="关闭" onclick="closeaddroom()" id="close_add_room">
                            <span>X</span>
                        </button>
                    </div>
                </div>
                <div class="update-pop-up-body-box">
                    <div class="pop-up-body-form-box">
                        <form>
                            <label class="room-area" for="L-room_area_add">宿舍区域</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_area_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="room-loudong" for="L-room_loudong_add">楼栋号</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_loudong_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="room-floor-number" for="L-room_floor_number_add">楼层号</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_floor_number_add" value="" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="room-room-number" for="L-room_room_number_add">房间号</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_room_number_add" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="room-auntie-name" for="L-room_auntie_name_add">宿管阿姨</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_auntie_name_add" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="room-students-number" for="L-room_students_number_add">学生人数</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_students_number_add" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="room-empty-number" for="L-room_empty_number_add">空房间数</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_empty_number_add" name="title" autocomplete="off"/>
                            </div><br/>
                            <div class="pop-up-body-button-box">
                                <button type="submit" class="add-button" id="room_add_button" value="添加">
                                    <span>添加</span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 修改宿舍信息页面弹出层 -->
            <div id="room-update-pop-up-box" style="display: none">
                <div class="update-pop-up-head-box">
                    <div class="update-pop-up-head-word-box">
                        <span>编辑信息</span>
                    </div>
                    <div class="update-pop-up-head-close-box">
                        <button type="button" class="update-pop-up-close-button" value="关闭" onclick="closeupdateroom()" id="close_update_room">
                            <span>X</span>
                        </button>
                    </div>
                </div>
                <div class="update-pop-up-body-box">
                    <div class="pop-up-body-form-box">
                        <form>
                            <label class="room-area" for="L-room_area_update">宿舍区域</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_area_update" value="临江苑" readonly="readonly" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="room-loudong" for="L-room_loudong_update">楼栋号</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_loudong_update" value="1" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="room-floor-number" for="L-room_floor_number_update">楼层号</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_floor_number_update" value="6" required="required" name="title" autocomplete="off" placeholder="此项为必填项"/>
                            </div><br/>
                            <label class="room-room-number" for="L-room_room_number_update">房间号</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_room_number_update" value="03" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="room-auntie-name" for="L-room_auntie_name_update">宿管阿姨</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_auntie_name_update" value="张阿姨" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="room-students-number" for="L-room_students_number_update">学生人数</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_students_number_update" value="1000" name="title" autocomplete="off"/>
                            </div><br/>
                            <label class="room-empty-number" for="L-room_empty_number_update">空房间数</label>
                            <div class="pop-up-body-input-box">
                                <input type="text" id="L-room_empty_number_update" value="0" name="title" autocomplete="off"/>
                            </div><br/>
                            <div class="pop-up-body-button-box">
                                <button type="submit" class="update-button" id="room_update_sure_button" value="确认修改">
                                    <span>确认修改</span>
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