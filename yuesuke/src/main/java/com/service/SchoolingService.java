package com.service;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.service
 * @author dengchao
 * @date 2018/5/26 22:51
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Schooling;

/**
 * @author dengchao
 * @InterfaceName SchoolingService
 * @Description 学杂费service
 * @date 2018/5/26
 */
public interface SchoolingService {

    /**
     * @Title: save
     * @Description: 保存
     * @author dengchao
     * @date 2018/5/26
     */
    public Integer save(Schooling schooling);

    /**
     * @Title: findById
     * @Description: 根据id查询
     * @author dengchao
     * @date 2018/5/26
     */
    public Schooling findById(Long id);
}