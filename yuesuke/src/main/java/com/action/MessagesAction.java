package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/20 16:37
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import com.wgh.model.UserInfo;
import com.wgh.servlet.UserListener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.apache.struts2.ServletActionContext.getServletContext;

/**
 * @author dengchao
 * @ClassName MessagesAction
 * @Description 聊天室Action
 * @date 2018/5/20
 */
@Action(value = "messages")
@Results({
        @Result(name = "content",location = "/jsp/content.jsp"),
        @Result(name = "login_ok",location = "/jsp/login_ok.jsp")
})
public class MessagesAction extends BaseAction{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    protected void processRequest() throws UnsupportedEncodingException {
        req.setCharacterEncoding("text/html;charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        if ("loginRoom".equals(action)) {	//登录时，写入系统公告
            this.loginRoom();
        } else if ("sendMessage".equals(action)) {	//发送聊天信息
            this.sendMessages();
        } else if ("getMessages".equals(action)) {		//从XML文件中读取聊天信息
            this.getMessages();
        }
    }
    // 将页面重定向到显示聊天信息的页面
    public String getMessages() {
        resp.setContentType("text/html;charset=UTF-8");

        String result="";
        try {
            result="content";
//            req.getRequestDispatcher("content.jsp").forward(req, resp);

        } catch (Exception ex) {
            Logger.getLogger(MessagesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // 登录时，写入系统公告

    public String loginRoom(){
        resp.setContentType("text/html;charset=UTF-8");

        String result="";

        HttpSession session = req.getSession();
        String username=req.getParameter("username");	//获得登录用户名
        UserInfo user=UserInfo.getInstance();		//获得UserInfo类的对象
        session.setMaxInactiveInterval(600);		//设置Session的过期时间为10分钟
        Vector vector=user.getList();
        boolean flag=true;		//标记是否登录的变量
        //判断用户是否登录
        System.out.println("vector的size："+vector.size());
        if(vector!=null&&vector.size()>0){
            for(int i=0;i<vector.size();i++){
                System.out.println("vector"+i+":"+vector.elementAt(i)+" user:"+username);
                if(username.equals(vector.elementAt(i))){
                    PrintWriter out;
                    try {
                        out = resp.getWriter();
                        out.println("<script language='javascript'>alert('该用户已经登录');window.location.href='index.jsp';</script>");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    flag=false;
                    break;
                }
            }
        }
        //保存用户信息
        if(flag){
            UserListener ul=new UserListener();					//创建UserListener的对象
            ul.setUser(username);								//添加用户
            user.addUser(ul.getUser());							//添加用户到UserInfo类的对象中
            session.setAttribute("user",ul);						//将UserListener对象绑定到Session中
            session.setAttribute("username",username);	//保存当前登录的用户名
            session.setAttribute("loginTime",new Date().toLocaleString());		//保存登录时间
            ServletContext application=getServletContext();

            String sourceMessage="";

            if(null!=application.getAttribute("message")){
                sourceMessage=application.getAttribute("message").toString();
            }
            sourceMessage+="系统公告：<font color='gray'>" + username + "走进了聊天室！</font><br>";
            application.setAttribute("message",sourceMessage);
            try {
                result="login_ok";
//                req.getRequestDispatcher("/jsp/login_ok.jsp").forward(req, resp);
            } catch (Exception ex) {
                Logger.getLogger(MessagesAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    // 发送聊天信息
    public String sendMessages() throws UnsupportedEncodingException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String result="";

        Random random = new Random();
        String from = req.getParameter("from"); //发言人
        String face = req.getParameter("face"); //表情
        String to = req.getParameter("to"); //接收者
        String color = req.getParameter("color"); //字体颜色
        String content = req.getParameter("content"); //发言内容
        String sendTime = new Date().toLocaleString(); //发言时间
        ServletContext application = getServletContext();
        String sourceMessage = application.getAttribute("message").toString();
        try {
            //发言时间
            sourceMessage += "<font color='blue'><strong>" + from + "</strong></font><font color='#CC0000'>" + face + "</font>对<font color='green'>[" + to + "]</font>说：" + "<font color='" + color + "'>" + content + "</font>（" + sendTime + "）<br>";
            application.setAttribute("message", sourceMessage);

            result="${pageContext.request.contextPath}/action/messages!processRequest.do?action=getMessages&nocache=" + random.nextInt(10000);
//            req.getRequestDispatcher("${pageContext.request.contextPath}/action/messages!processRequest.do?action=getMessages&nocache=" + random.nextInt(10000)).forward(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(MessagesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}