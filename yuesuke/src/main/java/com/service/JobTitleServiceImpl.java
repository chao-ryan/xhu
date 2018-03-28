package com.service;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.service
 * @author dengchao
 * @date 2018/3/28 21:24
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.dao.JobTitleDao;
import com.domain.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName JobTitleServiceImpl
 * @Description 教师职称 service 实现类
 * @date 2018/3/28
 */
@Service("jobTitleService")
public class JobTitleServiceImpl implements JobTitleService {
    //注入jobTitleDao
    @Autowired
    private JobTitleDao jobTitleDao;
    /**
     * @Title: deleteById
     * @Description: 根据id删除数据
     * @author dengchao
     * @param id 需要删除的行id
     * @return 返回受影响行数
     * @date 2018/3/28
     */
    public Integer deleteById(Long id){
        return jobTitleDao.deleteById(id);
    }
    /**
     * @Title: deleteByIds
     * @Description: 根据多个id删除多个
     * @author dengchao
     * @param ids 需要删除的ids数组
     * @return 返回受影响行数
     * @date 2018/3/28
     */
    public Integer deleteByIds(Long[] ids){
        return jobTitleDao.deleteByIds(ids);
    }
    /**
     * @Title: save
     * @Description: 保存/添加
     * @author dengchao
     * @param jobTitle 需要保存/添加的classInfo对象
     * @return 返回受影响行数
     * @date 2018/3/28
     */
    public Integer save(JobTitle jobTitle){
        return jobTitleDao.save(jobTitle);
    }
    /**
     * @Title: update
     * @Description: 修改/更新
     * @author dengchao
     * @param jobTitle 需要修改/更新的classInfo对象
     * @return 返回受影响行数
     * @date 2018/3/28
     */
    public Integer update(JobTitle jobTitle){
        return jobTitleDao.update(jobTitle);
    }
    /**
     * @Title: findById
     * @Description: 根据id查找
     * @author dengchao
     * @param id 需要查询的对象id
     * @return 返回查询结果对象
     * @date 2018/3/28
     */
    public JobTitle findById(Long id){
        return jobTitleDao.findById(id);
    }
    /**
     * @Title: findByCondition
     * @Description: 根据条件查询
     * @author dengchao
     * @param map 查询的条件（键值对）
     * @return 返回查询结果对象list集合
     * @date 2018/3/28
     */
    public List<JobTitle> findByCondition(Map<String, Object> map){
        return jobTitleDao.findByCondition(map);
    }
    /**
     * @Title: findByConditionForPage
     * @Description: 根据条件分页查询
     * @author dengchao
     * @param map 查询的条件（键值对）
     * @param start 分页查询开始页
     * @param size 分页查询页数
     * @return 返回查询结果list集合
     * @date 2018/3/28
     */
    public List<JobTitle> findByConditionForPage(Map<String, Object> map, Integer start, Integer size){
        return jobTitleDao.findByConditionForPage(map,start,size);
    }
}