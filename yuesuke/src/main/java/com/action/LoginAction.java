package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/12 10:03
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Account;
import com.domain.Students;
import com.opensymphony.xwork2.ActionContext;
import com.service.AccountService;
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
 * @ClassName LoginAction
 * @Description 登录Action
 * @date 2018/5/12
 */
@Action(value = "login")
@Results({
        @Result(name = "mainPage",location = "/jsp/mainPage.jsp"),
        @Result(name = "loginPage",location = "/jsp/login.jsp"),
        @Result(name = "personSetting",location = "/jsp/personSetting.jsp"),
        @Result(name = "failed",location = "/jsp/404.jsp")
})
public class LoginAction extends BaseAction {
    @Autowired
    AccountService accountService;
    @Autowired
    StudentsService studentsService;
    private String stuAccount;
    private String stuIdNumber;
    private String stuIdNum;

    /**
     * @Title: loginPage
     * @Description: 登录页面
     * @author dengchao
     * @date 2018/5/12
     */
    public String loginPage() throws UnsupportedEncodingException {
        //设置编码字符集
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpServletRequest request= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);

        String result="";
        Map<String,Object> mapAccount=new HashMap<String, Object>();
        Map<String,Object> mapStudent=new HashMap<String, Object>();
        if (accountService != null && studentsService != null){
            mapAccount.put("ACCOUNT_NUMBER",stuAccount);
            mapStudent.put("ID_NUMBER",stuIdNumber);
            List<Account> accountList=accountService.findByCondition(mapAccount);
            if (accountList.size() > 0){
                List<Students> studentsList=studentsService.findByCondition(mapStudent);
                if (studentsList.size() == 1){
                    req.setAttribute("stuAccount",stuAccount);
                    req.setAttribute("stuIdNumber",stuIdNumber);
                    stuIdNum=studentsList.get(0).getIdNumber();
                    request.getSession().setAttribute("stuIdNum",stuIdNum);
//                    request.setAttribute("stuIdNum",studentsList.get(0).getIdNumber());
//                        req.getRequestDispatcher("/personSetting!person.do").forward(req,resp);
                    result="personSetting";
                }else {
                    result="failed";
                }
            }else {
                result="failed";
            }
        }else {
            result="loginPage";
        }
        return result;
    }

    public String getStuAccount() {
        return stuAccount;
    }

    public void setStuAccount(String stuAccount) {
        this.stuAccount = stuAccount;
    }

    public String getStuIdNumber() {
        return stuIdNumber;
    }

    public void setStuIdNumber(String stuIdNumber) {
        this.stuIdNumber = stuIdNumber;
    }

    public String getStuIdNum() {
        return stuIdNum;
    }

    public void setStuIdNum(String stuIdNum) {
        this.stuIdNum = stuIdNum;
    }
}