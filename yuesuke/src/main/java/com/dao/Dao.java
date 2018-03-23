package com.dao;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.dao
 * @author dengchao
 * @date 2018/3/23 22:18
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @InterfaceName Dao
 * @Description 泛型dao 用于实现
 * @date 2018/3/23
 */
public interface Dao<T> {
    /**
     * @Title: deleteById
     * @Description: 根据id删除数据
     * @author dengchao
     * @param id 需要删除的行id
     * @return 返回受影响行数
     * @date 2018/3/20
     */
    public Integer deleteById(Long id);
    /**
     * @Title: deleteByIds
     * @Description: 根据多个id删除多个
     * @author dengchao
     * @param ids 需要删除的ids数组
     * @return 返回受影响行数
     * @date 2018/3/20
     */
    public Integer deleteByIds(Long[] ids);
    /**
     * @Title: save
     * @Description: 保存/添加
     * @author dengchao
     * @param cla 需要保存/添加的E对象
     * @return 返回受影响行数
     * @date 2018/3/20
     */
    public Integer save(T cla);
    /**
     * @Title: update
     * @Description: 修改/更新
     * @author dengchao
     * @param cla 需要修改/更新的E对象
     * @return 返回受影响行数
     * @date 2018/3/20
     */
    public Integer update(T cla);
    /**
     * @Title: findById
     * @Description: 根据id查找
     * @author dengchao
     * @param id 需要查询的对象id
     * @return 返回查询结果对象
     * @date 2018/3/20
     */
    public T findById(Long id);
    /**
     * @Title: findByCondition
     * @Description: 根据条件查询
     * @author dengchao
     * @param map 查询的条件（键值对）
     * @return 返回查询结果对象list集合
     * @date 2018/3/20
     */
    public List<T> findByCondition(Map<String,Object> map);
    /**
     * @Title: findByConditionForPage
     * @Description: 根据条件分页查询
     * @author dengchao
     * @param map 查询的条件（键值对）
     * @param start 分页查询开始页
     * @param size 分页查询页数
     * @return 返回查询结果list集合
     * @date 2018/3/20
     */
    public List<T> findByConditionForPage(Map<String,Object> map,Integer start,Integer size);
}