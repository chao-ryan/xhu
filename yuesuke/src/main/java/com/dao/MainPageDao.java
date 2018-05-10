package com.dao;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.dao
 * @author dengchao
 * @date 2018/3/25 22:44
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.MainPage;

import java.util.List;

/**
 * @author dengchao
 * @InterfaceName MainPageDao
 * @Description 接口描述
 * @date 2018/3/25
 */
public interface MainPageDao {
    /**
     * @Title: findMainPageInventoryAll
     * @Description: 查询所有订单的价格，数量，以及商品的ID
     * @author dengchao
     * @date 2018/3/25
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageInventoryAll();

    /**
     * @Title: findMainPageInventory
     * @Description: 查询指定订单的价格，数量，以及商品的ID
     * @author dengchao
     * @date 2018/3/25
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageInventory(Long start, Long end);

    /**
     * @Title: findMainPageCondition
     * @Description: 根据条件查询主页面的显示
     * @author dengchao
     * @date 2018/3/25
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageCondition(String condition);

    /**
     * @Title: findMainPageByStoreId
     * @Description: 根据商品id查找商品信息
     * @author dengchao
     * @date 2018/3/25
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageByStoreId(Long storeId);

    /**
     * @param type 商品类型
     * @Title: findMainPageClassify
     * @Description: 分类查询
     * @author dengchao
     * @date 2018/3/25
     * @throw YnCorpSysException
     */
    public List<MainPage> findMainPageClassify(Byte type);

}
