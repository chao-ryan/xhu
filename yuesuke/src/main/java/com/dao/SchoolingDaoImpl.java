package com.dao;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.dao
 * @author dengchao
 * @date 2018/5/26 22:19
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Schooling;
import org.springframework.stereotype.Repository;

/**
 * @author dengchao
 * @ClassName SchoolingDao
 * @Description 学杂费表DaoImpl
 * @date 2018/5/26
 */
@Repository
public class SchoolingDaoImpl extends BaseDao<Schooling> implements SchoolingDao {

    @Override
    public Integer save(Schooling schooling) {
        return super.sqlSessionTemplate.insert(getMybatisNameSpace()+"save",schooling);
    }

    @Override
    public Integer update(Schooling schooling) {
        return super.sqlSessionTemplate.update(getMybatisNameSpace()+"update",schooling);
    }

    @Override
    public Schooling findById(Long id) {
        return super.sqlSessionTemplate.selectOne(getMybatisNameSpace()+"findById",id);
    }
}