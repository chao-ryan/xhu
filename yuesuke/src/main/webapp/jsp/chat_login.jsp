<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>
        聊天室
    </title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <script language="javascript">
        function check(){
            if(form1.username.value==""){
                alert("请输入用户名！");form1.username.focus();return false;
            }else if(form1.username.value=="\'"){
                alert("请不要输入非法字符！");form1.username.focus();return false;
            }
        }
    </script>
</head>

<body id="index_body" background="${pageContext.request.contextPath}/img/background1.jpg">
<br>
<div id="index_form_box">
    <form name="form1" method="post" action="${pageContext.request.contextPath}/servlet/Messages.servlet?action=loginRoom" onSubmit="return check()">
        <table width="371" height="230"  border="0" align="center" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/img/login.jpg">
            <tr>
                <td height="158" colspan="3" class="word_dark" id="index_welcome_td">&nbsp;欢迎来到YS聊天室</td>

            </tr>
            <tr>
                <td width="53" align="center" valign="top" class="word_dark">&nbsp;</td>

                <td width="216" align="center" valign="top" class="word_dark">
                    <!--<label id="index_username_lable">用户名：</label>-->
                    <input type="text" name="username" class="login" id="index_username_input" required="required" placeholder="请输入您的用户名"/>
                </td>
                <td width="94" valign="top" class="word_dark">
                    <div id="index_login_button_box">
                        <button name="Submit" type="submit" class="btn_bg" value="登录" id="index_login_button">
                            <span>登 录</span>
                        </button>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
