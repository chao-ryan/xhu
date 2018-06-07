package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/28 11:04
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.ClassRelation;
import com.domain.Students;
import com.opensymphony.xwork2.ActionContext;
import com.service.ClassRelationService;
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
 * @ClassName AdminOpreationAction
 * @Description 管理员操作Action
 * @date 2018/5/28
 */
@Action(value = "adminOpreation")
@Results({
        @Result(name = "adminOpreationPage",location = "/jsp/adminOpreationPage.jsp"),
        @Result(name = "failed",location = "/jsp/failed.jsp"),
        @Result(name = "404",location = "/jsp/404.jsp")
})
public class AdminOpreationAction extends BaseAction {
    @Autowired
    private ClassRelationService classRelationService;
    @Autowired
    private StudentsService studentsService;

    private String stuAccount;
    private String authority;
    private String studentAccount;
    private Students students=null;
    private List<ClassRelation> relationList;

    /**
     * @Title: stuSearch
     * @Description: 管理员操作-学生信息查询
     * @author dengchao
     * @date 2018/5/28
     */
    public String stuSearch() throws UnsupportedEncodingException {
        //设置编码字符集
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String result="";
        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);

        Map<String,Object> mapStu=new HashMap<String, Object>();
        //判断搜索框是否输入
        if (this.stuAccount != null && !("".equals(this.stuAccount))){
            mapStu.put("STU_ACCOUNT",this.stuAccount);
        }
        //根据学生账号查询
        if (classRelationService != null){
            relationList=classRelationService.findByCondition(mapStu);
            //结果正确
            if (relationList.size() == 1){
                students=relationList.get(0).getStudentsId();
                //保存学生对象
                req.setAttribute("students",students);
                //保存对象到session
                request.getSession().setAttribute("studentAccount", stuAccount);
                //跳转到管理员操作页面
                result="adminOpreationPage";
            }
        }
        return result;
    }

    /**
     * @Title: update
     * @Description: 管理员操作页面--权限修改
     * @author dengchao
     * @date 2018/5/28
     */
    public String update() throws UnsupportedEncodingException {
        //设置编码字符集
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String result="";

        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        studentAccount= String.valueOf(request.getSession().getAttribute("studentAccount"));
        Map<String,Object> mapStu=new HashMap<String, Object>();
        //传递页面学生账号值
        if (this.stuAccount != null && !("".equals(this.stuAccount))){
            mapStu.put("STU_ACCOUNT",this.stuAccount);
        }
        //根据学生账号查询
        if (classRelationService != null) {
            relationList = classRelationService.findByCondition(mapStu);
            //查找结果有效
            if (relationList.size() == 1) {
                students = relationList.get(0).getStudentsId();
            }
        }
        //判断该学生已经查询到正确结果了
        if (students != null && studentsService != null){
            //修改学生权限为页面选择的单选按钮的值----权限等级
            students.setAuthority(Byte.valueOf(authority));
            //执行修改操作
            Integer rows=studentsService.update(students);
            //判断修改操作是否成功
            if (rows > 0){
                //跳转到管理员操作页面
                result="adminOpreationPage";
            }else {
                //操作失败
                result="failed";
            }
        }else {
            //请求失败
            result="404";
        }
        return result;
    }

    public String getStuAccount() {
        return stuAccount;
    }

    public void setStuAccount(String stuAccount) {
        this.stuAccount = stuAccount;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public String getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(String studentAccount) {
        this.studentAccount = studentAccount;
    }
}