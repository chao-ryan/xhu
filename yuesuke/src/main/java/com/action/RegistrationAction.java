package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/14 21:35
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.People;
import com.service.PeopleService;
import com.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author dengchao
 * @ClassName RegistrationAction
 * @Description 跳蚤市场-注册
 * @date 2018/5/14
 */
@Action(value = "registration")
@Results({
        @Result(name = "registration_page",location = "/jsp/registration_page.jsp")
})
public class RegistrationAction extends BaseAction {
    @Autowired
    private PeopleService peopleService;

    /**
     * @Title: doPost
     * @Description: post请求
     * @author dengchao
     * @date 2018-05-14
     * @throw ServletException, IOException
     * @param: req request对象
     * @param: resp response对象
     */
    protected String doPost() throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String result="";

        String userName = req.getParameter("username");
        String name = req.getParameter("name");
        String pwd = req.getParameter("password");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String idd = req.getParameter("idCard");
        String ads = req.getParameter("address");
        String amt = req.getParameter("amount");

//        将person的信息存入数据库，调用peopleService 的save方法
        People people1 = new People();
        people1.setUsreName(userName);
        people1.setName(name);
        people1.setSex(sex);
        people1.setCardId(idd);
        people1.setAddress(ads);
        people1.setPassWord(pwd);
        if (age.equals("") != true && age != null) {
            people1.setAge(Integer.valueOf(age));
        }
        if (amt.equals("") != true && amt != null) {
            people1.setMoney(Double.valueOf(amt));
        }
        Integer line = peopleService.savePeople(people1);

        if (line == null) {
//            System.out.println("注册失败");
//            resp.sendRedirect("../registration_page.jsp");
            result="registration_page";
        } else if (line == 0) {
//            System.out.println("注册失败");
//            resp.sendRedirect("../registration_page.jsp");
            result="registration_page";
        } else {
            //注册成功直接转登录页面
//            System.out.println("注册成功");
//            resp.sendRedirect(req.getContextPath()+"/login_page.jsp");
            result="registration_page";
        }
        return result;
    }
}