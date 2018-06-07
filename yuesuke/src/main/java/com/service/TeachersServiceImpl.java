package com.service;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.service
 * @author dengchao
 * @date 2018/3/28 22:53
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.dao.StudentsDao;
import com.dao.TeachersDao;
import com.domain.Students;
import com.domain.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName TeachersServiceImpl
 * @Description 教师信息 service 实现类
 * @date 2018/3/28
 */
@Service("teachersService")
public class TeachersServiceImpl implements TeachersService {
    //注入 teachersDao
    @Autowired
    private TeachersDao teachersDao;
    //注入studentsDao
    @Autowired
    private StudentsDao studentsDao;
    /**
     * @Title: deleteById
     * @Description: 根据id删除数据
     * @author dengchao
     * @param id 需要删除的行id
     * @return 返回受影响行数
     * @date 2018/3/28
     */
    public Integer deleteById(Long id){
        return teachersDao.deleteById(id);
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
        return teachersDao.deleteByIds(ids);
    }
    /**
     * @Title: save
     * @Description: 保存/添加
     * @author dengchao
     * @param teachers 需要保存/添加的classInfo对象
     * @return 返回受影响行数
     * @date 2018/3/28
     */
    public Integer save(Teachers teachers){
        return teachersDao.save(teachers);
    }
    /**
     * @Title: update
     * @Description: 修改/更新
     * @author dengchao
     * @param teachers 需要修改/更新的classInfo对象
     * @return 返回受影响行数
     * @date 2018/3/28
     */
    public Integer update(Teachers teachers){
        return teachersDao.update(teachers);
    }
    /**
     * @Title: findById
     * @Description: 根据id查找
     * @author dengchao
     * @param id 需要查询的对象id
     * @return 返回查询结果对象
     * @date 2018/3/28
     */
    public Teachers findById(Long id){
        return teachersDao.findById(id);
    }
    /**
     * @Title: findByCondition
     * @Description: 根据条件查询
     * @author dengchao
     * @param map 查询的条件（键值对）
     * @return 返回查询结果对象list集合
     * @date 2018/3/28
     */
    public List<Teachers> findByCondition(Map<String, Object> map){
        return teachersDao.findByCondition(map);
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
    public List<Teachers> findByConditionForPage(Map<String, Object> map, Integer start, Integer size){
        return teachersDao.findByConditionForPage(map,start,size);
    }

    /**
     * @Title: updateStuAuthority
     * @Description: 修改学生操作权限
     * @param stuIdNumber 要修改操作权限的学生身份证号
     * @param authorityValue 操作权限等级
     * @author dengchao
     * @return 返回受影响行数
     * @date 2018/5/26
     */
    @Override
    public Integer updateStuAuthority(String stuIdNumber,Byte authorityValue) {
        Integer rows=0;
        Map<String,Object> upStuAuthorityMap=new HashMap<String, Object>();
        upStuAuthorityMap.put("ID_NUMBER",stuIdNumber);
        List<Students> studentsList=null;
        //根据学生身份证号查询
        if (studentsDao != null){
            studentsList=studentsDao.findByCondition(upStuAuthorityMap);
        }
        //查询结果有效
        if (studentsList.size() == 1){
            Students students=studentsList.get(0);
            //修改学生操作权限
            students.setAuthority(authorityValue);
            //执行修改
            if (studentsDao != null){
                rows=studentsDao.update(students);
            }
        }
        return rows;
    }
}