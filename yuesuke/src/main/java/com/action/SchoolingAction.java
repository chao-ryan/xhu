package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/28 9:53
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Schooling;
import com.domain.Students;
import com.opensymphony.xwork2.ActionContext;
import com.service.StudentsService;
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
 * @ClassName SchoolingAction
 * @Description 学费Action
 * @date 2018/5/28
 */
@Action(value = "schooling")
@Results({
        @Result(name = "schooling",location = "/jsp/schoolingPage.jsp"),
        @Result(name = "404",location = "/jsp/404.jsp")
})
public class SchoolingAction extends BaseAction {
    @Autowired
    private StudentsService studentsService;

    private String stuIdNum;

    private List<Students> studentsList;

    /**
     * @Title: show
     * @Description: 学费信息显示
     * @author dengchao
     * @date 2018/5/28
     */
    public String show() throws UnsupportedEncodingException {
        //设置编码字符集
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String result="";
        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        //接收用户登录成功的身份证号idNumber
        stuIdNum= String.valueOf(request.getSession().getAttribute("stuIdNum"));
        Map<String,Object> mapStu=new HashMap<String, Object>();
        if (stuIdNum != null){
            mapStu.put("ID_NUMBER",stuIdNum);
        }
        //根据登录学生 身份证号（ID_NUMBER） 查询学生个人信息
        if (studentsService != null && mapStu != null){
            studentsList=studentsService.findByCondition(mapStu);
            //判断查询学生信息有效
            if (studentsList.size() == 1 ){
                //保存需要的学费信息对象
                Schooling schooling=studentsList.get(0).getSchoolingId();
                req.setAttribute("schooling",schooling);
                //判断学费是否已缴纳完
                if (studentsList.get(0).getIsPay() == 1){
                    req.setAttribute("pay","已结清");
                }else {
                    req.setAttribute("pay","未结清");
                }
                result="schooling";
            }else {
                result="404";
            }
        }else {
            result="404";
        }
        return result;
    }

    public String getStuIdNum() {
        return stuIdNum;
    }

    public void setStuIdNum(String stuIdNum) {
        this.stuIdNum = stuIdNum;
    }
}