package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/12 13:06
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Students;
import com.opensymphony.xwork2.ActionContext;
import com.service.StudentsService;
import com.tools.SexEnum;
import com.util.FormatUtils;
import com.util.base.BaseAction;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.*;

/**
 * @author dengchao
 * @ClassName personSettingAction
 * @Description 信息管理Action
 * @date 2018/5/12
 */
@Action(value = "personSetting")
@Results({
        @Result(name = "failed",location = "/jsp/404.jsp"),
        @Result(name = "personPage",location = "/jsp/personPage.jsp"),
        @Result(name = "personUpdate",location = "/jsp/personUpdatePage.jsp")
})
public class PersonSettingAction extends BaseAction{
    @Autowired
    private StudentsService studentsService;

    private List<Students> studentsList=new ArrayList<Students>();

    private String stuIdNumber;

    private String stuIdNum;

    private String toUpStuIdNumber;

    private String newStuIdNumber;
    /**
     * @Title: person
     * @Description: 信息管理-个人信息显示
     * @author dengchao
     * @date 2018/5/12
     */
    public String person() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String result="";
        //接收用户登录成功的身份证号idNumber
        stuIdNum= String.valueOf(request.getSession().getAttribute("stuIdNum"));
        Map<String,Object> mapStu=new HashMap<String, Object>();
        if (newStuIdNumber != null){
            mapStu.put("ID_NUMBER",newStuIdNumber);
        }else if (stuIdNum != null){
            mapStu.put("ID_NUMBER",stuIdNum);
        }

        //根据登录学生 身份证号（ID_NUMBER） 查询学生个人信息
        if (studentsService != null && mapStu != null){
            studentsList=studentsService.findByCondition(mapStu);
            //判断查询学生信息有效
            if (studentsList.size() == 1 ){
                req.setAttribute("personStudent",studentsList.get(0));
                req.setAttribute("birthDay",FormatUtils.dateFormat(studentsList.get(0).getBirthday()));
                req.setAttribute("sex", SexEnum.findSexByIndex(studentsList.get(0).getGender()));
//                ActionContext.getContext().put("personStudent",studentsList.get(0));
//                ServletActionContext.getRequest().setAttribute("personStudent", studentsList.get(0));
//                result="personPage";
            }
        }
        return "personPage";
    }

    /**
     * @Title: toPersonUpdate
     * @Description: 信息管理-个人信息->修改
     * @author dengchao
     * @date 2018/5/13
     */
    public String toPersonUpdate() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Map<String,Object> mapStuUp=new HashMap<String, Object>();
        mapStuUp.put("ID_NUMBER",toUpStuIdNumber);
        if (studentsService != null){
            studentsList=studentsService.findByCondition(mapStuUp);
            if (studentsList.size() > 0){
                req.setAttribute("studentUpdate", studentsList.get(0));
                req.setAttribute("birthDay",FormatUtils.dateFormat(studentsList.get(0).getBirthday()));
                req.setAttribute("sex", SexEnum.findSexByIndex(studentsList.get(0).getGender()));
            }
        }
        return "personUpdate";
    }
    /**
     * @Title: personUpdate
     * @Description: 信息管理-个人信息-修改
     * @author dengchao
     * @date 2018/5/12
     */
    public String personUpdate() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String result="";
        try {
            Date birthDay= FormatUtils.dateFormStrYmd(req.getParameter("L-per_age_update"));
            Byte Sex=Byte.valueOf(req.getParameter("L-per_sex_update"));
            String enthnic=req.getParameter("L-per_enthnic_update");
            String L_per_origin_update=req.getParameter("L-per_origin_update");
            String L_per_phone_update=req.getParameter("L-per_phone_update");
            String L_per_father_update=req.getParameter("L-per_father_update");
            String L_per_father_phone_update=req.getParameter("L-per_father_phone_update");
            String L_per_mother_update=req.getParameter("L-per_mother_update");
            String L_per_mother_phone_update=req.getParameter("L-per_mother_phone_update");
            //判断是否执行
            if (studentsService != null){
                //判断是否有数据
                if (studentsList.size() >0 ){
                    studentsList.get(0).setBirthday(birthDay);
                    studentsList.get(0).setGender(Sex);
                    studentsList.get(0).setEnthnic(enthnic);
                    studentsList.get(0).setOrigin(L_per_origin_update);
                    studentsList.get(0).setPhone(L_per_phone_update);
                    studentsList.get(0).setFatherName(L_per_father_update);
                    studentsList.get(0).setFatherPhone(L_per_father_phone_update);
                    studentsList.get(0).setMotherName(L_per_mother_update);
                    studentsList.get(0).setMotherPhone(L_per_mother_phone_update);
                    studentsService.update(studentsList.get(0));
                    req.setAttribute("studentUpdate", studentsList.get(0));
                    req.setAttribute("birthDay",FormatUtils.dateFormat(studentsList.get(0).getBirthday()));
                    req.setAttribute("sex", SexEnum.findSexByIndex(studentsList.get(0).getGender()));
                    stuIdNumber=studentsList.get(0).getIdNumber();
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return "failed";
        }
        return "personPage";
    }

    public List<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

    public String getStuIdNumber() {
        return stuIdNumber;
    }

    public void setStuIdNumber(String stuIdNumber) {
        this.stuIdNumber = stuIdNumber;
    }

    public String getToUpStuIdNumber() {
        return toUpStuIdNumber;
    }

    public void setToUpStuIdNumber(String toUpStuIdNumber) {
        this.toUpStuIdNumber = toUpStuIdNumber;
    }

    public String getNewStuIdNumber() {
        return newStuIdNumber;
    }

    public void setNewStuIdNumber(String newStuIdNumber) {
        this.newStuIdNumber = newStuIdNumber;
    }

    public String getStuIdNum() {
        return stuIdNum;
    }

    public void setStuIdNum(String stuIdNum) {
        this.stuIdNum = stuIdNum;
    }
}