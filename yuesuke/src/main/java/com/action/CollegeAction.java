package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/12 16:07
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.College;
import com.service.CollegeService;
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
@Action(value = "college")
@Results({
        @Result(name = "collegePage",location = "/jsp/collegePage.jsp"),
        @Result(name = "collegeAddPage",location = "/jsp/collegeAddPage.jsp"),
        @Result(name = "collegeUpdatePage",location = "/jsp/collegeUpdatePage.jsp"),
        @Result(name = "failed",location = "/jsp/404.jsp")
})
public class CollegeAction extends BaseAction {
    @Autowired
    private CollegeService collegeService;

    private List<College> collegeList;

    private String collegeName;
    private String toUpCollegeName;
    private String newAddCollegeName;

    private String method;
    private String college_currnt;
    private String delcollegeId;
    /**
     * @Title: classInfoShow
     * @Description: 信息管理-班级信息
     * @author dengchao
     * @date 2018/5/12
     */
    public String collegeShow() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Map<String,Object> mapCollege=new HashMap<String, Object>();
        if (this.collegeName != null && !("".equals(this.collegeName))) {
            mapCollege.put("NAME", this.collegeName);
        }else if (newAddCollegeName != null){
            mapCollege.put("NAME",newAddCollegeName);
        }else if (toUpCollegeName != null){
            mapCollege.put("NAME",toUpCollegeName);
        }

            collegeList=collegeService.findByCondition(mapCollege);
            req.setAttribute("collegeList",collegeList);

        return "collegePage";
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
        Map<String,Object> mapCollege=new HashMap<String, Object>();
        if ("current".equals(this.method) && college_currnt != null){
            mapCollege.put("NAME",this.college_currnt);
        }
        if (collegeService != null){
            collegeList=collegeService.findByCondition(mapCollege);
            if (collegeList.size() > 0){
                req.setAttribute("collegeList",collegeList);
            }
        }
        return "collegePage";
    }
    /**
     * @Title: delClass
     * @Description: 删除操作
     * @author dengchao
     * @date 2018/5/13
     */
    public void delCollege(){
        Integer rows1=0;
        if ("del".equals(this.method) && this.delcollegeId != null) {
            if (collegeService != null) {
                rows1 = collegeService.deleteById(Long.valueOf(this.delcollegeId));
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

        String result="collegeAddPage";
        Integer rows=0;
        College college=null;

        String collegeNameAdd=req.getParameter("collegeNameAdd");
        String collegeStuNumAdd=req.getParameter("collegeStuNumAdd");
        String collegeTeaAdd=req.getParameter("collegeTeaAdd");

        //添加学院
            try {
                college.setName(collegeNameAdd);
                college.setStudentsNumber(Integer.valueOf(collegeStuNumAdd));
                college.setTeachersNumber(Integer.valueOf(collegeTeaAdd));
                college.setSaveTime(FormatUtils.now());
                college.setUpdateTime(FormatUtils.now());
                if (collegeService != null){
                    rows=collegeService.save(college);
                }
                if (rows > 0 && college != null){
                    result="collegePage";
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        return result;
    }

    /**
     * @Title: toCollegeUpdate
     * @Description: 信息管理-学院信息->修改
     * @author dengchao
     * @date 2018/5/13
     */
    public String toCollegeUpdate() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Map<String,Object> mapCollegeUp=new HashMap<String, Object>();
        mapCollegeUp.put("NAME",toUpCollegeName);
        if (collegeService != null){
            collegeList=collegeService.findByCondition(mapCollegeUp);
            if (collegeList.size() > 0){
                req.setAttribute("collegeListUp",collegeList.get(0));
            }
        }
        return "collegeUpdatePage";
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
        String result="collegeUpdatePage";

        Integer rows=0;
        College collegeUp=null;

        String collegeNameUp=req.getParameter("collegeNameUp");
        String collegeStuNumUp=req.getParameter("collegeStuNumUp");
        String collegeTeacherNumUp=req.getParameter("collegeTeacherNumUp");

        //修改学院
            try {
                collegeUp.setName(collegeNameUp);
                collegeUp.setStudentsNumber(Integer.valueOf(collegeStuNumUp));
                collegeUp.setTeachersNumber(Integer.valueOf(collegeTeacherNumUp));
                collegeUp.setUpdateTime(FormatUtils.now());
                if (collegeService != null){
                    rows=collegeService.update(collegeUp);
                }
                if (rows > 0 && collegeUp != null){
                    result="collegePage";
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        return result;
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDelcollegeId() {
        return delcollegeId;
    }

    public void setDelcollegeId(String delcollegeId) {
        this.delcollegeId = delcollegeId;
    }

    public String getCollege_currnt() {
        return college_currnt;
    }

    public void setCollege_currnt(String college_currnt) {
        this.college_currnt = college_currnt;
    }

    public String getNewAddCollegeName() {
        return newAddCollegeName;
    }

    public void setNewAddCollegeName(String newAddCollegeName) {
        this.newAddCollegeName = newAddCollegeName;
    }

    public String getToUpCollegeName() {
        return toUpCollegeName;
    }

    public void setToUpCollegeName(String toUpCollegeName) {
        this.toUpCollegeName = toUpCollegeName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}