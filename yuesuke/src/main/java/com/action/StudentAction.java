package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/13 17:50
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.*;
import com.opensymphony.xwork2.ActionContext;
import com.service.AccountService;
import com.service.ClassRelationService;
import com.service.RoomService;
import com.service.StudentsService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName StudentAction
 * @Description 信息管理-学生信息
 * @date 2018/5/13
 */
@Action(value = "student")
@Results({
        @Result(name = "student",location = "/jsp/studentPage.jsp"),
        @Result(name = "studentAdd",location = "/jsp/studentAddPage.jsp"),
        @Result(name = "studentUpdate",location = "/jsp/studentUpdatePage.jsp"),
        @Result(name = "failed",location = "/jsp/failed.jsp"),
        @Result(name = "404",location = "/jsp/404.jsp")
})
public class StudentAction extends BaseAction {
    @Autowired
    private StudentsService studentsService;
    @Autowired
    private ClassRelationService classRelationService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoomService roomService;

    private List<ClassRelation> relationList;

    private String stuAccount;
    private String toUpStuAccount;
    private String method;
    private String delStuId;
    private String state;
    private String stuIdNum;

    /**
     * @Title: classInfoShow
     * @Description: 信息管理-班级信息
     * @author dengchao
     * @date 2018/5/12
     */
    public String stuShow() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Map<String,Object> mapStu=new HashMap<String, Object>();
        //判断搜索框是否输入
        if (this.stuAccount != null && !("".equals(this.stuAccount))){
            mapStu.put("STU_ACCOUNT",this.stuAccount);
        }
        //判断需要修改的账号是否有效
        if (toUpStuAccount != null){
            mapStu.put("STU_ACCOUNT",toUpStuAccount);
        }
        //根据学生账号查询
        if (classRelationService != null){
            relationList=classRelationService.findByCondition(mapStu);
            if (relationList.size() > 0){
                req.setAttribute("relationList",relationList);
            }
        }
        return "student";
    }

    /**
     * @Title: delClass
     * @Description: 删除操作（权限-2）
     * @author dengchao
     * @date 2018/5/13
     */
    public void delStu(){
        Students studentsDel=null;
        Integer rows1=0;
        //判断是否需要执行删除操作
        if ("del".equals(this.method) && this.delStuId != null){
            if (studentsService != null){
                studentsDel=studentsService.findById(Long.valueOf(this.delStuId));
                //判断操作权限是否为 2
                if (studentsDel != null && studentsDel.getAuthority() == 2){
                    //只有权限为 2 的人员才能执行此操作
                    rows1=studentsService.deleteById(Long.valueOf(this.delStuId));
                }
            }
        }
    }
    /**
     * @Title: stuAdd
     * @Description: 信息管理-学生信息-添加
     * @author dengchao
     * @date 2018/5/13
     */
    public String stuAdd() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String result="studentAdd";
        Integer rowsAccount=0;
        Integer rowsStu=0;
        Integer rowsRelation=0;

        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        state= String.valueOf(request.getSession().getAttribute("state"));
        //接收用户登录成功的身份证号idNumber
        stuIdNum= String.valueOf(request.getSession().getAttribute("stuIdNum"));
        Map<String,Object> mapStu=new HashMap<String, Object>();
        List<Students> studentsList=null;
        Students studentsLogin=null;
        if (stuIdNum != null){
            mapStu.put("ID_NUMBER",stuIdNum);
        }
        if (studentsService != null){
            studentsList=studentsService.findByCondition(mapStu);
        }
        if (studentsList.size() == 1){
            studentsLogin=studentsList.get(0);
        }


        Students students=null;
        Account account=null;
        Room room=null;
        ClassRelation classRelation=null;
        String stuAccountAdd=req.getParameter("stuAccountAdd");
        String stuNameAdd=req.getParameter("stuNameAdd");
        String stuSexAdd=req.getParameter("stuSexAdd");
        String stuBirthAdd=req.getParameter("stuBirthAdd");
        String stuOriginAdd=req.getParameter("stuOriginAdd");
        String stuEnthnicAdd=req.getParameter("stuEnthnicAdd");
        String stuIdNumAdd=req.getParameter("stuIdNumAdd");
        String stuUniversityAdd=req.getParameter("stuUniversityAdd");
        String stuPhoneAdd=req.getParameter("stuPhoneAdd");
        String stuFamilyAdd=req.getParameter("stuFamilyAdd");
        String stuFatherNameAdd=req.getParameter("stuFatherNameAdd");
        String stuFatherPhoneAdd=req.getParameter("stuFatherPhoneAdd");
        String stuFatherAddressAdd=req.getParameter("stuFatherAddressAdd");
        String stuMotherNameAdd=req.getParameter("stuMotherNameAdd");
        String stuMotherPhoneAdd=req.getParameter("stuMotherPhoneAdd");
        String stuMotherAddressAdd=req.getParameter("stuMotherAddressAdd");
        String stuRoomIdAdd=req.getParameter("stuRoomIdAdd");

        //添加学号信息
        if (account == null){
            try {
                account=new Account();
                account.setAccountNumber(stuAccountAdd);
                account.setPassword("666666");
                account.setSaveTime(FormatUtils.now());
                account.setUpdateTime(FormatUtils.now());
                rowsAccount=accountService.save(account);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //查找宿舍信息
        if (stuRoomIdAdd != null && !("".equals(stuRoomIdAdd))){
            if (roomService != null){
                room=roomService.findById(Long.valueOf(stuRoomIdAdd));
            }
        }
        //添加学生信息
        //判断当前用户是否登录成功，判断登录用户权限是否为 2
        if ("success".equals(state) && studentsLogin.getAuthority() == 2){
            if (students == null && room != null && rowsAccount > 0){
                try {
                    students=new Students();
                    students.setName(stuNameAdd);
                    students.setBirthday(FormatUtils.dateFormStrYmd(stuBirthAdd));
                    students.setOrigin(stuOriginAdd);
                    students.setEnthnic(stuEnthnicAdd);
                    students.setIdNumber(stuIdNumAdd);
                    students.setGender(Byte.valueOf(stuSexAdd));
                    students.setPhone(stuPhoneAdd);
                    students.setUniversity(stuUniversityAdd);
                    students.setFamilyPopulation(Integer.valueOf(stuFamilyAdd));
                    students.setFatherName(stuFatherNameAdd);
                    students.setFatherPhone(stuFatherPhoneAdd);
                    students.setFatherAddress(stuFatherAddressAdd);
                    students.setMotherName(stuMotherNameAdd);
                    students.setMotherPhone(stuMotherPhoneAdd);
                    students.setMotherAddress(stuMotherAddressAdd);
                    students.setSaveTime(FormatUtils.now());
                    students.setUpdateTime(FormatUtils.now());
                    students.setAccountId(account);
                    students.setRoomId(room);
                    if (studentsService != null){
                        rowsStu=studentsService.save(students);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //添加关系表
                if (rowsStu > 0 && classRelation == null){
                    classRelation.setStudentsId(students);
                    if (classRelationService != null){
                        rowsRelation=classRelationService.save(classRelation);
                    }
                }
                //确定返回页面
                if (rowsRelation > 0){
                    result="student";
                }
            }
        }else {
            result="failed";
        }
        return result;
    }

    /**
     * @Title: toStuUpdate
     * @Description: 信息管理-学生信息->修改
     * @author dengchao
     * @date 2018/5/14
     */
    public String toStuUpdate() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Map<String,Object> mapStuUp=new HashMap<String, Object>();
        mapStuUp.put("STU_ACCOUNT",toUpStuAccount);
        if (classRelationService != null){
            relationList=classRelationService.findByCondition(mapStuUp);
            if (relationList.size() > 0){
                req.setAttribute("relationListUp",relationList.get(0));
            }
        }
        return "studentUpdate";
    }

    /**
     * @Title: classUpdate
     * @Description: 信息管理-学生信息-修改
     * @author dengchao
     * @date 2018/5/13
     */
    public String stuUpdate() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String result="studentUpdate";

        Integer rows=0;
        Integer rows2=0;

        Students students=null;
        Room room=null;
        ClassRelation classRelationUp=null;
        List<Teachers> teachersListUp=null;
        List<College> collegeListUp=null;
        List<Account> accountListUp=null;
        List<Students> studentsList=null;
        String stuNameUp=req.getParameter("stuNameUp");
        String stuSexUp=req.getParameter("stuSexUp");
        String stuBirthDayUp=req.getParameter("stuBirthDayUp");
        String stuOriginUp=req.getParameter("stuOriginUp");
        String stuEnthnicUp=req.getParameter("stuEnthnicUp");
        String stuIdNumUp=req.getParameter("stuIdNumUp");
        String stuPhoneUp=req.getParameter("stuPhoneUp");
        String stuFamilyUp=req.getParameter("stuFamilyUp");
        String stuFatherNameUp=req.getParameter("stuFatherNameUp");
        String stuFatherPhoneUp=req.getParameter("stuFatherPhoneUp");
        String stuFatherAddressUp=req.getParameter("stuFatherAddressUp");
        String stuMotherNameUp=req.getParameter("stuMotherNameUp");
        String stuMotherPhoneUp=req.getParameter("stuMotherPhoneUp");
        String stuMotherAddressUp=req.getParameter("stuMotherAddressUp");
        String stuRoomIdUp=req.getParameter("stuRoomIdUp");
        //查找学生信息
        if (studentsService != null){
            if (stuIdNumUp != null && !("".equals(stuIdNumUp))){
                Map<String,Object> mapStuNumIdUp=new HashMap<String, Object>();
                mapStuNumIdUp.put("ID_NUMBER",stuIdNumUp);
                studentsList=studentsService.findByCondition(mapStuNumIdUp);
            }
            if (studentsList.size() == 1){
                students=studentsList.get(0);
            }
        }
        //查找宿舍信息
        if (roomService != null){
            if (stuRoomIdUp != null && !("".equals(stuRoomIdUp))){
                room=roomService.findById(Long.valueOf(stuRoomIdUp));
            }
        }

        //修改学生信息,只有权限为 2 时可以修改
        if (students != null && room != null && students.getAuthority() == 2 ){
            try {
                students.setName(stuNameUp);
                students.setGender(Byte.valueOf(stuSexUp));
                students.setBirthday(FormatUtils.dateFormStrYmd(stuBirthDayUp));
                students.setOrigin(stuOriginUp);
                students.setEnthnic(stuEnthnicUp);
                students.setFamilyPopulation(Integer.valueOf(stuFamilyUp));
                students.setPhone(stuPhoneUp);
                students.setRoomId(room);
                students.setFatherName(stuFatherNameUp);
                students.setFatherPhone(stuFatherPhoneUp);
                students.setFatherAddress(stuFatherAddressUp);
                students.setMotherName(stuMotherNameUp);
                students.setMotherPhone(stuMotherPhoneUp);
                students.setMotherAddress(stuMotherAddressUp);
                students.setSaveTime(FormatUtils.now());
                students.setUpdateTime(FormatUtils.now());
                if (studentsService != null){
                    rows=studentsService.update(students);
                }
                if (rows > 0){
                    result="student";
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            result="failed";
        }
        return result;
    }



    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStuAccount() {
        return stuAccount;
    }

    public void setStuAccount(String stuAccount) {
        this.stuAccount = stuAccount;
    }

    public String getToUpStuAccount() {
        return toUpStuAccount;
    }

    public void setToUpStuAccount(String toUpStuAccount) {
        this.toUpStuAccount = toUpStuAccount;
    }

    public String getDelStuId() {
        return delStuId;
    }

    public void setDelStuId(String delStuId) {
        this.delStuId = delStuId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStuIdNum() {
        return stuIdNum;
    }

    public void setStuIdNum(String stuIdNum) {
        this.stuIdNum = stuIdNum;
    }


}