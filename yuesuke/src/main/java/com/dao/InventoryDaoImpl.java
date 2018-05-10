package com.dao;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.dao
 * @author dengchao
 * @date 2018/3/22 22:44
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Inventory;
import com.service.GoodsService;
import com.service.InventoryService;
import com.service.StoreService;
import com.util.base.BaseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName inventoryDaoImpl
 * @Description 库存数据库操作类实现inventoryDao
 * @date 2018/3/22
 */
@Repository("InventoryDao")
public class InventoryDaoImpl extends BaseDaoImpl<Inventory> implements InventoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private InventoryService inventoryService;

    /**
     * @Title: saveInventory
     * @Description: 保存库存信息
     * @author dengchao
     * @date 2018/3/22
     * @param: inventory 库存对象
     * @return: 受影响行数
     */
    @Override
    public Integer saveInventory(Inventory inventory) {
        return this.sqlSessionTemplate.insert(getMybaitsNameSpace() + "saveInventory", inventory);
    }

    /**
     * @Title: findInventoryById
     * @Description: 查找库存信息通过指定id
     * @author dengchao
     * @date 2018/3/22
     * @param: id 指定id
     * @return: 库存对象
     */
    @Override
    public Inventory findInventoryById(Long id) {
        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace() + "findInventoryById",id);
    }

    /**
     * @Title: findInventoryById
     * @Description: 查找库存信息通过指定id
     * @author dengchao
     * @date 2018/3/22
     * @param: id 指定id
     * @return: 库存对象
     */
    @Override
    public List<Inventory> findInventoryAll() {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findInventoryAll");
    }

    /**
     * @Title: deleteInventoryById
     * @Description: 删除库存信息 通过指定id
     * @author dengchao
     * @date 2018/3/22
     * @param: id 指定id
     * @return: 受影响行数
     */
    @Override
    public Integer deleteInventoryById(Long id) throws SQLException {
        return this.sqlSessionTemplate.delete(getMybaitsNameSpace() + "deleteinventoryById", id);
    }

    /**
     * @Title: updateInventorById
     * @Description: 更新库存信息通过指定id
     * @author dengchao
     * @date 2018/3/22
     * @param: id 指定id
     * @param: inventory 库存对象
     * @return: 受影响行数
     */
    @Override
    public Integer updateInventorById(Long id, Inventory inventory) throws SQLException {
        Map map=new HashMap();
        map.put("inventory", inventory);
        map.put("id", id);
        return this.sqlSessionTemplate.update(getMybaitsNameSpace() + "updateInventorById", map);
    }

    /**
     * @param storeId:商铺id
     * @param goodsId：商品id
     * @Title: findInventoryByStoreIdAndGoodId
     * @Description: 根据商铺id和商品id查找库存信息
     * @author dengchao
     * @date 2018/3/22
     * @throw RuntimeException
     */
    @Override
    public Inventory findInventoryByStoreIdAndGoodsId(Long storeId, Long goodsId) {
        Map map = new HashMap();
        map.put("storeId",storeId);
        map.put("goodsId", goodsId);
        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace() + "findInventoryByStoreIdAndGoodsId",map);
    }

    /**
     * @param map 条件和值对应key和value
     * @Title: findInventoryByUnSureCondition
     * @Description: 通过商铺id查找库存信息
     * @author dengchao
     * @date 2018/3/22
     * @throw SQLException
     */
    public List<Inventory> findInventoryByUnSureCondition(List<Map<String, Object>> map)
            throws SQLException {
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findInventoryByUnSureCondition",map);
    }

}
