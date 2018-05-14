package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/14 22:10
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

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

/**
 * @author dengchao
 * @ClassName OpenStoreAction
 * @Description 跳蚤-开店
 * @date 2018/5/14
 */
@Action(value = "openStore")
@Results({
        @Result(name = "failed",location = "/jsp/people_open_store.jsp")
})
public class OpenStoreAction extends BaseAction {
    @Autowired
    private StoreService storeService;

    private String peopleId;
    private String storeName;

    public String doPost() throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String result="";
        HttpSession session = req.getSession();

        //生成商铺编号
        String storeNum = UUID.randomUUID().toString().replaceAll("-", "");
//        System.out.println(storeNum);
        //给对象设值并插入数据
        Store newStore = new Store();
        newStore.setStoreName(storeName);
        newStore.setPeopleId(Long.valueOf(peopleId));
        newStore.setStoreNum(storeNum);
        newStore.setCredit(0L);
        Long storeId = storeService.saveStore(newStore);
        if (storeId != 0){
//            System.out.println("开通成功");
//            resp.sendRedirect("/store/storeHome.htm?peopleId=peopleId");
            result="${pageContext.request.contextPath}/action/storeHome!doPost.do?peopleId=peopleId";
        }else {
//            resp.sendRedirect("../people_open_store.jsp");
            result="failed";
//            System.out.println("插入失败");
        }
        return result;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}