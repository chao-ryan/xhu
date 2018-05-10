package com.action;
/**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/4/28 13:24
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Goods;
import com.domain.Inventory;
import com.service.GoodsService;
import com.service.InventoryService;
import com.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
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
 * @ClassName StoreSetStockAction
 * @Description 类描述
 * @date 2018/4/28
 */
@Action(value = "storeSetStockAction")
@Results({
        @Result( name="selectStoreGoods",location="/store_set_stock.jsp"),
        @Result( name="storeSetStock",location="/store_set_stock.jsp")
})
@AllowedMethods({"selectStoreGoods","storeSetStock"})
public class StoreSetStockAction  extends BaseAction {
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private GoodsService goodsService;

    /**
     * @Title:
     * @Description: 进入进货页面方法
     * @author dengchao
     * @date 2018/4/28
     */
    public String selectStoreGoods(){
        //设置编码集
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");

        //接收storeId
        Long  storeId =Long.valueOf(req.getParameter("storeId"));
        String result = "";

        List<Goods> goodsList=new ArrayList<Goods>();
        goodsList=goodsService.findGoodsAll();

//        通过迭代循环找出商铺商品库存 新建
        List<Object> map=new ArrayList<Object>();
        for(Goods goods:goodsList){
            try {
                Inventory inventory=inventoryService.findInventoryByStoreIdAndGoodsId(storeId,goods.getId());
                if (inventory!=null) {
                    List<Object> iAndGoods=new ArrayList<Object>();
                    iAndGoods.add(inventory);
                    iAndGoods.add(goods);
                    map.add(iAndGoods);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        HttpSession session=req.getSession();
        session.setAttribute("map",map);

        return "selectStoreGoods";
    }
    /**
     * @Title:
     * @Description: 进货页面方法
     * @author dengchao
     * @date 2018/4/28
     */
    public String storeSetStock(){
        //设置编码集
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");

        return "storeSetStock";
    }
}