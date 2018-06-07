package com.service;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.service
 * @author dengchao
 * @date 2018/5/26 22:52
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.dao.SchoolingDaoImpl;
import com.domain.Schooling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dengchao
 * @ClassName SchoolingServiceImpl
 * @Description 学杂费Service实现类
 * @date 2018/5/26
 */
@Service("schoolingService")
public class SchoolingServiceImpl implements SchoolingService {
    //注入schoolingDao
    @Autowired
    private SchoolingDaoImpl schoolingDao;

    /**
     * @Title: save
     * @Description: 保存
     * @author dengchao
     * @date 2018/5/26
     */
    @Override
    public Integer save(Schooling schooling) {
        return schoolingDao.save(schooling);
    }

    /**
     * @Title: findById
     * @Description: 根据id查询
     * @author dengchao
     * @date 2018/5/26
     */
    @Override
    public Schooling findById(Long id) {
        return schoolingDao.findById(id);
    }
}