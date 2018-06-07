package com.dao;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.dao
 * @author dengchao
 * @date 2018/5/26 22:41
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Schooling;

/**
 * @author dengchao
 * @ClassName SchoolingDao
 * @Description 学杂费表Dao
 * @date 2018/5/26
 */
public interface SchoolingDao {

    /**
     * save 保存
     * @param schooling
     * @return 返回受影响行数
     */
    public Integer save(Schooling schooling);

    /**
     * update 修改
     * @param schooling
     * @return 返回受影响行数
     */
    public Integer update(Schooling schooling);

    /**
     * findById 根据id查询
     * @param id
     * @return 返回Schooling对象
     */
    public Schooling findById(Long id);
}