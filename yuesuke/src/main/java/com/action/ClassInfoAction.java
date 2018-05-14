package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/12 16:07
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.ClassInfo;
import com.domain.ClassRelation;
import com.domain.College;
import com.domain.Teachers;
import com.service.ClassInfoService;
import com.service.ClassRelationService;
import com.service.CollegeService;
import com.service.TeachersService;
import com.util.FormatUtils;
import com.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName ClassInfoAction
 * @Description 信息管理-班级信息
 * @date 2018/5/12
 */
@Action(value = "classInfo")
@Results({
        @Result(name = "classInfoPage",location = "/jsp/classInfoPage.jsp"),
        @Result(name = "classInfoAddPage",location = "/jsp/classInfoAddPage.jsp"),
        @Result(name = "classInfoUpdatePage",location = "/jsp/classInfoUpdatePage.jsp"),
        @Result(name = "failed",location = "/jsp/404.jsp")
})
public class ClassInfoAction extends BaseAction {
    @Autowired
    private ClassRelationService classRelationService;
    @Autowired
    private TeachersService teachersService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private ClassInfoService classInfoService;

    private List<ClassRelation> relationList;

    private String className;
    private String toUpClassName;

    private String method;
    private String class_currnt;
    private String delClassId;
    /**
     * @Title: classInfoShow
     * @Description: 信息管理-班级信息
     * @author dengchao
     * @date 2018/5/12
     */
    public String classInfoShow() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Map<String,Object> mapClass=new HashMap<String, Object>();
        //判断搜索框是否输入
        if (this.className != null && !("".equals(this.className))){
            mapClass.put("CLASS_NAME",this.className);
        }
        if (toUpClassName != null){
            mapClass.put("CLASS_NAME",toUpClassName);
        }
        if (classRelationService != null){
            relationList=classRelationService.findByCondition(mapClass);
            if (relationList.size() > 0){
                req.setAttribute("relationList",relationList);
            }
        }
        return "classInfoPage";
    }

    /**
     * @Title: currentClass
     * @Description: 信息管理-班级信息
     * @author dengchao
     * @date 2018/5/13
     */
    public String currentClass() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Map<String,Object> mapClass=new HashMap<String, Object>();
        if ("current".equals(this.method) && class_currnt != null){
            mapClass.put("CLASS_NAME",this.class_currnt);
        }
        if (classRelationService != null){
            relationList=classRelationService.findByCondition(mapClass);
            if (relationList.size() > 0){
                req.setAttribute("relationList",relationList);
            }
        }
        return "classInfoPage";
    }
    /**
     * @Title: delClass
     * @Description: 删除操作
     * @author dengchao
     * @date 2018/5/13
     */
    public void delClass(){
        ClassInfo classInfoDel=null;
        List<ClassRelation> listRelation=null;
        Map<String,Object> mapDelRe=new HashMap<String, Object>();
        Integer rows1=0;
        if ("del".equals(this.method) && this.delClassId != null){
            if (classInfoService != null){
                classInfoDel=classInfoService.findById(Long.valueOf(this.delClassId));
                mapDelRe.put("CLASS_NAME",classInfoDel.getName());
                if (classRelationService != null){
                    listRelation=classRelationService.findByCondition(mapDelRe);
                    if (listRelation.size() > 0){
                        rows1=classRelationService.deleteById(listRelation.get(0).getId());
                    }
                }
                if (rows1 > 0){
                    classInfoService.deleteById(Long.valueOf(this.delClassId));
                }
            }
        }
    }
    /**
     * @Title: classAdd
     * @Description: 信息管理-班级信息-添加
     * @author dengchao
     * @date 2018/5/13
     */
    public String classAdd() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String result="classInfoAddPage";
        Integer rows=0;
        Integer rows2=0;

        List<Teachers> teachersList=null;
        List<College> collegeList=null;

        ClassInfo classInfo=null;
        College college=null;
        Teachers teachers=null;
        ClassRelation classRelation=null;
        String classNumAdd=req.getParameter("classNumAdd");
        String classNameAdd=req.getParameter("classNameAdd");
        String classCollegeAdd=req.getParameter("classCollegeAdd");
        String classStuNumAdd=req.getParameter("classStuNumAdd");
        String classTeacherAdd=req.getParameter("classTeacherAdd");
        String classMajorAdd=req.getParameter("classMajorAdd");
        String classYearAdd=req.getParameter("classYearAdd");

        //教师
        Map<String,Object> mapTeacher=new HashMap<String, Object>();
        mapTeacher.put("teacherIdNumber",classTeacherAdd);
        if (teachersService != null){
            teachersList=teachersService.findByCondition(mapTeacher);
            if (teachersList.size() > 0){
                teachers=teachersList.get(0);
            }
        }
        //学院
        Map<String,Object> mapCollege=new HashMap<String, Object>();
        mapCollege.put("NAME",classCollegeAdd);
        if (collegeService != null){
            collegeList=collegeService.findByCondition(mapCollege);
            if (collegeList.size() > 0){
                college=collegeList.get(0);
            }
        }
        //添加班级
        if (teachers != null){
            try {
                classInfo.setNumber(classNumAdd);
                classInfo.setName(classNameAdd);
                classInfo.setStudentsNumber(Integer.valueOf(classStuNumAdd));
                classInfo.setMajor(classMajorAdd);
                classInfo.setTeachersId(teachers);
                classInfo.setSaveTime(FormatUtils.now());
                classInfo.setUpdateTime(FormatUtils.now());
                if (classInfoService != null){
                    rows=classInfoService.save(classInfo);
                }
                if (rows > 0 && college != null){
                    classRelation.setGrade(classYearAdd);
                    classRelation.setCollegeId(college);
                    classRelation.setClassInfoId(classInfo);
                    rows2=classRelationService.save(classRelation);
                    if (rows2 > 0){
                        result="classInfoPage";
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public String toClassUpdate() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Map<String,Object> mapClassUp=new HashMap<String, Object>();
        mapClassUp.put("ID_NUMBER",toUpClassName);
        if (classRelationService != null){
            relationList=classRelationService.findByCondition(mapClassUp);
            if (relationList.size() > 0){
                req.setAttribute("relationListUp",relationList.get(0));
            }
        }
        return "classInfoUpdatePage";
    }
    /**
     * @Title: classUpdate
     * @Description: 信息管理-班级信息-修改
     * @author dengchao
     * @date 2018/5/13
     */
    public String classUpdate() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String result="classInfoUpdatePage";

        Integer rows=0;
        Integer rows2=0;

        ClassInfo classInfoUp=null;
        College collegeUp=null;
        Teachers teachersUp=null;
        ClassRelation classRelationUp=null;
        List<Teachers> teachersListUp=null;
        List<College> collegeListUp=null;
        String classNumUp=req.getParameter("classNumUp");
        String classNameUp=req.getParameter("classNameUp");
        String classCollegeUp=req.getParameter("classCollegeUp");
        String classStuNameUp=req.getParameter("classStuNameUp");
        String classTeacherUp=req.getParameter("classTeacherUp");
        String classMajorUp=req.getParameter("classMajorUp");
        String classYearUp=req.getParameter("classYearUp");
        //教师
        Map<String,Object> mapTeacherUp=new HashMap<String, Object>();
        mapTeacherUp.put("teacherIdNumber",classTeacherUp);
        if (teachersService != null){
            teachersListUp=teachersService.findByCondition(mapTeacherUp);
            if (teachersListUp.size() > 0){
                teachersUp=teachersListUp.get(0);
            }
        }
        //学院
        Map<String,Object> mapCollegeUp=new HashMap<String, Object>();
        mapCollegeUp.put("NAME",classCollegeUp);
        if (collegeService != null){
            collegeListUp=collegeService.findByCondition(mapCollegeUp);
            if (collegeListUp.size() > 0){
                collegeUp=collegeListUp.get(0);
            }
        }
        //修改班级
        if (teachersUp != null){
            try {
                classInfoUp.setNumber(classNumUp);
                classInfoUp.setName(classNameUp);
                classInfoUp.setStudentsNumber(Integer.valueOf(classStuNameUp));
                classInfoUp.setMajor(classMajorUp);
                classInfoUp.setTeachersId(teachersUp);
                classInfoUp.setSaveTime(FormatUtils.now());
                classInfoUp.setUpdateTime(FormatUtils.now());
                if (classInfoService != null){
                    rows=classInfoService.update(classInfoUp);
                }
                if (rows > 0 && collegeUp != null){
                    classRelationUp.setGrade(classYearUp);
                    classRelationUp.setCollegeId(collegeUp);
                    classRelationUp.setClassInfoId(classInfoUp);
                    rows2=classRelationService.update(classRelationUp);
                    if (rows2 > 0){
                        result="classInfoPage";
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getToUpClassName() {
        return toUpClassName;
    }

    public void setToUpClassName(String toUpClassName) {
        this.toUpClassName = toUpClassName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getClass_currnt() {
        return class_currnt;
    }

    public void setClass_currnt(String class_currnt) {
        this.class_currnt = class_currnt;
    }

    public String getDelClassId() {
        return delClassId;
    }

    public void setDelClassId(String delClassId) {
        this.delClassId = delClassId;
    }
}