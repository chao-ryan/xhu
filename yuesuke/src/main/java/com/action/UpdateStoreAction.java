package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/4/28 13:24
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Store;
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
 * @ClassName UpdateStoreAction
 * @Description 类描述
 * @date 2018/4/28
 */
@Action(value = "updateStoreAction")
@Results({
        @Result(name = "adminUser",location = "/administrator_page.jsp")
})
//@AllowedMethods({"updateStore"})
public class UpdateStoreAction extends BaseAction {
    @Autowired
    private StoreService storeService;

    /**
     * @Title: updateStore
     * @Description: 修改店铺信息
     * @author dengchao
     * @date 2018/4/28
     * @return: String
     */

    public String updateStore(){
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        //获取店铺信息
        String id=req.getParameter("storeId");
        String storeNum=req.getParameter("storeNum");
        String storeName=req.getParameter("storeName");
        String credit=req.getParameter("credit");
        String peopleId=req.getParameter("peopleId");
        //生成对象
        Store store=new Store();
        store.setId(Long.valueOf(id));
        store.setStoreNum(storeNum);
        store.setStoreName(storeName);
        store.setCredit(Long.valueOf(credit));
        store.setPeopleId(Long.valueOf(peopleId));
        //获取storeService
//        StoreService storeService= (StoreService) SpringContextUtil.getBean("storeService");
        storeService.updateStoreById(store.getId(),store);
        //获取store集合
        HttpSession session=req.getSession();
        session.removeAttribute("storeList");
        List<Store> storeList=new ArrayList<Store>();
        try {
            storeList=storeService.findAllStore();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("storeList",storeList);
        req.setAttribute("updStore",store);
        return "adminUser";
    }
}