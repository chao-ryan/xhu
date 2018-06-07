package com.wgh.servlet;/********************************************************************
 /**
 * @Project: ChatRoom
 * @Package com.com.wgh.servlet
 * @author dengchao
 * @date 2018/5/20 18:12
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.wgh.model.UserInfo;

import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author dengchao
 * @ClassName UserListeners
 * @Description 类描述
 * @date 2018/5/20
 */
public class UserListener implements javax.servlet.http.HttpSessionBindingListener {
    private String user;
    private UserInfo container = UserInfo.getInstance();	//获得UserInfo类的对象

    public UserListener() {
        user = "";
    }

    // 设置在线监听人员
    public void setUser(String user) {
        this.user = user;
    }

    // 获取在线监听
    public String getUser() {
        return this.user;
    }

    // 当Session有对象加入时执行的方法
    public void valueBound(HttpSessionBindingEvent arg0) {
        System.out.println("上线用户：" + this.user);

    }

    // 当Session有对象移除时执行的方法
    public void valueUnbound(HttpSessionBindingEvent arg0) {
        System.out.println("下线用户：" + this.user);
        if (user != "") {
            container.removeUser(user);
        }
    }
}