package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/28 10:16
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Teachers;
import com.opensymphony.xwork2.ActionContext;
import com.service.TeachersService;
import com.util.base.BaseAction;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName AdminLoginAction
 * @Description 管理员登录Action
 * @date 2018/5/28
 */
@Action(value = "adminLogin")
@Results({
        @Result(name = "adminOpreationPage",location = "/jsp/adminOpreationPage.jsp"),
        @Result(name = "failed",location = "/jsp/failed.jsp"),
        @Result(name = "404",location = "/jsp/404.jsp")
})
public class AdminLoginAction extends BaseAction {
    @Autowired
    private TeachersService teachersService;

    private String teacherName;
    private String teacherIdNum;

    private List<Teachers> teachersList;

    /**
     * @Title: login
     * @Description: 管理员登录验证
     * @author dengchao
     * @date 2018/5/28
     */
    public String login() throws UnsupportedEncodingException {
        //设置编码字符集
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String result="";

        Map<String,Object> mapTeacherIdNum=new HashMap<String, Object>();
        mapTeacherIdNum.put("teacherIdNumber",teacherIdNum);
        //根据老师身份证号查询
        if (mapTeacherIdNum != null && teachersService != null){
            teachersList=teachersService.findByCondition(mapTeacherIdNum);
            if (teachersList.size() == 1){
                //老师名字也正确了
                if (teacherName.equals(teachersList.get(0).getName())){
                    //保存老师身份证号到session中，为了方便管理员操作时验证身份用
                    request.getSession().setAttribute("teacherIdNum",teacherIdNum);
                    //跳转到管理员操作页面
                    result="adminOpreationPage";
                }else {//名字验证失败
                    result="failed";
                }
            }else {//身份证号验证失败
                result="failed";
            }
        }else {//请求失败
            result="404";
        }
        return result;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherIdNum() {
        return teacherIdNum;
    }

    public void setTeacherIdNum(String teacherIdNum) {
        this.teacherIdNum = teacherIdNum;
    }
}