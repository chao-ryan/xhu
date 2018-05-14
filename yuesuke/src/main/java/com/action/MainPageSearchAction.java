package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/14 20:48
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.MainPage;
import com.service.InventoryService;
import com.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author dengchao
 * @ClassName MainPageSearchAction
 * @Description 跳蚤-主页-搜索
 * @date 2018/5/14
 */
@Action(value = "mainSearch")
@Results({
        @Result(name = "mainSearchPage",location = "/jsp/main_page_search.jsp"),
        @Result(name = "failed",location = "/jsp/404.jsp")
})
public class MainPageSearchAction extends BaseAction {
    @Autowired
    private InventoryService inventoryService;

    private String search;

    public String doPost() throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String result = "failed";

        //从数据库获取商品信息，显示在主页上
        List<MainPage> list = inventoryService.findMainPageCondition(search);

        HttpSession session = req.getSession();
        session.setAttribute("mainList", list);
        if (list != null && list.size() != 0) {
            session.setAttribute("mainList", list);
            result = "mainSearchPage";
//            resp.sendRedirect("../main_page_search.jsp");
        } else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("您所搜索的商品或者店铺不存在！");
            out.close();//关闭输出流
        }
        return result;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}