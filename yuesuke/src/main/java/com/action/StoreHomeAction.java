package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/14 22:21
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Goods;
import com.domain.Inventory;
import com.domain.People;
import com.domain.Store;
import com.service.GoodsService;
import com.service.InventoryService;
import com.service.PeopleService;
import com.service.StoreService;
import com.util.AddConditionUtils;
import com.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName StoreHomeAction
 * @Description 跳转到商铺主页的servlet
 * @date 2018/5/14
 */
@Action(value = "storeHome")
@Results({
        @Result(name = "openStore",location = "/jsp/people_open_store.jsp"),
        @Result(name = "storeHome",location = "/jsp/store_home_page.jsp")
})
public class StoreHomeAction extends BaseAction {
    @Autowired
    private PeopleService peopleService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private GoodsService goodsService;

    private String peopleId;

    public String doPost() throws ServletException, IOException {
        String result="";
        HttpSession session = req.getSession();
        try {
            //一个人只能同时拥有一个店
            People people = new People();
            people = peopleService.findPeopleById(Long.valueOf(peopleId));
            if(people != null ){
                List<Map<String,Object>> map1 = new ArrayList<Map<String,Object>>();
                map1.add(AddConditionUtils.addCondition("people_Id", "=", peopleId));
                List<Store> stores = new ArrayList<Store>();
                stores = storeService.findStoreByUnSureCondition(map1);
                if (stores.size()==0){
                    session.setAttribute("people",people);
                    result="openStore";
//                    req.getRequestDispatcher("../people_open_store.jsp").forward(req,resp);
                }else{
                    //根据店铺id查找到库存信息
                    List<Inventory> inventories = new ArrayList<Inventory>();
                    List<Map<String,Object>> map2 = new ArrayList<Map<String,Object>>();
                    map2.add(AddConditionUtils.addCondition("store_id","=",stores.get(0).getId()));
                    inventories = inventoryService.findInventoryByUnSureCondition(map2);
                    //再根据库存编号中的商品id查找商品信息
                    List<Goods> goods = new ArrayList<Goods>();
                    for (int i = 0; i < inventories.size() ; i++) {
                        Goods good = new Goods();
                        good = goodsService.findGoodsById(inventories.get(i).getGoodsId());
                        goods.add(good);
                    }
                    session.setAttribute("stores",stores);
                    session.setAttribute("peoples",people);
                    session.setAttribute("inventories",inventories);
                    session.setAttribute("goods",goods);
                    result="storeHome";
//                    req.getRequestDispatcher("../store_home_page.jsp").forward(req,resp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }
}