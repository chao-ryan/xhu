package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/5 13:24
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.People;
import com.domain.Store;
import com.service.PeopleService;
import com.service.StoreService;
import com.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dengchao
 * @ClassName AdminUserAction
 * @Description 用户管理
 * @date 2018/5/5
 */
@Action(value = "adminUserAction")
@Results({
        @Result(name = "updatePeople",location = "/jsp/update_people.jsp"),
        @Result(name = "updateStore",location = "/jsp/update_store.jsp"),
        @Result(name = "success",location = "/jsp/administrator_page.jsp")
})
//@AllowedMethods({"findPeopleAll","findStoreAll","deletePeople","deleteStore","updatePeople","updateStore"})
public class AdminUserAction extends BaseAction {
    @Autowired
    private PeopleService peopleService;
    @Autowired
    private StoreService storeService;

    private String command;
    private String peopleId;
    private String storeId;
    /**
     * @Title: findPeopleAll
     * @Description: 查找所有人员信息
     * @author dengchao
     * @date 2018/5/5
     * @return: SUCCESS
     */
    public String findPeopleAll(){
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
//        String command=req.getParameter("command");
        //获取人员信息集合
        List<People> peopleList=new ArrayList<People>();
        peopleList=peopleService.getAllPeople();
//            req.setAttribute();
        //保存人员信息集合到session中
        HttpSession session=req.getSession();
//        session.removeAttribute("peopleList");
        session.setAttribute("peopleList",peopleList);
        return SUCCESS;
    }

    /**
     * @Title: findStore
     * @Description: 查找店铺信息并保存到session中
     * @author dengchao
     * @date 2018/5/5
     * @return: SUCCESS
     */
    public String findStoreAll() throws UnsupportedEncodingException {
        //修改编码方式
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        //获取人员信息店铺集合
        List<Store> storeList=new ArrayList<Store>();
        try {
            storeList=storeService.findAllStore();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //保存人员信息集合到session中
        HttpSession session=req.getSession();
        session.setAttribute("storeList",storeList);
        return SUCCESS;
    }

    /**
     * @Title: deletePeople
     * @Description: 删除指定id的人员
     * @author dengchao
     * @date 2018/5/5
     * @return: SUCCESS
     */
    public void deletePeople(){
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");

        //删除人员信息
        peopleService.deletePeopleById(Long.valueOf(peopleId));
        //替换session peopleList信息
        HttpSession session=req.getSession();
        List<People> peopleList=new ArrayList<People>();
        peopleList=peopleService.getAllPeople();
        session.removeAttribute("peopleList");
        session.setAttribute("peopleList",peopleList);
//        return SUCCESS;
    }

    /**
     * @Title: deleteStore
     * @Description: 删除指定id店铺
     * @author dengchao
     * @date 2018/5/5
     * @return: SUCCESS
     */

    public void deleteStore(){
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");

        //获取人员信息店铺集合
        List<Store> storeList=new ArrayList<Store>();

        //删除store信息
        storeService.deleteStoreById(Long.valueOf(storeId));
        //替换session storeList信息
        HttpSession session=req.getSession();
        try {
            storeList=storeService.findAllStore();
            session.removeAttribute("storeList");
            session.setAttribute("storeList",storeList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        return SUCCESS;
    }

    /**
     * @Title: updatePeople
     * @Description: 修改人员信息
     * @author dengchao
     * @date 2018/5/5
     * @return: String structs删选值
     */
    public String updatePeople(){
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        //获取需要修改 people信息
        HttpSession session=req.getSession();
        People updPeople=peopleService.findPeopleById(Long.valueOf(peopleId));
        session.setAttribute("updPeople",updPeople);
        return "updatePeople";
    }

    /**
     * @Title: updateStore
     * @Description: 修改店铺信息
     * @author dengchao
     * @date 2018/5/5
     * @return: String structs删选值
     */
    public String updateStore(){
        //修改编码方式
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        //获取人员信息店铺集合
        List<Store> storeList=new ArrayList<Store>();
        //修改store信息
        HttpSession session=req.getSession();
        Store updStore=storeService.findStoreById(Long.valueOf(storeId));
        session.setAttribute("updStore",updStore);
        return "updateStore";
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
}