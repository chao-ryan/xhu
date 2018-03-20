package com.dao;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.dao
 * @author dengchao
 * @date 2018/3/20 22:44
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Account;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName AccountDaoImpl
 * @Description 学号/账号类dao实现类
 * @date 2018/3/20
 */
public class AccountDaoImpl extends BaseDao<Account> implements AccountDao{
    /**
     * @Title: deleteById
     * @Description: 根据id删除数据
     * @author dengchao
     * @param id 需要删除的行id
     * @return 返回受影响行数
     * @date 2018/3/20
     */
    @Override
    public Integer deleteById(Long id) {
        return super.sqlSessionTemplate.delete(getMybatisNameSpace()+"deleteById",id);
    }
    /**
     * @Title: deleteByIds
     * @Description: 根据多个id删除多个
     * @author dengchao
     * @param ids 需要删除的ids数组
     * @return 返回受影响行数
     * @date 2018/3/20
     */
    @Override
    public Integer deleteByIds(Long[] ids) {
        return super.sqlSessionTemplate.delete(getMybatisNameSpace()+"deleteByIds",ids);
    }
    /**
     * @Title: save
     * @Description: 保存/添加
     * @author dengchao
     * @param account 需要保存/添加的Account对象
     * @return 返回受影响行数
     * @date 2018/3/20
     */
    @Override
    public Integer save(Account account) {
        return super.sqlSessionTemplate.insert(getMybatisNameSpace()+"save",account);
    }
    /**
     * @Title: update
     * @Description: 修改/更新
     * @author dengchao
     * @param account 需要修改/更新的Account对象
     * @return 返回受影响行数
     * @date 2018/3/20
     */
    @Override
    public Integer update(Account account) {
        return super.sqlSessionTemplate.update(getMybatisNameSpace()+"update",account);
    }
    /**
     * @Title: findById
     * @Description: 根据id查找
     * @author dengchao
     * @param id 需要查询的对象id
     * @return 返回查询结果对象
     * @date 2018/3/20
     */
    @Override
    public Account findById(Long id) {
        return super.sqlSessionTemplate.selectOne(getMybatisNameSpace()+"findById",id);
    }
    /**
     * @Title: findByCondition
     * @Description: 根据条件查询
     * @author dengchao
     * @param map 查询的条件（键值对）
     * @return 返回查询结果对象list集合
     * @date 2018/3/20
     */
    @Override
    public List<Account> findByCondition(Map<String, Object> map) {
        return super.sqlSessionTemplate.selectList(getMybatisNameSpace()+"findByCondition",map);
    }
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
    @Override
    public List<Account> findByConditionForPage(Map<String, Object> map, Integer start, Integer size) {
        RowBounds rowBounds=new RowBounds(start,size);
        return super.sqlSessionTemplate.selectList(getMybatisNameSpace()+"findByConditionForPage",map,rowBounds);
    }
}