package com.dao;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.dao
 * @author dengchao
 * @date 2018/3/20 22:12
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author dengchao
 * @ClassName dao
 * @Description 基本dao类，用于继承
 * @date 2018/3/20
 */
public class BaseDao<E> {
    //注入帮助类实例bean
    @Resource
    protected SqlSessionTemplate sqlSessionTemplate;
    //获取E的Class对象是关键，这里赋值为null，为了实现延迟加载
    private Class<E> cls=null;

    /**
     * 构造函数
     */
    public BaseDao() {
        Class cla=this.getClass();
        ParameterizedType type= (ParameterizedType) cla.getGenericSuperclass();
        Type[] types=type.getActualTypeArguments();
        cls= (Class<E>) types[0];
    }

    /**
     * @Title: getMybatisNameSpace
     * @Description: 获取命名空间   namespace+"."+id
     * @author dengchao
     * @date 2018/3/20
     */
    public String getMybatisNameSpace(){
        return cls.getName()+".";
    }
}