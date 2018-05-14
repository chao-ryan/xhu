package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/14 21:11
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.MainPage;
import com.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dengchao
 * @ClassName CarPageAction
 * @Description 跳蚤-购物车
 * @date 2018/5/14
 */
@Action(value = "cartPage")
@Results({
        @Result(name = "cart",location = "/jsp/cart.jsp")
})
public class CartPageAction extends BaseAction{

    /**
     * The word of op whose the type is String that is A method of option
     */
    private String op;

    /**
     * @Title: doPost
     * @Description: 传输数据
     * @author dengchao
     * @date 2018/5/14
     * @throw YnCorpSysException
     */
    public void doPost() throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if ("add".equals(op)) {
            add(req, resp);
        } else if ("list".equals(op)) {
            list(req, resp);
        }
    }

    /**
     * @Title: add
     * @Description: 将主页获取的数据传到购物车页面
     * @author dengchao
     * @date 2018/5/14
     * @throw YnCorpSysException
     */
    public String add(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String inventoryId = req.getParameter("idName");
        String name = req.getParameter("nameName");
        String price = req.getParameter("priceName");
        String number = req.getParameter("numberName");
        String storeName = req.getParameter("storeNameName");
        MainPage mainPage = new MainPage();
        mainPage.setinventoryId(Long.valueOf(inventoryId));
        mainPage.setName(name);
        mainPage.setPrice(Double.valueOf(price));
        mainPage.setNumber(Double.valueOf(number));
        mainPage.setStoreName(storeName);

        HttpSession session = req.getSession();
        List<MainPage> cartList = new ArrayList<MainPage>();
        cartList = (List<MainPage>) session.getAttribute("cartList");
        if (cartList == null) {
            cartList = new ArrayList<MainPage>();
        }
        cartList.add(mainPage);

        session.setAttribute("cartList", cartList);
        req.setAttribute("cartList", cartList);
        return "cart";
//        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    //获取信息
    public String list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<MainPage> cartList = new ArrayList<MainPage>();
        cartList = (List<MainPage>) session.getAttribute("cartList");
        req.setAttribute("cartList", cartList);
//        System.out.println(cartList);
        return "cart";
//        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
}