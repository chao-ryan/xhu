package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/14 17:41
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.People;
import com.google.gson.Gson;
import com.service.PeopleService;
import com.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author dengchao
 * @ClassName LoginPageAction
 * @Description 跳蚤-登录
 * @date 2018/5/14
 */
@Action(value = "loginPage")
@Results({
        @Result(name = "loginPage",location = "/jsp/login_page.jsp")
})
public class LoginPageAction extends BaseAction{
    @Autowired
    private PeopleService peopleService;

    private String username;
    private String password;
    private People person;

    public String doPost() throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String result="";

        person = peopleService.findPeopleByUserName(username, password);
        if (person == null) {
            req.getSession().setAttribute("LoginMessage", "error");
            result="loginPage";
//            resp.sendRedirect("../login_page.jsp");
        } else {
            req.getSession().removeAttribute("LoginMessage");
            req.getSession().setAttribute("person", person);
//            resp.sendRedirect("/mainAction!main.do");
//            resp.setCharacterEncoding("UTF-8");
//            resp.setContentType("text/html;charset=UTF-8");
//
            PrintWriter out = resp.getWriter();
//
            HashMap<String,String> hashMap=new HashMap<String, String>();
            hashMap.put("MESSAGE","登陆成功");
            Gson gson=new Gson();
            out.print(gson.toJson(hashMap));
//            //关闭流
            out.flush();
            out.close();
        }
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public People getPerson() {
        return person;
    }

    public void setPerson(People person) {
        this.person = person;
    }
}